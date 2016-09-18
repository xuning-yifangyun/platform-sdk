package com.fangcloud.sdk.bean.output.file;

import com.fangcloud.sdk.bean.output.BaseOutput;
import com.google.gson.annotations.SerializedName;

public class FilePreviewInfo extends BaseOutput {
    private String category;
    @SerializedName("download_url")
    private String presignedUrl;
    @SerializedName("exif_rotation")
    private Integer exifRotation; // 不用int的原因是默认为null的话就不会被Gson返回,以下类似
    private String format;
    @SerializedName("has_2048")
    private Boolean has2048;
    @SerializedName("page_count")
    private Long pageCount;
    private String status;
    @SerializedName("representation_fail_reason")
    private String previewFailReason;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPresignedUrl() {
        return presignedUrl;
    }

    public void setPresignedUrl(String presignedUrl) {
        this.presignedUrl = presignedUrl;
    }

    public int getExifRotation() {
        return exifRotation;
    }

    public void setExifRotation(int exifRotation) {
        this.exifRotation = exifRotation;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public boolean isHas2048() {
        return has2048;
    }

    public void setHas2048(boolean has2048) {
        this.has2048 = has2048;
    }

    public long getPageCount() {
        return pageCount;
    }

    public void setPageCount(long pageCount) {
        this.pageCount = pageCount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPreviewFailReason() {
        return previewFailReason;
    }

    public void setPreviewFailReason(String previewFailReason) {
        this.previewFailReason = previewFailReason;
    }
}
