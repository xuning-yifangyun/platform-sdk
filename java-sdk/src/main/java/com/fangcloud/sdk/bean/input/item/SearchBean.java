package com.fangcloud.sdk.bean.input.item;

/**
 * Created by xuning on 2016/8/15.
 */
public class SearchBean {
    private String queryWords;

    private String sortBy;
    private String type;
    private int pageNumber;
    private long searchInFolderId;

    public SearchBean(String queryWords, String type, int pageNumber, long searchInFolderId) {
        this.queryWords = queryWords;
        this.type = type;
        this.pageNumber = pageNumber;
        this.searchInFolderId = searchInFolderId;
    }

    public String getQueryWords() {
        return queryWords;
    }

    public void setQueryWords(String queryWords) {
        this.queryWords = queryWords;
    }

    public String getSortBy() {
        return sortBy;
    }

    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public long getSearchInFolderId() {
        return searchInFolderId;
    }

    public void setSearchInFolderId(long searchInFolderId) {
        this.searchInFolderId = searchInFolderId;
    }
}
