# -*- coding: utf-8 -*-
from fangcloudsdk.status_code import StatusCode
from fangcloudsdk.urltemplate import UrlTemplate

try:
    from .item import Item
    from .request_route import FileRoute
except:
    from fangcloudsdk.item import Item
    from fangcloudsdk.request_route import FileRoute


class File(Item):
    def __init__(self, file_id=None, oauth=None):
        Item.__init__(self)
        self._file_id = file_id
        self._oauth = oauth
        self.headers = self.add_oauth_header

    def info(self):
        """
        获取文件信息
        :return:
        """
        url = FileRoute.info.build_url(options=(self._file_id))
        response = self._request.send(url=url, method="get", headers=self.headers(self.oauth))
        if response.status_code == StatusCode.Success:
            return response.json()
        else:
            self.deal_response(response, self.oauth)
            return self.info()

    def update(self, new_name=None, new_descript=None):
        """
        更新文件信息
        :param new_name:
        :param new_descript:
        :return:
        """
        url = FileRoute.update.build_url(options=(self._file_id))
        headers = self.headers(self.oauth)
        postbody = {
            "name": new_name,
            "description": new_descript
        }
        response = self._request.send(url=url, method="put", headers=headers, postbody=postbody)
        if response.status_code == StatusCode.Success:
            return response.json()
        else:
            self.deal_response(response, self.oauth)
            return self.update(new_name, new_descript)

    def delete(self, file_ids=None):
        """
        删除文件，支持批量删除
        :param file_ids:
        :return:
        """
        url = FileRoute.delete.build_url()
        headers = self.headers(self.oauth)
        postbody = {
            "file_ids": file_ids
        }
        response = self._request.send(url=url, method="delete", headers=headers, postbody=postbody)
        if response.status_code == StatusCode.Success:
            return response.json()
        else:
            self.deal_response(response, self.oauth)
            return self.delete(file_ids)

    def delete_from_trash(self, file_ids=None, clear_trash=False):
        """
        从回收站删除文件
        :param file_ids:
        :param clear_trash:
        :return:
        """
        url = FileRoute.delete_from_trash.build_url()
        headers = self.headers(self.oauth)
        postbody = {
            "clear_trash": clear_trash,
            "file_ids": file_ids
        }
        response = self._request.send(url=url, method="delete", headers=headers, postbody=postbody)
        if response.status_code == StatusCode.Success:
            return response.json()
        else:
            self.deal_response(response, self.oauth)
            return self.delete_from_trash(file_ids, clear_trash)

    def recovery_from_trash(self, file_ids=None, recovery_all=None):
        """
        从回收站恢复文文件
        :param file_ids:
        :param recovery_all:
        :return:
        """
        url = FileRoute.restore_from_trash.build_url()
        headers = self.headers(self.oauth)
        postbody = {
            "restore_all": recovery_all,
            "file_ids": file_ids
        }
        response = self._request.send(url=url, method="post", headers=headers, postbody=postbody)
        if response.status_code == StatusCode.Success:
            return response.json()
        else:
            self.deal_response(response, self.oauth)
            return self.recovery_from_trash(file_ids, recovery_all)

    def move(self, file_ids=None, target_folder_id=None):
        """
        移动文件到制定文件夹
        :param file_ids:
        :param target_folder_id:
        :return:
        """
        url = FileRoute.move.build_url()
        headers = self.headers(self.oauth)
        postbody = {
            "target_folder_id": target_folder_id,
            "file_ids": file_ids
        }
        response = self._request.send(url=url, method="post", headers=headers, postbody=postbody)
        if response.status_code == StatusCode.Success:
            return response.json()
        else:
            self.deal_response(response, self.oauth)
            return self.move(file_ids, target_folder_id)

    def upload(self, parent_id=None, name=None):
        """
        获取新文件上传地址
        :param parent_id:
        :param name:
        :return:
        """
        url = FileRoute.upload.build_url()
        headers = self.headers(self.oauth)
        postbody = {
            "parent_id": parent_id,
            "name": name,
            "upload_type": "api"
        }
        response = self._request.send(url=url, method="post", headers=headers, postbody=postbody)
        if response.status_code == StatusCode.Success:
            return response.json()
        else:
            self.deal_response(response, self.oauth)
            return self.upload(parent_id, name)

    def new_version(self, name=None, remark=None):
        """
        获取文件上传新版本地址
        :param name:
        :param remark:
        :return:
        """
        url = FileRoute.new_version.build_url(options=(self.file_id))
        headers = self.headers(self.oauth)
        postbody = {
            "name": name,
            "upload_type": "api",
            "remark": remark
        }
        response = self._request.send(url=url, method="post", headers=headers, postbody=postbody)
        if response.status_code == StatusCode.Success:
            return response.json()
        else:
            self.deal_response(response, self.oauth)
            return self.new_version(name, remark)

    def download(self):
        """"
        获取文件的下载地址
        """
        url = FileRoute.download.build_url(options=(self.file_id))
        headers = self.headers(self.oauth)
        response = self._request.send(url=url, method="get", headers=headers)
        if response.status_code == StatusCode.Success:
            return response.json()
        else:
            self.deal_response(response, self.oauth)
            return self.download()

    def preview(self, force_regenerate=False, kind=None):
        """
        预览文件
        :param force_regenerate:
        :param kind:
        :return:
        """
        url = FileRoute.preview.build_url(options=(self.file_id))
        headers = self.headers(self.oauth)
        postbody = {
            "force_regenerate": force_regenerate,
            "kind": kind
        }
        response = self._request.send(url=url, method="post", headers=headers, postbody=postbody)
        if response.status_code == StatusCode.Success:
            return response.json()
        else:
            self.deal_response(response, self.oauth)
            return self.preview(force_regenerate, kind)

    def preview_download(self, page_index=None, kind=None):
        """
        获取文件预览转换后的下载地址
        :param page_index:
        :param kind:
        :return:
        """
        url = FileRoute.preview_download.build_url(options=(self.file_id))
        headers = self.headers(self.oauth)
        postbody = {
            "page_index": page_index,
            "kind": kind
        }
        response = self._request.send(url=url, method="post", headers=headers, postbody=postbody)
        if response.status_code == StatusCode.Success:
            return response.json()
        else:
            self.deal_response(response, self.oauth)
            return self.preview_download(page_index, kind)

    def get_preview_frame_url(self, file_name=None):
        """
        预览嵌入
        :param file_name:
        :return:
        """
        # 反回url

    def copy(self, target_folder_id=None, check_conflict=False):
        """
        复制文件
        :param target_folder_id:
        :param check_conflict:
        :return:
        """
        url = FileRoute.copy.build_url()
        headers = self.headers(self.oauth)
        postbody = {
            "file_id": self.file_id,
            "target_folder_id": target_folder_id,
            "is_check_conflict": check_conflict
        }
        response = self._request.send(url=url, method="post", headers=headers, postbody=postbody)
        if response.status_code == StatusCode.Success:
            return response.json()
        else:
            self.deal_response(response, self.oauth)
            return self.copy(target_folder_id, check_conflict)

    @property
    def oauth(self):
        return self._oauth

    @property
    def file_id(self):
        return self._file_id
