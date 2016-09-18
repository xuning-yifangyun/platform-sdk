package com.fangcloud.sdk.bean.output.collab;

import com.fangcloud.sdk.bean.output.BaseOutput;
import com.fangcloud.sdk.bean.output.elements.MiniCollab;

import java.util.List;

public class CreateCollabOutput extends BaseOutput {
    private List<MiniCollab> collabs;

    public List<MiniCollab> getCollabs() {
        return collabs;
    }

    public void setCollabs(List<MiniCollab> collabs) {
        this.collabs = collabs;
    }
}
