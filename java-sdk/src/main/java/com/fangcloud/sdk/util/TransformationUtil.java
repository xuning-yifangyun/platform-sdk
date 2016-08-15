package com.fangcloud.sdk.util;

import com.fangcloud.sdk.core.Config;
import com.fangcloud.sdk.request.RequestClient;
import com.google.gson.Gson;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuning on 2016/8/9.
 * 数据转换
 */
public class TransformationUtil {

    /**
     * 转换为HttpEntity
     *
     * @param valuePairs
     * @return
     */
    public static final HttpEntity toHttpEntity(List<NameValuePair> valuePairs) {
        HttpEntity httpEntity = null;
        try {
            httpEntity = new UrlEncodedFormEntity(valuePairs, "UTF-8");
        }
        catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return httpEntity;
    }

    /**
     * 转换为StringEntity
     *
     * @param jsonStrintg
     * @return
     */
    public static final StringEntity toStringEntity(String jsonStrintg) {
        StringEntity stringEntity = null;
        stringEntity = new StringEntity(jsonStrintg, Config.DEFAULT_CHARSET_TYPE);
        return stringEntity;
    }

    /**
     * 转换为String
     *
     * @param httpResponse
     * @return
     */
    public static final String httpResponseToString(HttpResponse httpResponse) {
        String res = null;
        try {
            System.out.println(httpResponse.getEntity());
            res = EntityUtils.toString(httpResponse.getEntity());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }

    /**
     * 直接取出Client转换为Object
     *
     * @param requestClient
     * @param classes
     * @return
     */
    public static final Object requestClientToOutputObject(RequestClient requestClient, Class classes) {
        HttpResponse httpResponse = requestClient.sendRequest();
        String res = httpResponseToString(httpResponse);
        System.out.println("在Transfrrom中获取到返回的jsonString是\n"+res);
        return new Gson().fromJson(res, classes);
    }

    /**
     * postBody转换为JsonString
     *
     * @param o
     * @return
     */
    public static final String postBodyObjToJsonString(Object o) {
        return new Gson().toJson(o);
    }

    public static final String postBodyObjToJsonString(Object... o) {
        return new Gson().toJson(o);
    }

    /**
     * 数组转化为List
     *
     * @param ids
     * @return
     */

    public static final List<Long> ArrToArrayListpostBody(long... ids) {
        List<Long> idsList = new ArrayList<>();
        for (long id : ids) {
            idsList.add(id);
        }
        return idsList;
    }
}
