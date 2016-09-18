package com.fangcloud.sdk.bean.input.collab;

import com.fangcloud.sdk.bean.input.BaseApiBean;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DeleteCollabBean extends BaseApiBean {
    @SerializedName("collab_ids")
    private List<Long> collabIds;

    public DeleteCollabBean(List<Long> collabIds) {
        this.collabIds = collabIds;
    }

    public List<Long> getCollabIds() {
        return collabIds;
    }

    public void setCollabIds(List<Long> collabIds) {
        this.collabIds = collabIds;
    }
}
