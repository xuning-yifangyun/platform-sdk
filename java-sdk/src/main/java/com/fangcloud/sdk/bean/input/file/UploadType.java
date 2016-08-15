package com.fangcloud.sdk.bean.input.file;

/**
 * Created by xuning on 2016/8/14.
 */
public enum  UploadType {
    AJAX("ajax"),
    HTML5("html5"),
    API("input"),
    INTERNAL("internal"),
    UNKNOWN("unknown");

    private String strValue;

    private UploadType(String strValue) {
        this.strValue = strValue;
    }

    public String getValue() {
        return this.strValue;
    }

    public static UploadType getUploadType(String value) {
        UploadType[] arr$ = values();
        int len$ = arr$.length;

        for(int i$ = 0; i$ < len$; ++i$) {
            UploadType type = arr$[i$];
            if(type.getValue().equals(value)) {
                return type;
            }
        }

        return UNKNOWN;
    }
}
