package com.fangcloud.sdk.bean.input.file;

import com.google.gson.JsonParseException;

/**
 * Created by xuning on 2016/8/14.
 */
public enum PreviewKind {
    FILE("file"),
    IMAGE_64("image_64"),
    IMAGE_128("image_128"),
    IMAGE_1024("image_1024"),
    IMAGE_2048("image_2048"),
    PDF("pdf"),
    AUDIO("audio"),
    VIDEO("video"),
    METAKEY("metakey"),
    UNENCRYPTED("unencrypted");

    private String value;

    PreviewKind(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static PreviewKind getPreviewKindForJsonDeserialize(String value) {
        for (PreviewKind type : values()) {
            if (type.getValue().equals(value)) {
                return type;
            }
        }
        throw new JsonParseException("invalid provided preview kind");
    }
}
