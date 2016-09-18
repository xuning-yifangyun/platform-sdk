package com.fangcloud.sdk.bean.input.review;

import com.fangcloud.sdk.bean.input.BaseApiBean;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class EditReviewBean extends BaseApiBean {
    @SerializedName("deleted_reviewers")
    private List<Long> deletedReviewers;
    @SerializedName("added_reviewers")
    private List<Long> addedReviewers;
    @SerializedName("due_time")
    private String dueTime;

    public List<Long> getDeletedReviewers() {
        return deletedReviewers;
    }

    public void setDeletedReviewers(List<Long> deletedReviewers) {
        this.deletedReviewers = deletedReviewers;
    }

    public List<Long> getAddedReviewers() {
        return addedReviewers;
    }

    public void setAddedReviewers(List<Long> addedReviewers) {
        this.addedReviewers = addedReviewers;
    }

    public String getDueTime() {
        return dueTime;
    }

    public void setDueTime(String dueTime) {
        this.dueTime = dueTime;
    }
}
