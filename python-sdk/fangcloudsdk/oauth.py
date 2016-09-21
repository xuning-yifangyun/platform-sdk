# coding: utf-8
from threading import Lock
from fangcloudsdk.url_template import url_template as url_tp


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
        self._redirecturl = redirect_url
        self._store_tokens_callback = store_tokens
        self._access_token = access_token
        self._refresh_token = refresh_token
        self._expires_in = expires_in
        self._refresh_lock = refresh_lock or Lock()
        self.get_auth_url = url_tp("/authorize")

    def get_authorization_url(self):
        url = self.get_auth_url.build_url(base_url="https://oauth-server.fangcloud.net/oauth")
        taget_url = url + "?client_id={}&redirect_uri={}&response_type={}&state={}" \
            .format(self._client_id, self._redirecturl, "code", None)
        return taget_url

    def authenticate(self, auth_code):
        # 接受授权码，设置token信息
        pass

    def refresh(self):
        # 刷新token
        pass

    def send_token_request(self, data, access_token, expect_refresh_token=True):
        # 发送token请求
        pass

    def revoke(self):
        # 撤销授权，token为null
        pass

    @property
    def access_token(self):
        return self._access_token

    @property
    def refresh_token(self):
        return self._refresh_token
