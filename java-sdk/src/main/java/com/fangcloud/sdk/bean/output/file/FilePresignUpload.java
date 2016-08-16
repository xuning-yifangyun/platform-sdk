package com.fangcloud.sdk.bean.output.file;

import com.fangcloud.sdk.bean.output.BaseOutput;
import com.google.gson.annotations.SerializedName;

public class FilePresignUpload extends BaseOutput {
    @SerializedName("presign_url")
    String presignUrl;

    public FilePresignUpload(String presignUrl) {
        this.presignUrl = presignUrl;
    }

    public FilePresignUpload() {
    }

    public String getPresignUrl() {
        return presignUrl;
    }

    public void setPresignUrl(String presignUrl) {
        this.presignUrl = presignUrl;
    }
}
