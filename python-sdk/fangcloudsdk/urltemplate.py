# -*- coding: utf-8 -*-
try:
    from .config import Config
except Exception:
    from fangcloudsdk.config import Config


class UrlTemplate(object):
    def __init__(self):
        pass

    def __init__(self, uri=None):
        self.__uri = uri
        self.__target_url = None
        self.__base_url = Config.get_api_base_url()

    def build_url(self, options=None):
        if options is None:
            self.__target_url = self.__base_url + self.__uri
        else:
            self.__url = self.__uri % options
            self.__target_url = self.__base_url + self.__url
        return self.__target_url

    @property
    def target_url(self):
        return self.__target_url

    @target_url.setter
    def target_url(self, value=None):
        self.__target_url = value

    @property
    def uri(self):
        return self.__uri

    @uri.setter
    def uri(self, value):
        self.__uri = value
