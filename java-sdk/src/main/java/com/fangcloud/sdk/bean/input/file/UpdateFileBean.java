package com.fangcloud.sdk.bean.input.file;

import com.fangcloud.sdk.bean.input.BaseApiBean;

public class UpdateFileBean extends BaseApiBean {

    private String name;
    private String description;

    public UpdateFileBean(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
