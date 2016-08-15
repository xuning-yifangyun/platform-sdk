package com.fangcloud.sdk;

import com.fangcloud.sdk.util.TransformationUtil;
import org.junit.Test;

/**
 * Created by xuning on 2016/8/10.
 */
public class TJsonTransform {
    @Test
    public void start() {
        String jsonString = "{\"key\":\"username\",\"value\":\"徐宁\"}";
        TransformationUtil.toStringEntity(jsonString);
        System.out.println();
    }

    @Test
    public void TFileIdsToJsonString(){
        //FileApi fileApi=new FileApi();
        //fileApi.deleteFile(1111,2222,333,444);
    }
}
