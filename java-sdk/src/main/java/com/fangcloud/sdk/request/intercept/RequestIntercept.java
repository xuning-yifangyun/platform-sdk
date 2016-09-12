package com.fangcloud.sdk.request.intercept;

import com.fangcloud.sdk.bean.exception.ExternalErrorCode;
import com.fangcloud.sdk.bean.exception.OpenApiSDKException;
import com.fangcloud.sdk.bean.output.ErrorsInfo;
import com.fangcloud.sdk.util.TransformationUtil;
import com.fangcloud.sdk.util.log.Logger;
import com.fangcloud.sdk.util.log.LoggerFactory;
import com.google.gson.Gson;
import org.apache.http.HttpResponse;

import java.util.List;

/**
 * Created by xuning on 2016/8/22.
 */
public class RequestIntercept {
    private static int sendRes = 0;
    private static String requestId;
    private static String code;
    private static String msg;
    private static Logger logger = LoggerFactory.getLogger(RequestIntercept.class);

    public static void ErrorInfoIntercept(HttpResponse httpResponse) {
        sendRes = httpResponse.getStatusLine().getStatusCode();
        String resJsonString = TransformationUtil.httpResponseToString(httpResponse);
        ErrorsInfo errorsInfo=null;
        try{
            errorsInfo = new Gson().fromJson(resJsonString, ErrorsInfo.class);
        }catch (Exception e){
            throw new OpenApiSDKException(ExternalErrorCode.RESPONSE_BAD_GATEWAY);
        }


        List<ErrorsInfo.ReponseErrorInfo> reponseErrorInfos = errorsInfo.getErrors();
        requestId = errorsInfo.getRequestId();
        code = reponseErrorInfos.get(0).getCode();
        msg = reponseErrorInfos.get(0).getMsg();
        String errorLog = "[error_code:" + code + "][request_id: " + requestId + "]";
        if (null == resJsonString) {
            throw new OpenApiSDKException(ExternalErrorCode.REQUEST_NO_RESPONSE);
        }
        switch (sendRes) {
        case 0:
            logger.error(errorLog);
            throw new OpenApiSDKException(ExternalErrorCode.REQUEST_NO_RESPONSE);
        case 500:
            logger.error(errorLog);
            throw new OpenApiSDKException(ExternalErrorCode.NOT_KNOW_ERROR);
        case 401:
            logger.info(errorLog);
            break;
        case 200:
            break;
        default:
            logger.error(errorLog);
            throw new OpenApiSDKException(code);
        }
    }
}
