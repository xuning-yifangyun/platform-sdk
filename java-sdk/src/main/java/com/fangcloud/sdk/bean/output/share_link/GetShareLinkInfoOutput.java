package com.fangcloud.sdk.bean.output.share_link;

import com.fangcloud.sdk.bean.output.BaseOutput;
import com.fangcloud.sdk.bean.output.elements.SharedItem;
import com.google.gson.annotations.SerializedName;

public class GetShareLinkInfoOutput extends BaseOutput {
    @SerializedName("unique_name")
    private String uniqueName;
    private String access;
    @SerializedName("password_protected")
    private boolean passwordProtected;
    @SerializedName("due_time")
    private long dueTime;
    @SerializedName("disable_download")
    private boolean disableDownload;
    @SerializedName("item")
    private SharedItem itemInfo;


    public String getUniqueName() {
        return uniqueName;
    }

    public void setUniqueName(String uniqueName) {
        this.uniqueName = uniqueName;
    }

    public String getAccess() {
        return access;
    }

    public void setAccess(String access) {
        this.access = access;
    }

    public boolean isPasswordProtected() {
        return passwordProtected;
    }

    public void setPasswordProtected(boolean passwordProtected) {
        this.passwordProtected = passwordProtected;
    }

    public long getDueTime() {
        return dueTime;
    }

    public void setDueTime(long dueTime) {
        this.dueTime = dueTime;
    }

    public boolean isDisableDownload() {
        return disableDownload;
    }

    public void setDisableDownload(boolean disableDownload) {
        this.disableDownload = disableDownload;
    }

    public SharedItem getItemInfo() {
        return itemInfo;
    }

    public void setItemInfo(SharedItem itemInfo) {
        this.itemInfo = itemInfo;
    }
}
