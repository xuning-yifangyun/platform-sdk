package com.fangcloud.sdk.bean.output.comment;

import com.fangcloud.sdk.bean.output.PagingResponse;
import com.fangcloud.sdk.bean.output.elements.MiniComment;

import java.util.List;

public class GetCommentsOutput extends PagingResponse {

    private List<MiniComment> comments;

    public List<MiniComment> getComments() {
        return comments;
    }

    public void setComments(List<MiniComment> comments) {
        this.comments = comments;
    }
}
