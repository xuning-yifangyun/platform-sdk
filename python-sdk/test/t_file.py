# -*- coding: utf-8 -*-
import unittest
from test.global_test_config import oauth
from fangcloudsdk.client import Client


class T_File(unittest.TestCase):
    def setUp(self):
        oauth.refresh_token = "bceecd8b-ba45-4aca-8c4e-a80ed253f9f2"
        # oauth.access_token = "94a39c41-25c8-4096-92d9-5c3af3d10138"
        self.client = Client(oauth)
        self.test_file_id = 501000483684
        self.test_target_folder_id = 501000031450

    def test_get_file_info(self):
        res = self.client.file(self.test_file_id).info()
        self.assertTrue(res['success'])

    def test_file_update(self):
        res = self.client.file(self.test_file_id).update("dog.png", "xuning's update")
        self.assertTrue(res['success'])

    def test_delete_file(self):
        res = self.client.file().delete(file_ids=[self.test_file_id])
        self.assertTrue(res['success'])

    def test_delete_file_from_trash(self):
        res = self.client.file().delete_from_trash(file_ids=None)
        self.assertTrue(res['success'])

    def test_recovery_file_from_trash(self):
        res = self.client.file().recovery_from_trash(recovery_all=True)
        self.assertTrue(res['success'])

    def test_move_file(self):
        res = self.client.file().move(file_ids=[self.test_file_id], target_folder_id=self.test_target_folder_id)
        self.assertTrue(res['success'])

    def test_upload(self):
        res = self.client.file().upload(parent_id=self.test_target_folder_id, name="dog.png")
        self.assertTrue(res['success'])

    def test_new_version(self):
        res = self.client.file(self.test_file_id).new_version(name="dog.png", remark="xuning, new version test")
        self.assertTrue(res['success'])

    def test_file_download(self):
        res = self.client.file(self.test_file_id).download()
        self.assertTrue(res['success'])

    def test_preview_file(self):
        res = self.client.file(self.test_file_id).preview(kind="image_64")
        self.assertTrue(res['success'])

    def test_preview_download(self):
        res = self.client.file(self.test_file_id).preview_download(page_index=0, kind="image_64")
        self.assertTrue(res['success'])

    def test_copy(self):
        res = self.client.file(self.test_file_id).copy(target_folder_id=self.test_target_folder_id)
        self.assertTrue(res['success'])

    def tearDown(self):
        pass
