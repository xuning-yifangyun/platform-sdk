def api_call(oauth=None):
    def decorator(func):
        def wrapper(*args, **kwargs):
            # 前置方法
            print("starting....")
            headers={
                "Authorization":"Bearer 01e5ea72-7e05-4a75-9ada-32ed883a5678",
                "Content-Type":"application/json"
            }
            # 发送方法-执行方法
            rst = func(*args, **kwargs, headers=headers)
            # 后置方法
            print("ending.......")
            return rst
        return wrapper
    return decorator


@api_call(4)
def f(var):
    if var > 0:
        var = 1111
    else:
        var = 2222
    return var
res=f(-444)
print(res)