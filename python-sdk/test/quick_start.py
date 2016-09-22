from fangcloudsdk.oauth import OAuth
from fangcloudsdk.client import Client
oauth=OAuth(
    client_id="bbe8e63d-89b0-4f31-ba07-5fd602d501d8",
    client_secret="5c179dfe-0f5a-4124-9690-42b69ec3aef7",
    redirect_url="http://121.41.52.18:8080/callback"
    # access_token="05a8a932-e16d-4e78-8423-b0c4923f43df",
    # refresh_token="bceecd8b-ba45-4aca-8c4e-a80ed253f9f2"
)
client=Client(oauth)

#
# res=oauth.update_token()
# print(res)

# res=oauth.authenticate(auth_code="khG7cx")
# print(res)

# res=client.user(22149).info()