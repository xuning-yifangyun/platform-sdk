import unittest
from test.global_test_config import oauth
from fangcloudsdk.client import Client


class T_Folder(unittest.TestCase):
    def setUp(self):
        oauth.refresh_token = "bceecd8b-ba45-4aca-8c4e-a80ed253f9f2"
        # oauth.access_token = "94a39c41-25c8-4096-92d9-5c3af3d10138"
        self.client = Client(oauth)

    def test_get_folder_info(self):
        file = self.client.folder(folder_id=501000031450).info()
        self.assertTrue(file['success'])

    def test_create_folder(self):
        res = self.client.folder().create(name="aaaaa", parent_id=501000031450)
        self.assertTrue(res['success'])

    def test_update_folder(self):
        res = self.client.folder().update("testapi")
        self.assertTrue(res['success'])

    def test_delete_folder(self):
        res = self.client.folder().delete(folder_ids=[11111, 2222])
        self.assertTrue(res['success'])

    def test_delete_folder_from_trash(self):
        res = self.client.folder().delete_from_trash(folder_ids=[11111, 2222])
        self.assertTrue(res['success'])

    def test_restart_folder_from_trash(self):
        res = self.client.folder().recovery_from_trash(recovery_all=True)
        self.assertTrue(res['success'])

    def test_move_folder(self):
        res = self.client.folder().move(folder_ids=[11111, 2222], target_folder_id=501000031450)
        self.assertTrue(res['success'])

    def test_get_folder_childer(self):
        res = self.client.folder().get_children(folder_id=501000031450, page_id=0, page_capacity=10, type=None)
        self.assertTrue(res['success'])

    def tearDown(self):
        pass
