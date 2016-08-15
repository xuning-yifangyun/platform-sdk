package com.fangcloud.sdk.api;

import com.fangcloud.sdk.request.RequestOption;
import com.fangcloud.sdk.bean.output.item.ItemListOutput;
import com.fangcloud.sdk.core.Config;
import com.fangcloud.sdk.core.Connection;
import com.fangcloud.sdk.request.Header;
import com.fangcloud.sdk.request.RequestClient;
import com.fangcloud.sdk.util.TransformationUtil;
import com.fangcloud.sdk.util.UrlTemplate;

import java.util.List;

public class ItemApi {
    private Connection connection;
    private List<Header> headers;
    private static final UrlTemplate SEARCH = new UrlTemplate("/item/search");

    public ItemApi(Connection connection) {
        this.connection = connection;
        this.headers = RequestOption.getApiCommonHeader(this.connection);
    }

    /**
     * 搜索
     *
     * @param queryWords
     * @param type
     * @param pageNumber
     * @param searchInFolder
     * @return
     */
    public ItemListOutput search(String queryWords, String type, int pageNumber, int searchInFolder) {
        String baseUrl = SEARCH.build(Config.DEFAULT_API_URI);
        String url = String.format(baseUrl + "?query_words=%s&type=%s&page_number=%s&search_in_folder=%s", queryWords, type, pageNumber, searchInFolder);
        RequestClient requestClient = new RequestClient(url, "get", headers, null, null);
        return (ItemListOutput) TransformationUtil.requestClientToOutputObject(requestClient, ItemListOutput.class);
    }
}
