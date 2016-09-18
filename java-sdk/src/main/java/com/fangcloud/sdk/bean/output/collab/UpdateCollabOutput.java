package com.fangcloud.sdk.bean.output.collab;

import com.fangcloud.sdk.bean.output.BaseOutput;
import com.fangcloud.sdk.bean.output.elements.MiniCollab;

import java.util.LinkedList;
import java.util.List;

public class UpdateCollabOutput extends BaseOutput {
    private List<MiniCollab> collabs;

    public UpdateCollabOutput() {
        this.collabs = new LinkedList<>();
    }
    public List<MiniCollab> getCollabs() {
        return collabs;
    }

    public void setCollabs(List<MiniCollab> collabs) {
        this.collabs = collabs;
    }
}
