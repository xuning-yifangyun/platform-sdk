package com.fangcloud.sdk.bean.input.file;

import com.google.gson.annotations.SerializedName;

/**
 * 分享文件api的输入
 */
public class ShareItemBean {

    private String access;

    @SerializedName("disable_download")
    private boolean disableDownload;

    @SerializedName("due_time")
    private long dueTime;

    @SerializedName("password_protected")
    private boolean passwordProtected;

    private String password;

    public ShareItemBean(String access, boolean disableDownload, long dueTime, boolean passwordProtected, String password, Boolean requireUpdate) {
        this.access = access;
        this.disableDownload = disableDownload;
        this.dueTime = dueTime;
        this.passwordProtected = passwordProtected;
        this.password = password;
        this.requireUpdate = requireUpdate;
    }

    // 重要：这个参数不能使用基本类型boolean，不然默认值会为false，实际默认值会在Action中设置
    @SerializedName("require_update")
    private Boolean requireUpdate;

    public String getAccess() {
        return access;
    }

    public void setAccess(String access) {
        this.access = access;
    }

    public boolean isDisableDownload() {
        return disableDownload;
    }

    public void setDisableDownload(boolean disableDownload) {
        this.disableDownload = disableDownload;
    }

    public long getDueTime() {
        return dueTime;
    }

    public void setDueTime(long dueTime) {
        this.dueTime = dueTime;
    }

    public boolean isPasswordProtected() {
        return passwordProtected;
    }

    public void setPasswordProtected(boolean passwordProtected) {
        this.passwordProtected = passwordProtected;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean isRequireUpdate() {
        return requireUpdate;
    }

    public void setRequireUpdate(Boolean requireUpdate) {
        this.requireUpdate = requireUpdate;
    }
}
