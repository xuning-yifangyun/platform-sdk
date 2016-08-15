package com.fangcloud.sdk.bean.output.elements;

import com.google.gson.annotations.SerializedName;

public class MiniFile extends MiniItem {
    protected String extension;
    @SerializedName("created_at")
    protected long createdAt;
    @SerializedName("modified_at")
    protected long modifiedAt;
    @SerializedName("owned_by")
    protected MiniUser owner;
    protected String description;
    protected String remark;

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

    public MiniUser getOwner() {
        return owner;
    }

    public void setOwner(MiniUser owner) {
        this.owner = owner;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}
