package com.fangcloud.sdk.bean.output.folder;

import com.fangcloud.sdk.bean.output.PagingResponse;

import java.util.List;

public class GetCollabFoldersOutput extends PagingResponse {
    private List<FolderInfo> folders;

    public List<FolderInfo> getFolders() {
        return folders;
    }

}
