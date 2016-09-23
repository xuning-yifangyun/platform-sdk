# -*- coding: utf-8 -*-
try:
    from .base_object import BaseObject
except:
    from fangcloudsdk.object.base_object import BaseObject


class Item(BaseObject):
    def __init__(self):
        BaseObject.__init__(self)
        pass

    def search(self, query_words=None, type=None, page_number=None, search_in_folder=None):
        """
        搜索
        :param query_words:
        :param type:
        :param page_number:
        :param search_in_folder:
        :return:
        """
        pass