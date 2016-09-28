# -*- coding: utf-8 -*-
try:
    from .base_httpclient import BaseHttpClient
    from .logger import LoggerFactory
    from .exception import RequestErrorException
except Exception:
    from fangcloudsdk.base_httpclient import BaseHttpClient
    from fangcloudsdk.logger import LoggerFactory
    from fangcloudsdk.exception import RequestErrorException


class RequestClient(object):
    def __init__(self):
        self.request_session = BaseHttpClient()
        self.logger = LoggerFactory.get_logger_instance()

    def send(
            self,
            url=None,
            method=None,
            headers=None,
            params=None,
            data=None,
            postbody=None,
            auth=None,
            oauth= None,
            stream=False,
            *args,
            **kwargs
    ):
        method = str.upper(method)
        if method == "GET":
            response = self.request_session.get(
                url=url, headers=headers, params=params, stream=stream
            )
        elif method == "POST":
            response = self.request_session.post(
                url=url, headers=headers, params=params, data=data, postbody=postbody, auth=auth
            )
        elif method == "PUT":
            response = self.request_session.put(
                url=url, headers=headers, data=data, postbody=postbody
            )
        elif method == "DELETE":
            response = self.request_session.delete(
                url=url, headers=headers, data=data, postbody=postbody
            )
        else:
            raise RequestErrorException("request method is not support")
        # self.logger.debug("request log:\nurl => %s\nmethod => %s\nheader => %s\nparams => %s\ndata => %s\npostbody => %s",
        #                   url, method, headers, params, data, postbody)
        self.logger.debug(
            "request log: [url: %s], [method, %s], [header, %s], [params, %s], [data, %s], [postbody, %s]",
                          url, method, headers, params, data, postbody)
        if str(response.headers['Content-Type']) == "image/jpeg;charset=utf-8":
            response_json="is image"
        else:
            response_json=response.json()
        self.logger.debug("response log: status [code: %s], [json=%s]", response.status_code, response_json)
        return response