package com.fangcloud.sdk.bean.output.review;

import com.fangcloud.sdk.bean.output.BaseOutput;
import com.fangcloud.sdk.bean.output.elements.MiniReviewFile;
import com.fangcloud.sdk.bean.output.elements.MiniUser;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetReviewInfoOutput extends BaseOutput {
    private long id;
    private MiniUser inviter;
    private String name;
    private String description;
    @SerializedName("created_at")
    private long created;
    @SerializedName("modified_at")
    private long updated;
    @SerializedName("due_time")
    private long dueTime;
    private List<MiniUser> reviewers;
    private List<MiniReviewFile> items;
    @SerializedName("is_complete")
    private boolean isComplete;
    @SerializedName("need_sign")
    private boolean needSign;
    @SerializedName("is_expired")
    private boolean isExpired;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public MiniUser getInviter() {
        return inviter;
    }

    public void setInviter(MiniUser inviter) {
        this.inviter = inviter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getCreated() {
        return created;
    }

    public void setCreated(long created) {
        this.created = created;
    }

    public long getUpdated() {
        return updated;
    }

    public void setUpdated(long updated) {
        this.updated = updated;
    }

    public long getDueTime() {
        return dueTime;
    }

    public void setDueTime(long dueTime) {
        this.dueTime = dueTime;
    }

    public List<MiniUser> getReviewers() {
        return reviewers;
    }

    public void setReviewers(List<MiniUser> reviewers) {
        this.reviewers = reviewers;
    }

    public List<MiniReviewFile> getItems() {
        return items;
    }

    public void setItems(List<MiniReviewFile> items) {
        this.items = items;
    }

    public boolean isComplete() {
        return isComplete;
    }

    public void setComplete(boolean complete) {
        isComplete = complete;
    }

    public boolean isNeedSign() {
        return needSign;
    }

    public void setNeedSign(boolean needSign) {
        this.needSign = needSign;
    }

    public boolean isExpired() {
        return isExpired;
    }

    public void setExpired(boolean expired) {
        isExpired = expired;
    }
}
