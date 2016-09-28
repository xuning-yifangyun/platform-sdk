# -*- coding: utf-8 -*-
try:
    from .request_client import RequestClient
    from .auth import HTTPBasicAuth
    from .config import Config
    from .exception import OauthException
except Exception:
    from fangcloudsdk.request_client import RequestClient
    from requests.auth import HTTPBasicAuth
    from fangcloudsdk.config import Config
    from fangcloudsdk.exception import OauthException
import time
import threading


class OAuth(object):
    def __init__(
            self,
            client_id=None,
            client_secret=None,
            redirect_url=None
    ):
        self._client_id = client_id
        self._client_secret = client_secret
        self._redirect_url = redirect_url
        self._store_tokens_callback = None
        self._access_token = None
        self._refresh_token = None
        self._expires_in = 0
        self._apply_time = 0
        self._request_session = RequestClient()
        self.get_auth_url = Config.get_oauth_base_url()+"/authorize"
        self.get_token_url = Config.get_oauth_base_url()+"/token"

    def get_authorization_url(self):
        """
        获取授权url
        :return:
        """
        url = self.get_auth_url
        taget_url = url + "?client_id={}&redirect_uri={}&response_type={}&state={}" \
            .format(self._client_id, self._redirect_url, "code", None)
        return taget_url

    def authenticate(self, auth_code=None):
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
            self.access_token, self.refresh_token, self.expires_in, self.apply_time \
                = new_token['access_token'], new_token['refresh_token'], new_token['expires_in'], time.time()
            return new_token
        else:
            raise OauthException(error_message="auth code involid or is null")

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
            self.access_token, self.refresh_token, self.expires_in, self.apply_time \
                = new_token['access_token'], new_token['refresh_token'], new_token['expires_in'], time.time()
            return new_token
        else:
            raise OauthException(error_message="refresh token is involid or null")

    def token_request(self, params):
        """
        token request
        :param params:
        :return:
        """
        url = self.get_token_url
        auth = HTTPBasicAuth(
            self._client_id,
            self._client_secret
        )
        response = self._request_session.send(url=url, method="post", params=params, auth=auth)
        return response

    def revoke(self):
        """
        撤销授权
        :return:
        """
        self.access_token = None
        self.refresh_token = None
        self.expires_in = 0
        self.apply_time = 0
        if self.access_token is None:
            return True
        else:
            return False

    @property
    def access_token(self):
        return self._access_token

    @property
    def refresh_token(self):
        return self._refresh_token

    @property
    def expires_in(self):
        return self._expires_in

    @property
    def apply_time(self):
        return self._apply_time

    @access_token.setter
    def access_token(self, value):
        self._access_token = value

    @refresh_token.setter
    def refresh_token(self, value):
        self._refresh_token = value

    @expires_in.setter
    def expires_in(self, value):
        self._expires_in = value

    @apply_time.setter
    def apply_time(self, value):
        self._apply_time = value