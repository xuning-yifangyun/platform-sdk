# -*- coding: utf-8 -*-
from fangcloudsdk.config import Config
from fangcloudsdk.request_client import RequestClient
from fangcloudsdk.logger import LoggerFactory


class BaseObject(object):
    def __init__(self):
        self._config = Config()
        self._request = RequestClient()
        self._logger = LoggerFactory.get_logger_instance()

    def add_oauth_header(self, access_token=None):
        headers={
            "Content-Type" : "application/json",
            "Authorization" : "Bearer "+access_token
        }
        return headers