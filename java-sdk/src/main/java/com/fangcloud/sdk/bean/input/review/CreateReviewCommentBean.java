package com.fangcloud.sdk.bean.input.review;

import com.fangcloud.sdk.bean.input.BaseApiBean;
import com.google.gson.annotations.SerializedName;

public class CreateReviewCommentBean extends BaseApiBean {
    private String content;
    @SerializedName("review_id")
    private long reviewId;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getReviewId() {
        return reviewId;
    }

    public void setReviewId(long reviewId) {
        this.reviewId = reviewId;
    }
}
