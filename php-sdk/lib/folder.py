# -*- coding: utf-8 -*-
try:
    from .item import Item
    from .request_route import FolderRoute
    from .status_code import StatusCode
except Exception:
    from fangcloudsdk.item import Item
    from fangcloudsdk.request_route import FolderRoute
    from fangcloudsdk.status_code import StatusCode

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
        url = FolderRoute.info.build_url(options=self._folder_id)
        response = self._request.send(url=url, method="get", headers=self.headers(self.oauth))
        if response.status_code == StatusCode.Success:
            return response.json()
        else:
            self.deal_response(response, self.oauth)
            return self.info()

    def create(self, name=None, parent_id=None):
        """
        创建文件夹
        :param name:
        :param parent_id:
        :return:
        """
        url = FolderRoute.create.build_url()
        postbody = {
            "name": name,
            "parent_id": parent_id
        }
        response = self._request.send(url=url, method="post", headers=self.headers(self.oauth), postbody=postbody)
        if response.status_code == StatusCode.Success:
            return response.json()
        else:
            self.deal_response(response, self.oauth)
            return self.create(name, parent_id)

    def update(self, new_name=None):
        """
        更新文件夹
        :param new_name:
        :return:
        """
        url = FolderRoute.update.build_url(options=self._folder_id)
        postbody = {
            "name": new_name
        }
        response = self._request.send(url=url, method="put", headers=self.headers(self.oauth), postbody=postbody)
        if response.status_code == StatusCode.Success:
            return response.json()
        else:
            self.deal_response(response, self.oauth)
            return self.update(new_name)

    def delete(self, folder_ids=None):
        """
        删除文件夹
        :param folder_id:
        :return:
        """
        url = FolderRoute.delete.build_url()
        postbody = {
            "folder_ids": folder_ids
        }
        response = self._request.send(url=url, method="delete", headers=self.headers(self.oauth), postbody=postbody)
        if response.status_code == StatusCode.Success:
            return response.json()
        else:
            self.deal_response(response, self.oauth)
            return self.delete(folder_ids)

    def delete_from_trash(self, folder_ids=None, clear_trash=False):
        """
        从回收站删除文件夹
        :param folder_ids:
        :param clear_trash:
        :return:
        """
        url = FolderRoute.delete_from_trash.build_url()
        postbody = {
            "clear_trash": clear_trash,
            "folder_ids": folder_ids
        }
        response = self._request.send(url=url, method="delete", headers=self.headers(self.oauth), postbody=postbody)
        if response.status_code == StatusCode.Success:
            return response.json()
        else:
            self.deal_response(response, self.oauth)
            return self.delete_from_trash(folder_ids, clear_trash)

    def recovery_from_trash(self, folder_ids=None, recovery_all=False):
        """
        从回收站回复文件夹
        :param folder_ids:
        :param recovery_all:
        :return:
        """
        url = FolderRoute.restore_from_trash.build_url()
        postbody = {
            "restore_all": recovery_all,
            "folder_ids": folder_ids
        }
        response = self._request.send(url=url, method="post", headers=self.headers(self.oauth), postbody=postbody)
        if response.status_code == StatusCode.Success:
            return response.json()
        else:
            self.deal_response(response, self.oauth)
            return self.recovery_from_trash(folder_ids, recovery_all)

    def move(self, folder_ids=None, target_folder_id=None):
        """
        移动文件夹到指定文件夹
        :param fold_ids:
        :param target_folder_id:
        :return:
        """
        url = FolderRoute.move.build_url()
        postbody = {
            "target_folder_id": target_folder_id,
            "folder_ids": folder_ids
        }
        response = self._request.send(url=url, method="post", headers=self.headers(self.oauth), postbody=postbody)
        if response.status_code == StatusCode.Success:
            return response.json()
        else:
            self.deal_response(response, self.oauth)
            return self.move(folder_ids, target_folder_id)

    def get_children(self, folder_id, page_id=None, page_capacity=None, type=None):
        """
        获取单层子文件和文件夹列表
        :param page_id:
        :param page_capacity:
        :param type:
        :return:
        """
        url = FolderRoute.children.build_url()
        params = {
            "folder_id": folder_id,
            "page_id": page_id,
            "page_capacity": page_capacity,
            "type": type
        }
        response = self._request.send(url=url, method="get", headers=self.headers(self.oauth), params=params)
        if response.status_code == StatusCode.Success:
            return response.json()
        else:
            self.deal_response(response, self.oauth)
            return self.get_children(folder_id, page_id, page_capacity, type)

    @property
    def oauth(self):
        return self._oauth
