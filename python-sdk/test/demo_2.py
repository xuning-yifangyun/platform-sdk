from boxsdk import OAuth2

oauth = OAuth2(
    client_id='qz5dgd6019sy76vnq2nyv2fnjw014hkf',
    client_secret='4ons2fOBnbmE96O7gOWx9pLMDxOFIvbX',
    store_tokens=""
)


# auth_url, csrf_token = oauth.get_authorization_url('https://www.networklab.cn/test/box-dev/recv.php')
# print(auth_url)
# print(csrf_token)

#
access_token, refresh_token = oauth.authenticate('x6e23VXSw2RfTOngMFX5F6gmfriAPtTO')
print(access_token)
print(refresh_token)