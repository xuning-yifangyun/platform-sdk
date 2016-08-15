package com.fangcloud.sdk.bean.output.file;

import com.fangcloud.sdk.bean.output.BaseOutput;
import com.fangcloud.sdk.bean.output.folder.FolderInfoOutput;
import com.google.gson.annotations.SerializedName;

public class MoveFileOutput extends BaseOutput {
    @SerializedName("new_parent")
    private FolderInfoOutput newParent;

    public FolderInfoOutput getNewParent() {
        return newParent;
    }

    public void setNewParent(FolderInfoOutput newParent) {
        this.newParent = newParent;
    }
}
