package com.fangcloud.sdk.bean.output.elements;

import com.google.gson.annotations.SerializedName;

public class SharedItem {

    private String type;
    private long id;
    private String name;
    private long size;
    @SerializedName("created_at")
    private long createdAt;
    @SerializedName("modified_at")
    private long modifiedAt;
    private String description;
    @SerializedName("owned_by")
    private MiniUser ownedBy;

    public SharedItem() {
    }




    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public MiniUser getOwnedBy() {
        return ownedBy;
    }

}
