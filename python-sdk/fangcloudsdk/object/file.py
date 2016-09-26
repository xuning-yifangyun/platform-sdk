# -*- coding: utf-8 -*-
from fangcloudsdk.urltemplate import UrlTemplate
from fangcloudsdk.status_code import StatusCode
from fangcloudsdk.config import Config
try:
    from .item import Item
except:
    from fangcloudsdk.object.item import Item


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
        url = UrlTemplate("/file/%s/info").build_url(options=(self._file_id), base_url=self._config.api_base_url)
        response = self._request.send(url=url, method="get", headers=self.headers(self.oauth))
        if response.status_code == StatusCode.Success:
            return response.json()
        if response.status_code == StatusCode.UnAuthorized:
            self.real_response(self.oauth)
            return self.info()

    def update(self0, new_name=None, new_descript=None):
        """
        更新文件信息
        :param new_name:
        :param new_descript:
        :return:
        """
        pass

    def delete(self, file_ids=None):
        """
        删除文件，支持批量删除
        :param file_ids:
        :return:
        """
        pass

    def delete_from_trash(self, file_ids=None, clear_trash=None):
        """
        从回收站删除文件
        :param file_ids:
        :param clear_trash:
        :return:
        """
        pass

    def recovery_from_trash(self, file_ids=None, recovery_all=None):
        """
        从回收站恢复文文件
        :param file_ids:
        :param recovery_all:
        :return:
        """
        pass

    def move(self, file_ids=None, target_folder_id=None):
        """
        移动文件到制定文件夹
        :param file_ids:
        :param target_folder_id:
        :return:
        """
        pass

    def upload(self, parent_id=None, name=None):
        """
        获取新文件上传地址
        :param parent_id:
        :param name:
        :return:
        """
        pass

    def new_version(self, name=None, remark=None):
        """
        获取文件上传新版本地址
        :param name:
        :param remark:
        :return:
        """
        pass

    def download(self):
        """"
        获取文件的下载地址
        """
        pass

    def preview(self, force_regenerate=None, kind=None):
        """
        预览文件
        :param force_regenerate:
        :param kind:
        :return:
        """
        pass

    def preview_download(self, page_index=None, kind=None):
        """
        获取文件预览转换后的下载地址
        :param page_index:
        :param kind:
        :return:
        """
        pass

    def get_preview_frame_url(self, file_name=None):
        """
        预览嵌入
        :param file_name:
        :return:
        """
        pass

    def copy(self, target_folder_id=None, check_conflict=None):
        """
        复制文件
        :param target_folder_id:
        :param check_conflict:
        :return:
        """
        pass
    @property
    def oauth(self):
        return self._oauth