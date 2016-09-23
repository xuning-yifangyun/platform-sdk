# -*- coding: utf-8 -*-
from fangcloudsdk.object.item import Item
from fangcloudsdk.urltemplate import UrlTemplate
from fangcloudsdk.api_call import api_call

class User(Item):
    def __init__(self, user_id=None, oauth=None):
        Item.__init__(self)
        self._user_id=user_id
        self._oauth=oauth

    def info(self):
        """
        获取用户信息
        :return:
        """
        url = UrlTemplate("/user/info").build_url(base_url=self._config.api_base_url)
        headers=self.add_oauth_header(self.oauth.access_token)
        if self._user_id is not None:
            params = {"id": self._user_id}
        else:
            params=None
        response = self._request.send(url=url, method="get", headers=headers, params=params)
        return response

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
