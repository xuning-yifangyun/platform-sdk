# coding: utf-8
import json


def api_call():
    def decorator(func):
        def wrapper(*args, **kwargs):
            # 前置方法
            response = func(*args, **kwargs)
            # 后置方法, 可以做token处理
            if response.ok:
                # .status_code
                print(args)
                return response.json()
            else:
                # 刷新Token的业务逻辑
                response = func(*args, **kwargs)
                return response
        return wrapper

    return decorator
