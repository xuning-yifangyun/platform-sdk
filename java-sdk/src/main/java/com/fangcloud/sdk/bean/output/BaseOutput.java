package com.fangcloud.sdk.bean.output;

public class BaseOutput extends BaseActionBean {

    protected boolean success;

    public BaseOutput() {
        success = true;
    }

    public boolean getSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
