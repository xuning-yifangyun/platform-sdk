package com.fangcloud.sdk.util;

import com.fangcloud.sdk.request.Header;
import org.apache.http.NameValuePair;

import java.util.ArrayList;

/**
 * Created by xuning on 2016/8/10.
 */

/**
 * 请求Util
 */
public class RequestUtil {
    /**
     * 添加Query参数
     *
     * @param valuePairs
     * @return
     */
    public static ArrayList<NameValuePair> addToNameValuePairList(NameValuePair... valuePairs) {
        if (valuePairs.length <= 0) {
            return null;
        }
        ArrayList<NameValuePair> nameValuePairs = new ArrayList<>();
        for (NameValuePair p : valuePairs) {
            nameValuePairs.add(p);
        }
        return nameValuePairs;
    }

    /**
     * 添加Header信息
     *
     * @param headers
     * @return
     */
    public static ArrayList<Header> addToHeaderList(Header... headers) {

        if (headers.length <= 0) {
            return null;
        }
        ArrayList<Header> headerList = new ArrayList<>();
        for (Header header : headers) {
            headerList.add(header);
        }
        return headerList;
    }

}
