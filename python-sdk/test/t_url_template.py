from fangcloudsdk.urltemplate import UrlTemplate as url_t


# baidu_url=url_t("/num1/%s/num2/%s")
#
# str=baidu_url.build_url((111, 222), base_url="http://www.baidu.com")
# print(str)
# baidu_url.target_url="dddd"
# print(baidu_url.target_url)
# def f(baseurl):
#     # str = get_file = url_t("/num1/%s").build_url((var), "http://www.baidu.com")
#     return url_t(baseurl).build_url
#
#
# print(f("/num1/%s/num2/%s")((333, 555), "http://www.baidu.com"))
# print(f("/num1/%s/num2/%s")((333, 555), "http://www.baidu.com"))

# from fangcloudsdk.util import request_util as ru
# s=ru.quick_build_url("/num1/num2/%s")((23),base_url="http://www.baidu.com")
# print(s)