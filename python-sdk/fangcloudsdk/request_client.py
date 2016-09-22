from fangcloudsdk.base_httpclient import BaseHttpClient
from fangcloudsdk.logger import LoggerFactory


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
            raise "request method is not support"
        self.logger.debug("request log:\nurl = %s\nmethod = %s\nheader = %s\nparams = %s\ndata = %s\npostbody = %s",
                          url, method, headers, params, data, postbody)
        return response