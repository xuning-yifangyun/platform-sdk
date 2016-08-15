package com.fangcloud.sdk.bean.output.elements;

import com.google.gson.annotations.SerializedName;

public class MiniCollab {
    @SerializedName("collab_id")
    private long collabId;
    private MiniUser user;
    private boolean accepted;
    @SerializedName("folder_id")
    private long folderId;
    private String role;



    public long getCollabId() {
        return collabId;
    }

    public void setCollabId(long collabId) {
        this.collabId = collabId;
    }

    public MiniUser getUser() {
        return user;
    }

    public void setUser(MiniUser user) {
        this.user = user;
    }

    public boolean isAccepted() {
        return accepted;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }

    public long getFolderId() {
        return folderId;
    }

    public void setFolderId(long folderId) {
        this.folderId = folderId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
