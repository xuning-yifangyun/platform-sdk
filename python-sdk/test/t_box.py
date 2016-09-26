from boxsdk import OAuth2

oauth = OAuth2(
    client_id='qz5dgd6019sy76vnq2nyv2fnjw014hkf',
    client_secret='4ons2fOBnbmE96O7gOWx9pLMDxOFIvbX',
    access_token="ZnvpDSMpvSeke4RDxed2axLobGmsqHhC",
    refresh_token=""
)
url = "https://app.box.com/api/oauth2/authorize?state=box_csrf_token_JtoZYtDXeeOzqX0n&response_type=code&client_id=qz5dgd6019sy76vnq2nyv2fnjw014hkf&redirect_uri=https%3A%2F%2Fwww.networklab.cn%2Ftest%2Fbox-dev%2Frecv.php"
access_token, refresh_token = oauth.authenticate('vDUbFoOaab2s253ajYMFLfnLmD3UfOgQ')
print(access_token)
print(refresh_token)
