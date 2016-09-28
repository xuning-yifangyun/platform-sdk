from fangcloudsdk.exception import OauthException
from fangcloudsdk.oauth import OAuth
from fangcloudsdk.client import Client

oauth = OAuth(
    client_id="bbe8e63d-89b0-4f31-ba07-5fd602d501d8",
    client_secret="5c179dfe-0f5a-4124-9690-42b69ec3aef7",
    redirect_url="http://121.41.52.18:8080/callback"
)
# 需要获取到请求授权的url，需要交给用户去和授权服务器去交互，如下：
# auth_url=oauth.get_authorization_url()

# 接收授权码, 获取token
try:
    oauth.authenticate(auth_code="lS92LP")
except OauthException as exception:
    # 用户处理异常
    pass

# 实例化client
client = Client(oauth)

# 请求api资源
s = client.user().info()
print(s)
