package com.fangcloud.sdk.bean.output.elements;

import com.google.gson.annotations.SerializedName;

public class MiniComment {
    protected long id;
    protected String content;
    @SerializedName("created_at")
    protected long createdAt;
    @SerializedName("item_id")
    protected long itemId;
    @SerializedName("item_type")
    protected String itemType;
    @SerializedName("user")
    private MiniUser user;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    public long getItemId() {
        return itemId;
    }

    public void setItemId(long itemId) {
        this.itemId = itemId;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public MiniUser getUser() {
        return user;
    }

    public void setUser(MiniUser user) {
        this.user = user;
    }
}
