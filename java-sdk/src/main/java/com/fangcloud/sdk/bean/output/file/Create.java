package com.fangcloud.sdk.bean.output.file;

import com.fangcloud.sdk.bean.output.BaseOutput;
import com.fangcloud.sdk.bean.output.elements.MiniFile;
import com.google.gson.annotations.SerializedName;

public class Create extends BaseOutput {
    @SerializedName("new_file")
    private MiniFile newFile;

    public Create(MiniFile newFile) {
        this.newFile = newFile;
    }

    public MiniFile getNewFile() {
        return newFile;
    }

    public void setNewFile(MiniFile newFile) {
        this.newFile = newFile;
    }
}
