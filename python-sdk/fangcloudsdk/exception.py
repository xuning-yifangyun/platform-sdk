# -*- coding: utf-8 -*-

# basic sync exception


class ServerBaseException(Exception):

    def __init__(self, error_message):
        Exception.__init__(self, error_message)
        self.error_message = error_message


class ServerInternalException(ServerBaseException):

    def __init__(self, error_message):
        ServerBaseException.__init__(self, error_message)
        self.error_message = error_message


class ServerExternalException(ServerBaseException):

    def __init__(self, error_message):
        ServerBaseException.__init__(self, error_message)
        self.error_message = error_message


class UnAuthorizedException(ServerBaseException):

    def __init__(self, error_message="oauth token过期"):
        ServerBaseException.__init__(self, error_message)
        self.error_message = error_message


class RefreshTokenExpiredException(ServerBaseException):

    def __init__(self, error_message="refresh token过期"):
        ServerBaseException.__init__(self, error_message)
        self.error_message = error_message


class DatabaseException(ServerInternalException):

    def __init__(self, error_message="数据库操作异常"):
        ServerInternalException.__init__(self, error_message)


class HttpQueryParameterError(ServerExternalException):

    def __init__(self, error_message="Http Query参数异常"):
        ServerBaseException.__init__(self, error_message)


class JsonParserException(ServerExternalException):

    def __init__(self, error_message="数据解析异常"):
        ServerBaseException.__init__(self, error_message)

class UrlPathOptionTypeError(Exception):
    def __init__(self, error_message="url路径参数异常"):
        ServerBaseException.__init__(self, error_message)
