package com.fangcloud.sdk.bean.output.collab;

import com.fangcloud.sdk.bean.output.BaseOutput;
import com.fangcloud.sdk.bean.output.elements.MiniCollab;
import com.google.gson.annotations.SerializedName;

public class GetCollabInfoOutput extends BaseOutput {
    @SerializedName("collab")
    private MiniCollab miniCollab;

    public MiniCollab getMiniCollab() {
        return miniCollab;
    }

    public void setMiniCollab(MiniCollab miniCollab) {
        this.miniCollab = miniCollab;
    }
}
