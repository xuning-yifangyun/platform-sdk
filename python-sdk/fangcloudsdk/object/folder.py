# -*- coding: utf-8 -*-
try:
    from .item import Item
except:
    from fangcloudsdk.object.item import Item


class Folder(Item):
    def __init__(self, folder_id, oauth):
        Item.__init__(self)
        self._folder_id = folder_id
        self._oauth = oauth
        self.headers = self.add_oauth_header

    def info(self):
        """
        获取文件旧爱信息
        :return:
        """
        pass

    def create(self, name=None, parent_id=None):
        """
        创建文件夹
        :param name:
        :param parent_id:
        :return:
        """
        pass

    def update(self, new_name=None):
        """
        更新文件夹
        :param new_name:
        :return:
        """
        pass

    def delete(self, folder_id=None):
        """
        删除文件夹
        :param folder_id:
        :return:
        """
        pass

    def delete_from_trash(self, folder_ids=None, clear_trash=None):
        """
        从回收站删除文件夹
        :param folder_ids:
        :param clear_trash:
        :return:
        """
        pass

    def recovery_from_trash(self, folder_ids=None, recovery_all=None):
        """
        从回收站回复文件夹
        :param folder_ids:
        :param recovery_all:
        :return:
        """
        pass

    def move(self, fold_ids=None, target_folder_id=None):
        """
        移动文件夹到指定文件夹
        :param fold_ids:
        :param target_folder_id:
        :return:
        """
        pass

    def get_children(self, page_id=None, page_capacity=None, type=None):
        """
        获取单层子文件和文件夹列表
        :param page_id:
        :param page_capacity:
        :param type:
        :return:
        """
        pass

    @property
    def oauth(self):
        return self._oauth