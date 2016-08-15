package com.fangcloud.sdk.bean.input.file;

import com.fangcloud.sdk.bean.input.BaseApiBean;
import com.google.gson.annotations.SerializedName;

public class FilePreviewDownloadBean extends BaseApiBean {
    @SerializedName("kind")
    private String previewKind;
    @SerializedName("page_index")
    private long pageIndex;

    public FilePreviewDownloadBean(String previewKind, long pageIndex) {
        this.previewKind = previewKind;
        this.pageIndex = pageIndex;
    }

    public String getPreviewKind() {
        return previewKind;
    }

    public void setPreviewKind(String previewKind) {
        this.previewKind = previewKind;
    }

    public long getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(long pageIndex) {
        this.pageIndex = pageIndex;
    }
}
