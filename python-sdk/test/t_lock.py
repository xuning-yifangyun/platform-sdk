import threading
import time
from test.global_test_config import oauth
from fangcloudsdk.client import Client


class T_Thread(threading.Thread):
    def __init__(self):
        threading.Thread.__init__(self)
        self.lock = threading.Lock()

    def run(self):

        self.test1_get_user_info()


    def test1_get_user_info(self):
        self.lock.acquire()
        print("aaaaa")
        print("bbbb")
        print("cccc")
        self.lock.release()

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
