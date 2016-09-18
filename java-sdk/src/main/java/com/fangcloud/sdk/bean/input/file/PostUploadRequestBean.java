package com.fangcloud.sdk.bean.input.file;

import com.fangcloud.sdk.bean.input.BaseApiBean;
import com.google.gson.annotations.SerializedName;

public class PostUploadRequestBean extends BaseApiBean {
    @SerializedName("unencrypted_sha1")
    private String sha;
    @SerializedName("etag_for_enc")
    private String encEtag;
    @SerializedName("etag_for_mkey")
    private String mkeyEtag;
    @SerializedName("file_size")
    private long fileSize;
    @SerializedName("bucket_info")
    private BucketInfo bucketInfo;
    @SerializedName("date")
    private String date;
    @SerializedName("hour")
    private String hour;
    @SerializedName("unique_name")
    private String uniqueName;
    @SerializedName("ip_address")
    private String remoteAddress;
    @SerializedName("additional_info")
    private Object additionalInfo;

    public PostUploadRequestBean(String sha, String encEtag, String mkeyEtag, long fileSize, BucketInfo bucketInfo, String date, String hour, String uniqueName,
            String remoteAddress, Object additionalInfo) {
        this.sha = sha;
        this.encEtag = encEtag;
        this.mkeyEtag = mkeyEtag;
        this.fileSize = fileSize;
        this.bucketInfo = bucketInfo;
        this.date = date;
        this.hour = hour;
        this.uniqueName = uniqueName;
        this.remoteAddress = remoteAddress;
        this.additionalInfo = additionalInfo;
    }

    public String getSha() {
        return sha;
    }

    public void setSha(String sha) {
        this.sha = sha;
    }

    public String getEncEtag() {
        return encEtag;
    }

    public void setEncEtag(String encEtag) {
        this.encEtag = encEtag;
    }

    public String getMkeyEtag() {
        return mkeyEtag;
    }

    public void setMkeyEtag(String mkeyEtag) {
        this.mkeyEtag = mkeyEtag;
    }

    public long getFileSize() {
        return fileSize;
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }

    public BucketInfo getBucketInfo() {
        return bucketInfo;
    }

    public void setBucketInfo(BucketInfo bucketInfo) {
        this.bucketInfo = bucketInfo;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getUniqueName() {
        return uniqueName;
    }

    public void setUniqueName(String uniqueName) {
        this.uniqueName = uniqueName;
    }

    public Object getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(Object additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    public String getRemoteAddress() {
        return remoteAddress;
    }

    public void setRemoteAddress(String remoteAddress) {
        this.remoteAddress = remoteAddress;
    }
}
