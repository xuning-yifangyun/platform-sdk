package com.fangcloud.sdk.bean.input.file;

import com.fangcloud.sdk.bean.input.BaseApiBean;
import com.google.gson.annotations.SerializedName;

public class FilePreviewBean extends BaseApiBean {
    @SerializedName("kind")
    private String previewKind;
    @SerializedName("force_regenerate")
    private boolean isRegenerate;

    public FilePreviewBean(String previewKind, boolean isRegenerate) {
        this.previewKind = previewKind;
        this.isRegenerate = isRegenerate;
    }

    public String getPreviewKind() {
        return previewKind;
    }

    public void setPreviewKind(String previewKind) {
        this.previewKind = previewKind;
    }

    public boolean getRegenerate() {
        return isRegenerate;
    }

    public void setRegenerate(boolean regenerate) {
        isRegenerate = regenerate;
    }
}
