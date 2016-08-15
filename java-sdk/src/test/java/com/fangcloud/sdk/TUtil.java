package com.fangcloud.sdk;

import com.fangcloud.sdk.core.Config;
import com.fangcloud.sdk.util.UrlTemplate;
import org.junit.Test;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by xuning on 2016/8/10.
 */
public class TUtil {
    private static final UrlTemplate GET_AUTH_URI = new UrlTemplate("/authorize");

    @Test
    public void TUrlTemplate() {
        URL url = null;
        String urlString = GET_AUTH_URI.build(Config.DEFAULT_AUTH_URL);
        String queryPrame = String.format("?client_id=%s&redirect_uri=%s&response_type=%s&state=", 1111, 222222, "code");
        String res = urlString + queryPrame;
        try {
            url = new URL(res);
        }
        catch (MalformedURLException e) {
            e.printStackTrace();
        }
        System.out.println(url);

    }

}
