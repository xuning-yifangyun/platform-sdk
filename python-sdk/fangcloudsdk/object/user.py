# -*- coding: utf-8 -*-
from fangcloudsdk.object.item import Item
from fangcloudsdk.urltemplate import UrlTemplate
from fangcloudsdk.status_code import StatusCode
from fangcloudsdk.api_call import api_call


class User(Item):
    def __init__(self, user_id=None, oauth=None):
        Item.__init__(self)
        self._user_id = user_id
        self._oauth = oauth
        self.headers = self.add_oauth_header

    def info(self):
        """
        获取用户信息
        :return:
        """
        url = UrlTemplate("/user/info").build_url(base_url=self._config.api_base_url)
        if self._user_id is not None:
            params = {"id": self._user_id}
        else:
            params = None
        response = self._request.send(url=url, method="get", headers=self.headers(self.oauth),
                                      params=params)
        if response.status_code == StatusCode.Success:
            return response.json()
        if response.status_code == StatusCode.UnAuthorized:
            self.real_response(self.oauth)
            return self.info()

    def get_prifile_pic(self, profile_pic_key=None):
        """
        获取用户头像
        :param profile_pic_key:
        :return:
        """
        pass

    @property
    def oauth(self):
        return self._oauth
