import unittest
from fangcloudsdk.request_client import RequestClient
class testOauth(unittest.TestCase):
    def test_refresh_token(self):
        request_client=RequestClient()
        params = {
            "grant_type": "refresh_token",
            "refresh_token": "bceecd8b-ba45-4aca-8c4e-a80ed253f9f2"
        }
        headers = {
            "Authorization": "Basic YmJlOGU2M2QtODliMC00ZjMxLWJhMDctNWZkNjAyZDUwMWQ4OjVjMTc5ZGZlLTBmNWEtNDEyNC05NjkwLTQyYjY5ZWMzYWVmNw=="
        }
        res = request_client.send(url="https://oauth-server.fangcloud.net/oauth/token", headers=headers, params=params,
                                  method="post")
        print(res.json())

