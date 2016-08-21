package com.fangcloud.sdk.request;

import com.fangcloud.sdk.bean.exception.ExternalErrorCode;
import com.fangcloud.sdk.bean.exception.OpenApiSDKException;
import com.fangcloud.sdk.bean.output.ErrorsInfo;
import com.fangcloud.sdk.core.Config;
import com.fangcloud.sdk.util.LogUtil;
import com.fangcloud.sdk.util.TransformationUtil;
import com.google.gson.Gson;
import org.apache.http.HttpResponse;

import java.util.List;
import java.util.Map;

/**
 * Created by xuning on 2016/8/22.
 */
public class RequestIntercept {
    private static int sendRes = 0;
    private static String requestId;
    private static String code;
    private static String msg;

    public static void ErrorInfoIntercept(HttpResponse httpResponse) {
        Map<String, Object> errorInfoMap = null;
        sendRes = httpResponse.getStatusLine().getStatusCode();

        String resJsonString = TransformationUtil.httpResponseToString(httpResponse);

        ErrorsInfo errorsInfo = new Gson().fromJson(resJsonString, ErrorsInfo.class);

        List<ErrorsInfo.ReponseErrorInfo> reponseErrorInfos = errorsInfo.getErrors();

        requestId = errorsInfo.getRequestId();

        code = reponseErrorInfos.get(0).getCode();

        msg = reponseErrorInfos.get(0).getMsg();

        if (Config.OPEN_LOG_OUTPUT) {
            String errorLog="[error_code:"+code+"][request_id: "+requestId+"]";
            LogUtil.getLogUtil().printLog(errorLog);
        }

        if (null == resJsonString) {
            throw new OpenApiSDKException(ExternalErrorCode.REQUEST_NO_RESPONSE);
        }
        switch (sendRes) {
        case 0:
            throw new OpenApiSDKException(ExternalErrorCode.REQUEST_NO_RESPONSE);
        case 400:
            throw new OpenApiSDKException(code);
        case 500:
            throw new OpenApiSDKException(ExternalErrorCode.NOT_KNOW_ERROR);
        }
    }

}
