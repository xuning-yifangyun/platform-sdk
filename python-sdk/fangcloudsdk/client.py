# -*- coding: utf-8 -*-
try:
    from .config import Config
    from .file import File
    from .folder import Folder
    from .item import Item
    from .logger import LoggerFactory
    from .request_client import RequestClient
    from .user import User
except Exception:
    from fangcloudsdk.config import Config
    from fangcloudsdk.file import File
    from fangcloudsdk.folder import Folder
    from fangcloudsdk.item import Item
    from fangcloudsdk.logger import LoggerFactory
    from fangcloudsdk.request_client import RequestClient
    from fangcloudsdk.user import User


class Client(object):
    def __init__(self, oauth=None):
        self._oauth = oauth
        self._request = RequestClient()
        self._logger = LoggerFactory.get_logger_instance()
        self._config = Config()

    def user(self, user_id=None):
        return User(user_id, self.oauth)

    def file(self, file_id=None):
        return File(file_id, self.oauth)

    def folder(self, folder_id=None):
        return Folder(folder_id, self.oauth)

    def item(self):
        return Item(self.oauth)

    @property
    def oauth(self):
        return self._oauth
