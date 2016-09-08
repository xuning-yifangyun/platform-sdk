package com.fangcloud.sdk.request;

import com.fangcloud.sdk.bean.exception.ExternalErrorCode;
import com.fangcloud.sdk.bean.exception.OpenApiSDKException;
import com.fangcloud.sdk.bean.output.ErrorsInfo;
import com.fangcloud.sdk.core.Config;
import com.fangcloud.sdk.util.TransformationUtil;
import com.google.gson.Gson;
import org.apache.http.HttpResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by xuning on 2016/8/22.
 */
public class RequestIntercept {
    private static int sendRes = 0;
    private static String requestId;
    private static String code;
    private static String msg;
    private static Logger logger= LoggerFactory.getLogger(RequestIntercept.class);
    public static void ErrorInfoIntercept(HttpResponse httpResponse) {
        sendRes = httpResponse.getStatusLine().getStatusCode();

        String resJsonString = TransformationUtil.httpResponseToString(httpResponse);

        ErrorsInfo errorsInfo = new Gson().fromJson(resJsonString, ErrorsInfo.class);

        List<ErrorsInfo.ReponseErrorInfo> reponseErrorInfos = errorsInfo.getErrors();

        requestId = errorsInfo.getRequestId();

        code = reponseErrorInfos.get(0).getCode();

        msg = reponseErrorInfos.get(0).getMsg();

        if (Config.OPEN_LOG_OUTPUT) {
            String errorLog ="[error_code:" + code + "][request_id: " + requestId + "]";
            logger.error(errorLog);
        }

        if (null == resJsonString) {
            throw new OpenApiSDKException(ExternalErrorCode.REQUEST_NO_RESPONSE);
        }
        switch (sendRes) {
        case 0:
            throw new OpenApiSDKException(ExternalErrorCode.REQUEST_NO_RESPONSE);
        case 500:
            throw new OpenApiSDKException(ExternalErrorCode.NOT_KNOW_ERROR);
//        case 401:
//            break;
        case 200:
            break;
        default:
//            throw new OpenApiSDKException(code);
        }
    }

}
