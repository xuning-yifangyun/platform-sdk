import unittest
from test.global_test_config import oauth
from fangcloudsdk.client import Client


class T_User(unittest.TestCase):
    def test_get_user_info(self):
        # oauth.access_token = "94a39c41-25c8-4096-92d9-5c3af3d10138"
        oauth.refresh_token = "bceecd8b-ba45-4aca-8c4e-a80ed253f9f2"
        client1 = Client(oauth)
        file=client1.file(file_id="501000483684").info()
        print(file)