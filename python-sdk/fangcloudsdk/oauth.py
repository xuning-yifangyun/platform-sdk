# -*- coding: utf-8 -*-
from threading import Lock
from fangcloudsdk.urltemplate import UrlTemplate as url_tp
from fangcloudsdk.request_client import RequestClient
from requests.auth import HTTPBasicAuth
import threading

class OAuth(object):

    def __init__(
            self,
            client_id,
            client_secret,
            redirect_url,
            store_tokens=None,
            access_token=None,
            refresh_token=None,
            expires_in=None,
            refresh_lock=None,
    ):
        self._client_id = client_id
        self._client_secret = client_secret
        self._redirect_url = redirect_url
        self._store_tokens_callback = store_tokens
        self._access_token = access_token
        self._refresh_token = refresh_token
        self._expires_in = expires_in
        self._request_session = RequestClient()
        self.get_auth_url = url_tp("/authorize")


    # 获取授权url
    def get_authorization_url(self):
        """
        获取授权url
        :return:
        """
        url = self.get_auth_url.build_url(base_url="https://oauth-server.fangcloud.net/oauth")
        taget_url = url + "?client_id={}&redirect_uri={}&response_type={}&state={}" \
            .format(self._client_id, self._redirect_url, "code", None)
        return taget_url

    # 接受授权码，设置token信息
    def authenticate(self, auth_code):
        """
        根据授权码获取token
        :param auth_code:
        :return:
        """
        params = {
            "grant_type": "authorization_code",
            "code": auth_code,
            "redirect_uri": self._redirect_url
        }
        response = self.token_request(params=params)
        if response.ok:
            new_token = response.json()
            self.access_token, self.refresh_token = new_token['access_token'], new_token['refresh_token']
            return new_token
        else:
            raise "auth code involid"

    # 更新token
    def update_token(self):
        """
        刷新token
        :return:
        """
        params = {
            "grant_type": "refresh_token",
            "refresh_token": self._refresh_token
        }
        response = self.token_request(params=params)
        if response.ok:
            new_token = response.json()
            self.access_token, self.refresh_token = new_token['access_token'], new_token['refresh_token']
            return new_token
        else:
            raise "refresh token is expired or involid"

    # 封装token请求
    def token_request(self, params):
        """
        token request
        :param params:
        :return:
        """
        url = "https://oauth-server.fangcloud.net/oauth/token"
        auth = HTTPBasicAuth(
            self._client_id,
            self._client_secret
        )
        response = self._request_session.send(url=url, method="post", params=params, auth=auth)
        return response

    # 撤销Token
    def revoke(self):
        """
        撤销授权
        :return:
        """
        self.access_token = None
        self.refresh_token = None
        if self.access_token is None and self.refresh_token is None:
            return True
        else:
            return False

    @property
    def access_token(self):
        return self._access_token

    @property
    def refresh_token(self):
        return self._refresh_token

    @access_token.setter
    def access_token(self, value):
        self._access_token = value

    @refresh_token.setter
    def refresh_token(self, value):
        self._refresh_token = value