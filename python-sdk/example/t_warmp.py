class OAuth(object):
    def __init__(self):
        self.token = "123"
        self.refreshToken = "aasdfadsfasdfadsfdsafasfsad"

oauth = OAuth()

class myDecorator(object):

    def __init__(self, f):
        print("inside myDecorator.__init__()")
        self.f = f

    def __call__(self,*args, **kwargs):
        print("inside myDecorator.__call__()")
        print("before")
        response = self.f(*args, **kwargs)
        print("after")        #刷token
        args[0].token = "456"
        print(kwargs.get("aaa"))
        print(args[0].refreshToken)

@myDecorator
def getUserInfo(*args, **kwargs):
    print("inside aFunction()")

print("Finished decorating aFunction()")

getUserInfo(oauth, aaa={"num1":111})
print(oauth.token)
