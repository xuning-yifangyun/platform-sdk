package com.fangcloud.sdk.bean.output;

import com.fangcloud.sdk.bean.output.elements.MiniEnterprise;

public class GetEnterpriseInfoOutput extends BaseOutput {
    private MiniEnterprise enterprise;

    public MiniEnterprise getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(MiniEnterprise enterprise) {
        this.enterprise = enterprise;
    }
}
