package com.fangcloud.sdk;

import com.fangcloud.sdk.request.Header;
import com.fangcloud.sdk.request.RequestClient;
import com.fangcloud.sdk.util.RequestUtil;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by xuning on 2016/8/10.
 */
public class TPutMethod {

    @Test
    public void start() {
        String authValue = "Bearer 01e5ea72-7e05-4a75-9ada-32ed883a5678";
        String url = "https://platform.fangcloud.net/input/file/501000016067/download";
        String method = "put";
        Header header = new Header("Authorization", authValue);
        Header header1 = new Header("Content-Type", "application/json");
        ArrayList<Header> headers = RequestUtil.addToHeaderList(header, header1);
        RequestClient requestClient = new RequestClient(url, method, headers);
    }
}
