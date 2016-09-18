from package.com.fangcloud import HttpBaseClient

# headers={
#     "Authorization" : "Bearer 033104df-4eb4-4412-a53c-abe484e2ae1f"
# }
# query_option={
#     "username" : "xuning"
# }
# url="https://platform.fangcloud.net/api/file/501000483684/info"
#

# # print(query_option)
# url=HttpBaseClient.get_url_with_query("http://www.networklab.cn/test/parm.php",query_option)
# url="http://www.networklab.cn/test/parm.php";
httpBaseClient = HttpBaseClient()
#
# res=httpBaseClient.get(url=url, queries=query_option, headers=None)
# # print(url)
# print(res)
# cc=222
# aaa=httpBaseClient.build_url("http://aaa//bbb",query={'x':'111'})
# print(aaa)

# test post
url = "https://platform.fangcloud.net/api/file/%s/new_version"
path_option = [
    501000483684
]
headers = {
    "Authorization": "Bearer 4425bc01-e4ab-462b-9d98-f678ef062bed"
}
json_body = {
    "name": "abc.jpg",
    "upload_type": "api",
    "remark": "ImageUpdateRename"
}
res = httpBaseClient.post(url=url, path_option=path_option, headers=headers, json_body=json_body)
print(res)
