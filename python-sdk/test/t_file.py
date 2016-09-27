import unittest
from test.global_test_config import oauth
from fangcloudsdk.client import Client


class T_User(unittest.TestCase):
    def setUp(self):
        oauth.refresh_token = "bceecd8b-ba45-4aca-8c4e-a80ed253f9f2"
        # oauth.access_token = "94a39c41-25c8-4096-92d9-5c3af3d10138"
        self.client = Client(oauth)

    def test_get_user_info(self):
        file = self.client.file(file_id="501000483684").info()
        self.assertTrue(file['success'])

    def test_file_update(self):
        file = self.client.file(file_id="501000483684").update("xuning", "xuning‘s update")
        self.assertTrue(file['success'])

    def tearDown(self):
        pass