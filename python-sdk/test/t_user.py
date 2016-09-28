# -*- coding: utf-8 -*-
import unittest
from fangcloudsdk.config import Config
from test.global_test_config import oauth
from fangcloudsdk.client import Client


class T_User(unittest.TestCase):
    def setUp(self):
        oauth.refresh_token = "bceecd8b-ba45-4aca-8c4e-a80ed253f9f2"
        # oauth.access_token = "94a39c41-25c8-4096-92d9-5c3af3d10138"
        self.client = Client(oauth)
        self.test_user_id = 22149
        Config.set_logger_level(level="DEBUG")

    def test_get_user_info(self):
        user = self.client.user(self.test_user_id).info()
        self.assertTrue(user['success'])

    def test_get_profile_pic(self):
        img = self.client.user(self.test_user_id).get_profile_pic("b3c69fcb4a2f95fceee21f16ced8a07c")
        self.assertEquals(img.headers['Content-Type'], "image/jpeg;charset=utf-8")
        with open("dog.png", "wb") as f:
            f.write(img.content)
            # 图片在当前文件目录下，为dog.jpg

    def tearDown(self):
        pass
