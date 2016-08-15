package com.fangcloud.sdk.bean.output.item;

import com.fangcloud.sdk.bean.output.BaseOutput;
import com.google.gson.annotations.SerializedName;

public class ShareItemOutput extends BaseOutput {

    @SerializedName("unique_name")
    private String uniqueName;

    @SerializedName("customized_page_title")
    private String customizedPageTitle;

    public String getUniqueName() {
        return uniqueName;
    }

    public void setUniqueName(String uniqueName) {
        this.uniqueName = uniqueName;
    }

    public String getCustomizedPageTitle() {
        return customizedPageTitle;
    }

    public void setCustomizedPageTitle(String customizedPageTitle) {
        this.customizedPageTitle = customizedPageTitle;
    }
}
