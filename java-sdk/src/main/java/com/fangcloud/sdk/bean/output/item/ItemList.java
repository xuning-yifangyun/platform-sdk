package com.fangcloud.sdk.bean.output.item;

import com.fangcloud.sdk.bean.output.PagingResponse;
import com.fangcloud.sdk.bean.output.file.FileInfo;
import com.fangcloud.sdk.bean.output.folder.FolderInfo;

import java.util.List;

public class ItemList extends PagingResponse {
    private List<FileInfo> files;
    private List<FolderInfo> folders;

    public List<FileInfo> getFiles() {
        return files;
    }

    public List<FolderInfo> getFolders() {
        return folders;
    }

    public void setFiles(List<FileInfo> files) {
        this.files = files;
    }

    public void setFolders(List<FolderInfo> folders) {
        this.folders = folders;
    }
}
