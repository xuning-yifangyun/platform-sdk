# -*- coding: utf-8 -*-

class BaseException(Exception):
    def __init__(self, error_message):
        Exception.__init__(self, error_message)
        self.error_message = error_message


class UnAuthorizedException(BaseException):
    def __init__(self, error_message="default token is involid or null"):
        BaseException.__init__(self, error_message)
        self.error_message = error_message


class RequestErrorException(BaseException):
    def __init__(self, error_message="default request error"):
        BaseException.__init__(self, error_message)
        self.error_message = error_message


class ResponseErrorException(BaseException):
    def __init__(self, error_message="default request is error"):
        if error_message != "default request is error":
            error_message = error_message['errors'].__getitem__(0)['code']
        BaseException.__init__(self, error_message)
        self.error_message = error_message


class OauthException(BaseException):
    def __init__(self, error_message="default refresh token error"):
        BaseException.__init__(self, error_message)
        self.error_message = error_message


class OauthException(BaseException):
    def __init__(self, error_message="default log error"):
        BaseException.__init__(self, error_message)
        self.error_message = error_message

class LogException(BaseException):
    def __init__(self, error_message="default log error"):
        BaseException.__init__(self, error_message)
        self.error_message = error_message
