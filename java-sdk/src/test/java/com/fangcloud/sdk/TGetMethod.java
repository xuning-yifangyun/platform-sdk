package com.fangcloud.sdk;

import com.fangcloud.sdk.request.Header;
import com.fangcloud.sdk.request.RequestClient;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by xuning on 2016/8/10.
 */

public class TGetMethod {
    @Test
    public void tGetFilePreviewUrl() {
        String authValue = "Bearer 01e5ea72-7e05-4a75-9ada-32ed883a5678";
        String url = "https://platform.fangcloud.net/input/file/501000016067/download";
        String method = "get";
        ArrayList<Header> headers = new ArrayList<>();
        Header header = new Header("Authorization", authValue);
        Header header1 = new Header("Content-Type", "application/json");
        headers.add(header);
        headers.add(header1);
        RequestClient requestClient = new RequestClient(url, method, headers, null);
        HttpResponse httpResponse = requestClient.sendRequest();
        try {
            System.out.println(EntityUtils.toString(httpResponse.getEntity()));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
