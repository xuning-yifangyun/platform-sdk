package com.fangcloud.sdk.bean.output.file;

import com.fangcloud.sdk.bean.output.BaseOutput;
import com.google.gson.annotations.SerializedName;

public class FilePreviewDownload extends BaseOutput {
    @SerializedName("download_url")
    private String downloadUrl;
    private String status;
    @SerializedName("representation_fail_reason")
    private String previewFailReason;

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPreviewFailReason() {
        return previewFailReason;
    }

    public void setPreviewFailReason(String previewFailReason) {
        this.previewFailReason = previewFailReason;
    }
}
