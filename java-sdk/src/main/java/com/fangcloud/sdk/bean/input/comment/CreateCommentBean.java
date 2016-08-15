package com.fangcloud.sdk.bean.input.comment;

import com.fangcloud.sdk.bean.input.BaseApiBean;
import com.google.gson.annotations.SerializedName;

public class CreateCommentBean extends BaseApiBean {
    @SerializedName("file_id")
    private long fileId;

    private String content;

    public CreateCommentBean(long fileId, String content) {
        this.fileId = fileId;
        this.content = content;
    }

    public long getFileId() {
        return fileId;
    }

    public void setFileId(long fileId) {
        this.fileId = fileId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
