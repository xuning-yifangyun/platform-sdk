package com.fangcloud.sdk.bean.output.folder;

import com.fangcloud.sdk.bean.output.item.ItemInfoOutput;
import com.google.gson.annotations.SerializedName;

public class FolderInfo extends ItemInfoOutput {
    @SerializedName("item_count")
    private long itemCount;
    @SerializedName("folder_type")
    private String folderType;

    public long getItemCount() {
        return itemCount;
    }

    public void setItemCount(long itemCount) {
        this.itemCount = itemCount;
    }

    public String getFolderType() {
        return folderType;
    }

    public void setFolderType(String folderType) {
        this.folderType = folderType;
    }
}
