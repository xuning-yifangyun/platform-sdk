package com.fangcloud.sdk.bean.output.comment;

import com.fangcloud.sdk.bean.output.BaseOutput;
import com.fangcloud.sdk.bean.output.elements.MiniComment;

public class CommentOutput extends BaseOutput {

    protected MiniComment comment;

    public MiniComment getComment() {
        return comment;
    }

    public void setComment(MiniComment comment) {
        this.comment = comment;
    }
}
