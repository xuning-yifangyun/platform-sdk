package com.fangcloud.sdk.bean.input.collab;

import com.fangcloud.sdk.bean.input.BaseApiBean;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CreateCollabBean extends BaseApiBean {
    @SerializedName("folder_id")
    private long folderId;
    @SerializedName("invited_users")
    private List<InvitedUserIdAndRole> invitedUsersParams;
    @SerializedName("invitation_message")
    private String invitationMessage;

    public CreateCollabBean(long folderId, List<InvitedUserIdAndRole> invitedUsersParams, String invitationMessage) {
        this.folderId = folderId;
        this.invitedUsersParams = invitedUsersParams;
        this.invitationMessage = invitationMessage;
    }

    public long getFolderId() {
        return folderId;
    }

    public void setFolderId(long folderId) {
        this.folderId = folderId;
    }

    public List<InvitedUserIdAndRole> getInvitedUsersParams() {
        return invitedUsersParams;
    }

    public void setInvitedUsersParams(List<InvitedUserIdAndRole> invitedUsersParams) {
        this.invitedUsersParams = invitedUsersParams;
    }

    public String getInvitationMessage() {
        return invitationMessage;
    }

    public void setInvitationMessage(String invitationMessage) {
        this.invitationMessage = invitationMessage;
    }

    public static class InvitedUserIdAndRole {
        @SerializedName("user_id")
        private long userId;
        private String role;

        public long getUserId() {
            return userId;
        }

        public void setUserId(long userId) {
            this.userId = userId;
        }

        public String getRole() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
        }
    }
}
