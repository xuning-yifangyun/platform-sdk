# -*- coding: utf-8 -*-
import threading
from test.global_test_config import oauth
from fangcloudsdk.client import Client


class T_Thread(threading.Thread):
    def __init__(self):
        threading.Thread.__init__(self)

    def run(self):
        self.test1_get_user_and_file_info()

    def test1_get_user_and_file_info(self):
        oauth.access_token = "6212a5b7-038e-4b53-886a-045767dab3c91"
        oauth.refresh_token = "bceecd8b-ba45-4aca-8c4e-a80ed253f9f2"
        client1 = Client(oauth)
        file = client1.file(501000483684).info()
        print(file)
        user1 = client1.user(22149).info()
        print(user1)


t1 = T_Thread()
t2 = T_Thread()
t3 = T_Thread()
t4 = T_Thread()
t5 = T_Thread()
t1.start()
t2.start()
t3.start()
t4.start()
t5.start()
