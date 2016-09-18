package com.fangcloud.sdk.bean.input.folder;

import com.fangcloud.sdk.bean.input.BaseApiBean;
import com.google.gson.annotations.SerializedName;

public class CreateFolderBean extends BaseApiBean {
    private String name;
    @SerializedName("parent_id")
    private long parentId;

    public CreateFolderBean(String name, long parentId) {
        this.name = name;
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getParentId() {
        return parentId;
    }

    public void setParentId(long parentId) {
        this.parentId = parentId;
    }
}
