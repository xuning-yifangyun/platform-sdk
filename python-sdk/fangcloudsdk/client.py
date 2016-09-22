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
    def __init__(self, oauth):
        self._oauth = oauth
        self._request = RequestClient()
        self._logger = LoggerFactory.get_logger_instance()
        self._config = Config()

    # @api_call
    def user(self, user_id=None):
        return User(user_id, self.oauth)

    def file(self, file_id=None):
        return File(file_id, self.oauth)

    def folder(self, folder_id=None):
        return Folder(folder_id, self.oauth)

    def item(self):
        return Item(self.oauth)

    def test(self):
        res = self._request.send(url="http://www,baidu.com")
        print()

    @property
    def oauth(self):
        return self._oauth

    @property
    def headers(self):
        headers = {
            "Content-Type": "application/json",
            "Authorization": "Bearer " + self._oauth.access_token
        }
        return headers;

    def api_call(self):
        def decorator(func):
            def wrapper(*args, **kwargs):
                # 前置方法
                print("starting....")
                headers = {
                    "Authorization": "Bearer " + self._oauth.access_token,
                    "Content-Type": "application/json"
                }
                # 发送方法-执行方法
                response = func(*args, **kwargs, headers=headers)
                # 后置方法, 可以做token处理
                print("ending.......")
                if response.status_code.ok:
                    return response.json()
                else:
                    return json.dumps(
                        {"result": False}
                    )
            return wrapper

        return decorator
