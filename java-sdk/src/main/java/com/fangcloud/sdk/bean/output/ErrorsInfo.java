package com.fangcloud.sdk.bean.output;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by xuning on 2016/8/12.
 */
public class ErrorsInfo {
    @SerializedName("errors")
    private List<ReponseErrorInfo> errors;
    @SerializedName("request_id")
    private String requestId;

    public List<ReponseErrorInfo> getErrors() {
        return errors;
    }

    public void setErrors(List<ReponseErrorInfo> errors) {
        this.errors = errors;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }
    public class ReponseErrorInfo{
        private String msg;
        private String code;

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }
    }
}
