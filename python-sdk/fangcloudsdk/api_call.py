# coding: utf-8
import json

def api_call(oauth=None):
    def decorator(func):
        def wrapper(*args, **kwargs):
            # 前置方法
            print("starting....")
            response = func(*args, **kwargs)
            # 后置方法, 可以做token处理
            print("ending.......")
            if response.ok:
                return response.json()
            else:
                # 刷新Token
                oauth.update_token()
                response = func(*args, **kwargs)
                return response
        return wrapper
    return decorator
