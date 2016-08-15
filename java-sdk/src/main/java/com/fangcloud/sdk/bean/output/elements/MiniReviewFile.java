package com.fangcloud.sdk.bean.output.elements;

import com.google.gson.annotations.SerializedName;

public class MiniReviewFile extends MiniItem {
    private String extension;
    @SerializedName("created_at")
    protected long createdAt;
    @SerializedName("modified_at")
    protected long modifiedAt;



    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    public long getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(long modifiedAt) {
        this.modifiedAt = modifiedAt;
    }
}
