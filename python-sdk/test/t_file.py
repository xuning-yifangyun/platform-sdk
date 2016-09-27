import unittest
from test.global_test_config import oauth
from fangcloudsdk.client import Client


class T_User(unittest.TestCase):
    def setUp(self):
        oauth.refresh_token = "bceecd8b-ba45-4aca-8c4e-a80ed253f9f2"
        # oauth.access_token = "94a39c41-25c8-4096-92d9-5c3af3d10138"
        self.client = Client(oauth)

    def test_get_file_info(self):
        res = self.client.file(file_id="501000483684").info()
        self.assertTrue(res['success'])

    def test_file_update(self):
        res = self.client.file(file_id="501000483684").update("dog.png", "xuning‘s update")
        self.assertTrue(res['success'])

    def test_delete_file(self):
        res = self.client.file().delete(file_ids=[])
        self.assertTrue(res['success'])

    def test_recovery_file_from_trash(self):
        res = self.client.file().recovery_from_trash(recovery_all=True)
        self.assertTrue(res['success'])

    def test_move_file(self):
        res = self.client.file().move(file_ids=[], target_folder_id=0)
        self.assertTrue(res['success'])

    def test_upload(self):
        res = self.client.file().upload(name="dog.png")
        self.assertTrue(res['success'])

    def test_new_version(self):
        res = self.client.file().new_version(name="dog.png", remark="xuning, new version")
        self.assertTrue(res['success'])

    def test_file_download(self):
        res = self.client.file().download()
        self.assertTrue(res['success'])

    def test_preview_file(self):
        res = self.client.file().preview(force_regenerate=None, kind="img64")
        self.assertTrue(res['success'])

    def test_preview_download(self):
        res = self.client.file().preview_download(page_index=0, kind="img64")
        self.assertTrue(res['success'])

    def test_copy(self):
        res = self.client.file().copy(target_folder_id=None)
        self.assertTrue(res['success'])

    def tearDown(self):
        pass
