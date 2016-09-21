from fangcloudsdk.logger import LoggerFactory
from fangcloudsdk.request_client import RequestClient


class Client(object):
    def __init__(self, oauth):
        self._oauth = oauth
        self._request = RequestClient()
        self._logger = LoggerFactory.get_logger_instance()


    def user(self, user_id=None):
        pass

    def file(self, file_id=None):
        pass

    def folder(self, folder_id=None):
        pass
    def test(self):
        res=self._request.send(url="http://www,baidu.com")
        print()
    @property
    def oauth(self):
        return self._oauth
client=Client("d")
client._request.send()