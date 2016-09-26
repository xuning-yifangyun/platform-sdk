# -*- coding: utf-8 -*-
from fangcloudsdk.config import Config
from fangcloudsdk.request_client import RequestClient
from fangcloudsdk.logger import LoggerFactory
from fangcloudsdk.status_code import StatusCode
import time
import threading

REF_LOCK = threading.Lock()

class BaseObject(object):
    _lock = threading.Lock()

    def __init__(self):
        self._config = Config()
        self._request = RequestClient()
        self._logger = LoggerFactory.get_logger_instance()

    @staticmethod
    def add_oauth_header(oauth=None):
        headers = {
            "Content-Type": "application/json",
            "Authorization": "Bearer " + str(oauth.access_token)
        }
        return headers

    def real_response(self, oauth):
        count=2
        REF_LOCK.acquire()
        if float(time.time() - oauth.apply_time) > float(oauth.expires_in * 1000):
            oauth.update_token()
            print(str(time.time()) + " " + str(oauth.apply_time))
        REF_LOCK.release()
