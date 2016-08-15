package com.fangcloud.sdk.bean.output.review;

import com.fangcloud.sdk.bean.output.PagingResponse;
import com.fangcloud.sdk.bean.output.elements.MiniReview;
import com.fangcloud.sdk.bean.output.elements.MiniReviewComment;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetReviewCommentOutput extends PagingResponse {
    private MiniReview review;
    @SerializedName("review_comments")
    private List<MiniReviewComment> reviewComments;
    @SerializedName("review_comment_count")
    private int reviewCommentCount;

    public MiniReview getReview() {
        return review;
    }

    public void setReview(MiniReview review) {
        this.review = review;
    }

    public List<MiniReviewComment> getReviewComments() {
        return reviewComments;
    }

    public void setReviewComments(List<MiniReviewComment> reviewComments) {
        this.reviewComments = reviewComments;
    }

    public int getReviewCommentCount() {
        return reviewCommentCount;
    }

    public void setReviewCommentCount(int reviewCommentCount) {
        this.reviewCommentCount = reviewCommentCount;
    }
}
