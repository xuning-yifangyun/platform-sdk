# -*- coding: utf-8 -*-
from fangcloudsdk.config import Config
from fangcloudsdk.request_client import RequestClient
from fangcloudsdk.logger import LoggerFactory
from fangcloudsdk.status_code import StatusCode
from fangcloudsdk.exception import UnAuthorizedException
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

    def deal_response(self, response, oauth):
        status_code=response.status_code
        if status_code == StatusCode.UnAuthorized:
            REF_LOCK.acquire()
            if float(time.time() - oauth.apply_time) > float(oauth.expires_in * 1000):
                oauth.update_token()
            REF_LOCK.release()
        elif status_code == StatusCode.InternalServerError:
            raise "server error"
        else:
            error_ison=response.json()
            raise error_ison['errors']['msg']


