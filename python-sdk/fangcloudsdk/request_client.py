from fangcloudsdk.base_httpclient import BaseHttpClient
from fangcloudsdk.logger import LoggerFactory

class RequestClient(object):
    def __init__(self):
        self.base_httpclient = BaseHttpClient()
        self.logger = LoggerFactory.get_logger_instance()
    def send(
            self,
            url=None,
            method=None,
            headers=None,
            params=None,
            data=None,
            postbody=None
    ):
        method = str.upper(method)
        if method == "GET":
            response = self.base_httpclient.get(
                url=url, headers=headers, params=params
            )
        elif method == "POST":
            response = self.base_httpclient.post(
                url=url, headers=headers, params=params, data=data, postbody=postbody
            )
        elif method == "PUT":
            response = self.base_httpclient.put(
                url=url, headers=headers, data=data, postbody=postbody
            )
        elif method == "DELETE":
            response = self.base_httpclient.delete(
                url=url, headers=headers, data=data, postbody=postbody
            )
        else:
            raise "request method not support"
        self.logger.debug("response: %s", response.text)
        return response
