package com.fangcloud.sdk.bean.input.file;

import com.google.gson.annotations.SerializedName;

/**
 * Created by xuning on 2016/8/14.
 */
public class BucketInfo {
    @SerializedName("bucket")
    private String bucket;
    @SerializedName("storage_id")
    private long storageId;

    public BucketInfo(String bucket, long storageId) {
        this.bucket = bucket;
        this.storageId = storageId;
    }

    public String getBucket() {
        return bucket;
    }

    public void setBucket(String bucket) {
        this.bucket = bucket;
    }

    public long getStorageId() {
        return storageId;
    }

    public void setStorageId(long storageId) {
        this.storageId = storageId;
    }
}
