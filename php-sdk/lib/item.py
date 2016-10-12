# -*- coding: utf-8 -*-
try:
    from .base_object import BaseObject
    from .config import Config
    from .status_code import StatusCode
    from .request_route import ItemRoute
except:
    from fangcloudsdk.base_object import BaseObject
    from fangcloudsdk.config import Config
    from fangcloudsdk.status_code import StatusCode
    from fangcloudsdk.request_route import ItemRoute


class Item(BaseObject):
    def __init__(self, oauth=None):
        BaseObject.__init__(self)
        self._oauth = oauth
        self.headers = self.add_oauth_header

    def search(self, query_words=None, type=None, page_number=None, search_in_folder=None):
        """
        搜索
        :param query_words:
        :param type:
        :param page_number:
        :param search_in_folder:
        :return:
        """
        url = ItemRoute.search.build_url()
        params = {
            "query_words": query_words,
            "type": type,
            "page_number": page_number,
            "search_in_folder": search_in_folder
        }
        headers = self.headers(self.oauth)
        response = self._request.send(url=url, method="get", headers=headers, params=params)
        if response.status_code == StatusCode.Success:
            return response.json()
        else:
            self.deal_response(response, self.oauth)
            return self.search(query_words, type, page_number, search_in_folder)

    @property
    def oauth(self):
        return self._oauth
