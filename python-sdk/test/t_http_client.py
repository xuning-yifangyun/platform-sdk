import unittest
import pickle
from fangcloudsdk.base_httpclient import BaseHttpClient
from fangcloudsdk.url_template import url_template
from fangcloudsdk.request_client import request_client
from fangcloudsdk.config import config
class T_http_client(unittest.TestCase):
    config1=config()
    def test_http_client(self):
        net_url_tem = url_template("/test/parm.php").build_url(options=None, base_url="http://www.networklab.cn")
        print(net_url_tem)
        params = {
            "username": "徐宁"
        }
        req = BaseHttpClient()
        res_json = req.get(url=net_url_tem, params=params)
        print(res_json)
        from test.sutdent import student
        # stu=student()
        # stu=res_json
        # print(stu.name)
        # self.assertEquals("徐宁", res_json['username'])

    def test_refresh_token(self):
        rt = request_client("aaa")
        net_url_tem = url_template("/file/%s/preview").build_url(options=(501000483683),
                                                                 base_url="https://platform.fangcloud.net/api")
        print(net_url_tem)
        headers = {
            "Authorization": "Bearer ac190592-cfaf-4435-a531-f051438422c3",
            "Content-Type": "application/json"
        }
        postbody = {
            "force_regenerate": False,
            "kind": "image_64"
        }
        req = BaseHttpClient()
        res_json =rt.send(url=net_url_tem, method="post", headers=headers, json=postbody)
        print(res_json)

    def test_request_client(self):
        rt = request_client("aaa")
        net_url_tem = url_template("/test/parm.php").build_url(base_url=self.config1.test_url)
        print(net_url_tem)
        params = {
            "username": "徐宁"
        }
        res = rt.send(url=net_url_tem, method="get", params=params)
        print(res)
