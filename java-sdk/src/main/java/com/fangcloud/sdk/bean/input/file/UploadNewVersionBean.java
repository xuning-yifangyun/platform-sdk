package com.fangcloud.sdk.bean.input.file;

public class UploadNewVersionBean extends UploadFileBean {
    private String remark; // 上传新版本时对新版本的备注

    public UploadNewVersionBean(long parentFolderId, String name, UploadType uploadType, String remark) {
        super(parentFolderId, name, uploadType);
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
