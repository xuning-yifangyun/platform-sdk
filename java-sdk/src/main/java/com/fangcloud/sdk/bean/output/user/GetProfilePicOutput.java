package com.fangcloud.sdk.bean.output.user;

import com.fangcloud.sdk.bean.output.BaseOutput;

import javax.xml.ws.Response;

public class GetProfilePicOutput extends BaseOutput {
    private Response response;

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }
}
