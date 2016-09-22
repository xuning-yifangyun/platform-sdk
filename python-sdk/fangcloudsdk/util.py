# -*- coding: utf-8 -*-
class request_util:
    @staticmethod
    def build_headers(headers=None):
        if headers is None:
            headers={}
        for key, value in headers.items():
            headers[key]=value
        return headers

    @staticmethod
    def quick_build_url(uri):
        from fangcloudsdk.urltemplate import UrlTemplate
        return UrlTemplate(uri).build_url