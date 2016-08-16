package com.fangcloud.sdk.bean.output.file;

import com.fangcloud.sdk.bean.output.BaseOutput;
import com.fangcloud.sdk.bean.output.folder.FolderInfo;
import com.google.gson.annotations.SerializedName;

public class MoveFileOutput extends BaseOutput {
    @SerializedName("new_parent")
    private FolderInfo newParent;

    public FolderInfo getNewParent() {
        return newParent;
    }

    public void setNewParent(FolderInfo newParent) {
        this.newParent = newParent;
    }
}
