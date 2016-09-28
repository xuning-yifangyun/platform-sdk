# -*- coding: utf-8 -*-
try:
    from .exception import LogException
except Exception:
    from fangcloudsdk.exception import LogException


class Config(object):
    __OAUTH_REQUEST_BASE_URL = "https://oauth-server.fangcloud.net/oauth"
    __API_REQUEST_BASE_URL = "https://platform.fangcloud.net/api"
    __LOGGER_LEVEL = "DEBUG"
    __LOG_FILE_PATH = "fangcloud-sdk-log.log"

    @staticmethod
    def get_oauth_base_url():
        return Config.__OAUTH_REQUEST_BASE_URL

    @staticmethod
    def get_api_base_url():
        return Config.__API_REQUEST_BASE_URL

    @staticmethod
    def get_log_level():
        return Config.__LOGGER_LEVEL

    @staticmethod
    def get_log_file_path():
        return Config.__LOG_FILE_PATH

    @staticmethod
    def set_logger_level(level="DEBUG"):
        Config.__LOGGER_LEVEL = level

    @staticmethod
    def set_log_file_path(path=None):
        if path is not None:
            Config.__LOG_FILE_PATH = path
        else:
            raise LogException("log file path is null")
