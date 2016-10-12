# -*- coding: utf-8 -*-
try:
    from fangcloudsdk.item import Item
    from fangcloudsdk.status_code import StatusCode
    from fangcloudsdk.request_route import UserRoute
except Exception:
    from fangcloudsdk.item import Item
    from fangcloudsdk.status_code import StatusCode
    from fangcloudsdk.request_route import UserRoute


class User(Item):
    def __init__(self, user_id=None, oauth=None):
        Item.__init__(self)
        self._user_id = user_id
        self._oauth = oauth
        self.headers = self.add_oauth_header

    def info(self):
        """
        获取用户信息
        :return:
        """
        if self._user_id is not None:
            url = UserRoute.info.build_url(self._user_id)
        else:
            url = UserRoute.me_info.build_url(base_url=self._config.api_base_url)
        headers = self.headers(self.oauth)
        response = self._request.send(url=url, method="get", headers=headers)
        if response.status_code == StatusCode.Success:
            return response.json()
        else:
            self.deal_response(response, self.oauth)
            return self.info()

    def get_profile_pic(self, profile_pic_key=None):
        """
        获取用户头像
        :param profile_pic_key:
        :return:
        """
        url = UserRoute.get_profile_pic.build_url()
        params = {"user_id": self._user_id, "profile_pic_key": profile_pic_key}
        headers = self.headers(self.oauth)
        response = self._request.send(url=url, method="get", headers=headers, params=params)
        if response.status_code == StatusCode.Success:
            return response
        else:
            self.deal_response(response, self.oauth)
            return self.get_profile_pic(profile_pic_key)

    @property
    def oauth(self):
        return self._oauth
