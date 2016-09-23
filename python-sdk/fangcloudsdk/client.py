# -*- coding: utf-8 -*-
from fangcloudsdk.logger import LoggerFactory
from fangcloudsdk.request_client import RequestClient
from fangcloudsdk.config import Config
from fangcloudsdk.object.user import User
from fangcloudsdk.object.file import File
from fangcloudsdk.object.folder import Folder
from fangcloudsdk.object.item import Item

import json


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

    def test(self):
        res = self._request.send(url="http://www.baidu.com", method="get")
        print(res.text)

    @property
    def oauth(self):
        return self._oauth
