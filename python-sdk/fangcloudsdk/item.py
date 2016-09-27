# -*- coding: utf-8 -*-
try:
    from fangcloudsdk.base_object import BaseObject
except:
    from fangcloudsdk.base_object import BaseObject


class Item(BaseObject):
    def __init__(self, oauth=None):
        BaseObject.__init__(self)
        self._oauth=oauth
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


    @property
    def oauth(self):
        return self._oauth