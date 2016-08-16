package com.fangcloud.sdk.bean.output.file;

import com.fangcloud.sdk.bean.output.BaseOutput;
import com.google.gson.annotations.SerializedName;

import java.util.Map;

public class FilePresignDownload extends BaseOutput {
    @SerializedName("download_urls")
    private Map<Long, String> downloadTargetIdToDownloadUrl;

    public Map<Long, String> getDownloadTargetIdToDownloadUrl() {
        return downloadTargetIdToDownloadUrl;
    }

    public void setDownloadTargetIdToDownloadUrl(Map<Long, String> downloadTargetIdToDownloadUrl) {
        this.downloadTargetIdToDownloadUrl = downloadTargetIdToDownloadUrl;
    }
}
