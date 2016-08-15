package com.fangcloud.sdk.bean.output.item;

import com.fangcloud.sdk.bean.output.PagingResponse;
import com.fangcloud.sdk.bean.output.file.FileInfoOutput;
import com.fangcloud.sdk.bean.output.folder.FolderInfoOutput;

import java.util.List;

public class ItemListOutput extends PagingResponse {
    private List<FileInfoOutput> files;
    private List<FolderInfoOutput> folders;

    public List<FileInfoOutput> getFiles() {
        return files;
    }

    public List<FolderInfoOutput> getFolders() {
        return folders;
    }

    public void setFiles(List<FileInfoOutput> files) {
        this.files = files;
    }

    public void setFolders(List<FolderInfoOutput> folders) {
        this.folders = folders;
    }
}
