import unittest
from test.global_test_config import oauth
from fangcloudsdk.client import Client


class T_User(unittest.TestCase):
    def setUp(self):
        oauth.refresh_token = "bceecd8b-ba45-4aca-8c4e-a80ed253f9f2"
        # oauth.access_token = "94a39c41-25c8-4096-92d9-5c3af3d10138"
        self.client = Client(oauth)

    def test_search(self):
        search_res=self.client.item().search(
            query_words="testapi",
            type="all",
            page_number=0,
            search_in_folder=None
        )
        self.assertTrue(search_res['success'])
        print(search_res)

    def tearDown(self):
        pass