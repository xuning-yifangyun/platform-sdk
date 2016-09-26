from fangcloudsdk.oauth import OAuth
from test.global_test_config import oauth
import unittest


class T_Oauth(unittest.TestCase):
    @staticmethod
    def test_url():
        print(oauth.get_authorization_url())

    @staticmethod
    def test_get_token_by_auth_code():
        auth_code = "Kw07Ed"
        token = oauth.authenticate(auth_code=auth_code)
        print(token)

    @staticmethod
    def test_get_token_by_refresh_token():
        oauth.refresh_token = "bceecd8b-ba45-4aca-8c4e-a80ed253f9f2"
        g_oauth = oauth.update_token()
        print(g_oauth)

    @staticmethod
    def test_revoke():
        oauth.revoke()
