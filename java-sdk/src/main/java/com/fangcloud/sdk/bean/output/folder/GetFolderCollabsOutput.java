package com.fangcloud.sdk.bean.output.folder;

import com.fangcloud.sdk.bean.output.BaseOutput;
import com.fangcloud.sdk.bean.output.elements.MiniCollab;

import java.util.LinkedList;
import java.util.List;

public class GetFolderCollabsOutput extends BaseOutput {
    private List<MiniCollab> collabs;

    public GetFolderCollabsOutput() {
        this.collabs = new LinkedList<>();
    }

    public List<MiniCollab> getCollabs() {
        return collabs;
    }

    public void setCollabs(List<MiniCollab> collabs) {
        this.collabs = collabs;
    }
}
