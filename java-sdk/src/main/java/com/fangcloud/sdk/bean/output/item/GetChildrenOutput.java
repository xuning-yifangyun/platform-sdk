package com.fangcloud.sdk.bean.output.item;

import com.fangcloud.sdk.bean.output.PagingResponse;

import java.io.File;
import java.util.List;

public class GetChildrenOutput extends PagingResponse {

    private List<File> files;

    public List<File> getFiles() {
        return files;
    }

    public void setFiles(List<File> files) {
        this.files = files;
    }
}
