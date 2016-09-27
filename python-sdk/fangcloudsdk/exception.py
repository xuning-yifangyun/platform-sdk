# coding: utf-8

class BaseException(Exception):
    def __init__(self, error_message):
        Exception.__init__(self, error_message)
        self.error_message = error_message


class UnAuthorizedException(BaseException):
    def __init__(self, error_message="token is involid or null"):
        BaseException.__init__(self, error_message)
        self.error_message = error_message
