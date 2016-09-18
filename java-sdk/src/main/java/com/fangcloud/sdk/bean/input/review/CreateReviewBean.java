package com.fangcloud.sdk.bean.input.review;

import com.fangcloud.sdk.bean.input.BaseApiBean;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CreateReviewBean extends BaseApiBean {
    @SerializedName("file_ids")
    private List<Long> fileIds;
    private String title;
    @SerializedName("due_time")
    private String dueTime;
    private String description;
    @SerializedName("invited_user_ids")
    private List<Long> invitedUserIds;

    public List<Long> getFileIds() {
        return fileIds;
    }

    public void setFileIds(List<Long> fileIds) {
        this.fileIds = fileIds;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDueTime() {
        return dueTime;
    }

    public void setDueTime(String dueTime) {
        this.dueTime = dueTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Long> getInvitedUserIds() {
        return invitedUserIds;
    }

    public void setInvitedUserIds(List<Long> invitedUserIds) {
        this.invitedUserIds = invitedUserIds;
    }
}
