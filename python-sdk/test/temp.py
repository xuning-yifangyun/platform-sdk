import requests as req
from fangcloudsdk.base_httpclient import BaseHttpClient
from fangcloudsdk.url_template import url_template
# params={
#     "username" : "徐宁"
# }
# t=req.get(url="http://www.networklab.cn/test/parm.php", params=params).json()
# print(t)
# print(type(t))
#
# net_url_tem = url_template("/test/parm.php").build_url(options=None, base_url="http://www.networklab.cn")
# print(net_url_tem)
# params = {
#     "username": "aassassasa"
# }
# # hp=http_client()
# res_json = BaseHttpClient.get(url=net_url_tem, params=params, headers=None)
# print(res_json)
# import requests
# import base64
# def saveImage(imgUrl,imgName ="default.jpg" ):
#     r = requests.get(imgUrl, stream=True)
#     image = r.content
#     destDir="/home/xuning/"
#     print("保存图片"+destDir+imgName+"\n")
#     try:
#         with open(destDir+imgName ,"wb") as jpg:
#             jpg.write(image)
#             return
#     except IOError:
#         print("IO Error")
#         return
#     finally:
#         jpg.close()
#
# saveImage("http://www.liaoxuefeng.com/files/attachments/00143253692366570c866ceab874d91b44649c9dc5754ac000/l")
# def test(**kwags):
#     print(kwags.get('aaa'))
# test(aaa={"num":'111'})
#
#  def test_2(s):
#     if s is 2 or s is 3:
#         print("ok")
# test_2(3)
# print(str.upper("sss"))
# count=1000
# # while count>0:
# #     count-=1
# request_client = RequestClient()
# #     res=request_client.send(method="get", url="http://www.networklab.cn/test/parm.php", params={"username":"xx"}).text
# #     print(res)
# net_url_tem = url_template("/file/%s/preview").build_url(options=(501000483683),base_url="https://platform.fangcloud.net/api")
# print(net_url_tem)
# headers = {
#     "Authorization": "Bearer 8d8a2afa-c5da-42cb-84fe-d64cf557016f",
#     "Content-Type": "application/json"
# }
# postbody = {
#     "force_regenerate": False,
#     "kind": "image_64"
# }
# res_json = request_client.send(url=net_url_tem, method="post", headers=headers, postbody=postbody)
# print(res_json.json())
#

# else:
#     raise "request method not error"
# res=request_client.send(method="get", url="http://www.baidu.com")
# print(res)
