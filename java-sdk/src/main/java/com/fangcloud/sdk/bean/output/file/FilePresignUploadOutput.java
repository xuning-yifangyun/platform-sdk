package com.fangcloud.sdk.bean.output.file;

import com.fangcloud.sdk.bean.output.BaseOutput;
import com.google.gson.annotations.SerializedName;

public class FilePresignUploadOutput extends BaseOutput {
    @SerializedName("presign_url")
    String presignUrl;

    public FilePresignUploadOutput(String presignUrl) {
        this.presignUrl = presignUrl;
    }

    public FilePresignUploadOutput() {
    }

    public String getPresignUrl() {
        return presignUrl;
    }

    public void setPresignUrl(String presignUrl) {
        this.presignUrl = presignUrl;
    }
}
