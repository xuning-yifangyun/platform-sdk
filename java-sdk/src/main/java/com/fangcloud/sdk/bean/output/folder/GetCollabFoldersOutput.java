package com.fangcloud.sdk.bean.output.folder;

import com.fangcloud.sdk.bean.output.PagingResponse;

import java.util.List;

public class GetCollabFoldersOutput extends PagingResponse {
    private List<FolderInfoOutput> folders;

    public List<FolderInfoOutput> getFolders() {
        return folders;
    }

}
