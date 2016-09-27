# -*- coding: utf-8 -*-
import threading

REF_LOCK = threading.Lock()
class api_call(object):
    def __init__(self, func):
        self.func = func
    def __call__(
            self,
            *args,
            **kwargs
    ):
        print("before")
        response = self.func(*args, **kwargs)
        print("after")
        if response.ok:
            return response
        elif response.status_code == 401:
            # 同步锁定
            REF_LOCK._lock.acquire()
            s = kwargs.get("oauth")
            print()
            REF_LOCK._lock.release()
            return response
        else:
            raise "refresh token is expirsed or involid"