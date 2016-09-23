# -*- coding: utf-8 -*-
import threading

class api_call(object):
    def __init__(self, func):
        self.func = func
        self._lock = threading.Lock()

    def __call__(
            self,
            *args,
            **kwargs
    ):
        print("before")
        response = self.func(*args, **kwargs)
        print("after")
        if response.ok:
            return response.json()
        elif response.status_code == 401:
            # 同步锁定
            self._lock.acquire()
            oauth=oauth=kwargs.get("oauth")
            print(oauth)
            # oauth = kwargs.get("oauth").update_token()
            self._lock.release()
            # 解硕
            # self.func(*args, **kwargs)
        else:
            raise "refresh token is expirsed or involid"