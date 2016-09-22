from fangcloudsdk.request_client import RequestClient
bh=RequestClient()
print(bh.send(
    url="https://www.baidu.com/img/bd_logo1.png",
    params={"username":"徐宁"},
    method="GET", data="", postbody=""
).content)

def f(a, *args):
    print(args[0])
f(3,b=4)