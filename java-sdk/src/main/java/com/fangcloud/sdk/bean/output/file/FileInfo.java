package com.fangcloud.sdk.bean.output.file;

import com.fangcloud.sdk.bean.output.item.ItemInfoOutput;
import com.google.gson.annotations.SerializedName;

public class FileInfo extends ItemInfoOutput {
    private String sha1;
    @SerializedName("file_version_key")
    private String fileVersionKey;
    @SerializedName("comments_count")
    private long commentsCount;
    @SerializedName("extension_category")
    private String extensionCategory;

    public String getFileVersionKey() {
        return fileVersionKey;
    }

    public void setFileVersionKey(String fileVersionKey) {
        this.fileVersionKey = fileVersionKey;
    }

    public String getSha1() {
        return sha1;
    }

    public void setSha1(String sha1) {
        this.sha1 = sha1;
    }

    public long getCommentsCount() {
        return commentsCount;
    }

    public void setCommentsCount(long commentsCount) {
        this.commentsCount = commentsCount;
    }

    public void setExtensionCategory(String extensionCategory) {
        this.extensionCategory = extensionCategory;
    }

    public String getExtensionCategory() {
        return extensionCategory;
    }
}
