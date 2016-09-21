from fangcloudsdk.base_httpclient import BaseHttpClient as bh
bh=bh()
print(bh.get(url="http://www.networklab.cn/test/parm.php", params={"username":"徐宁"}).json())