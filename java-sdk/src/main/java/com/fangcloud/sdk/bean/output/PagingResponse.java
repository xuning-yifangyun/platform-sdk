package com.fangcloud.sdk.bean.output;

import com.google.gson.annotations.SerializedName;

public class PagingResponse extends BaseOutput {
    @SerializedName("total_count")
    protected long totalCount;
    @SerializedName("page_id")
    protected int pageId;
    @SerializedName("page_capacity")
    protected int pageCapacity;

    protected String uuid;

    public long getTotalCount() {
        return this.totalCount;
    }

    public void setTotalCount(long count) {
        this.totalCount = count;
    }

    public int getPageId() {
        return pageId;
    }

    public void setPageId(int pageId) {
        this.pageId = pageId;
    }

    public String getUuid() {
        return this.uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public int getPageCapacity() {
        return pageCapacity;
    }

    public void setPageCapacity(int pageCapacity) {
        this.pageCapacity = pageCapacity;
    }
}
