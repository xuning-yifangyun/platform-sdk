# -*- coding: utf-8 -*-
import requests

class BaseHttpClient(object):
    def __init__(self):
        pass

    def get(
            self,
            url=None,
            headers=None,
            **kwargs
    ):
        response = requests.get(url=url, params=kwargs.get("params"), headers=headers)
        return response

    def post(
            self,
            url=None,
            headers=None,
            **kwargs
    ):
        response = requests.post(url=url, headers=headers, params=kwargs.get("params"), data=kwargs.get("data"),
                                 json=kwargs.get("postbody"), auth=kwargs.get("auth"))
        return response

    def put(
            self,
            url=None,
            headers=None,
            **kwargs
    ):
        response = requests.put(url=url, headers=headers, data=kwargs.get("data"), json=kwargs.get("postbody"))
        return response

    def delete(
            self,
            url=None,
            headers=None,
            **kwargs
    ):
        response = requests.delete(url=url, headers=headers, data=kwargs.get("data"), json=kwargs.get("postbody"))
        return response
