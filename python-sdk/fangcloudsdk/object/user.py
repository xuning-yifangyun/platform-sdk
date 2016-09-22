# -*- coding: utf-8 -*-
from fangcloudsdk.object.item import Item
from fangcloudsdk.urltemplate import UrlTemplate
from fangcloudsdk.api_call import api_call

class User(Item):
    def __init__(self, user_id=None, oauth=None):
        Item.__init__(self)
        self._user_id=user_id
        self._oauth=oauth

    def add_oauth_header(self, headers=None):
        if headers is None:
            headers = {}
        headers={
            "Content-Type" : "application/json",
            "Authorization" : "Bearer "+self._oauth.access_token
        }
        return headers
    @api_call
    def info(self):
        url = UrlTemplate("/user/info").build_url(base_url=self._config.api_base_url)
        headers=self.add_oauth_header()
        if self._user_id is not None:
            params = {"id": self._user_id}
        else:
            params=None
        response = self._request.send(url=url, method="get", headers=headers, params=params)
        return response
    @property
    def oauth(self):
        return self._oauth
