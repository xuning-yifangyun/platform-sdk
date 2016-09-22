# -*- coding: utf-8 -*-
class Config(object):
    def __init__(self):
        self.__OAUTH_REQUEST_BASE_URL = "https://oauth-server.fangcloud.net/oauth"
        self.__API_REQUEST_BASE_URL = "https://platform.fangcloud.net/api"
        self.__TEST_BASE_URL = "http://www.networklab.cn"

    @property
    def oauth_base_url(self):
        return self.__OAUTH_REQUEST_BASE_URL

    @property
    def api_base_url(self):
        return self.__API_REQUEST_BASE_URL

    @property
    def test_url(self):
        return self.__TEST_BASE_URL
