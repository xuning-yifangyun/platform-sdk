import json

import requests
from com.fangcloud.sdk.status_code import StatusCode

from fangcloudsdk import LoggerFactory
from fangcloudsdk import ServerInternalException, HttpQueryParameterError, UnAuthorizedException, \
    UrlPathOptionTypeError


class HttpBaseClient(object):
    def __init__(self):
        self.logger = LoggerFactory.get_logger_instance()

    @staticmethod
    def get_url_with_query(url, query=None):
        if query is None:
            return url
        if type(query) != dict:
            raise HttpQueryParameterError
        i = 0
        for key in query.keys():
            value = query[key]
            if type(value) == bool:
                value = "1" if value else "0"
            elif type(value) != str:
                value = str(value)
            if i == 0:
                url += '?'
            else:
                url += '&'
            url += (key + "=" + value)
            i += 1
        return url

    @staticmethod
    def build_url_with_query(url, path_option=None, query=None):
        if path_option is not None:
            if isinstance(path_option, list):
                path_option = tuple(path_option)
            elif isinstance(path_option, tuple):
                pass
            else:
                raise UrlPathOptionTypeError
            url = url % path_option
        if query is None:
            return url

        if type(query) != dict:
            raise HttpQueryParameterError
        i = 0
        for key in query.keys():
            value = query[key]
            if type(value) == bool:
                value = "1" if value else "0"
            elif type(value) != str:
                value = str(value)
            if i == 0:
                url += '?'
            else:
                url += '&'
            url += (key + "=" + value)
            i += 1
        return url

    @staticmethod
    def add_header(headers):
        if headers is None:
            headers = {}
        headers["Content-Type"] = "application/json"
        return headers

    def get(self, url, path_option=None, queries=None, headers=None):
        http_session = requests.Session()
        try:
            url_with_query = self.build_url_with_query(url=url, path_option=path_option, query=queries)
            headers = self.add_header(headers)
            self.logger.debug("headers = %s", headers)
            response = http_session.get(url_with_query, headers=headers, timeout=600)
            self.logger.debug("response = %s", response)
            if response.status_code == StatusCode.Success:
                response_json = json.loads(response.content.decode(encoding="utf-8"))
                if response_json.get('success') is True:
                    return response_json
                else:
                    return {"success": False}
            elif response.status_code == StatusCode.UnAuthorized:
                raise UnAuthorizedException
            else:
                return {"success": False}
        except UnAuthorizedException as exception:
            self.logger.error(exception, exc_info=1)
            raise exception
        except Exception as exception:
            self.logger.error(exception, exc_info=1)
            raise ServerInternalException
        finally:
            http_session.close()

    def post(self, url, path_option=None, queries=None, headers=None, json_body=None):
        http_session = requests.Session()
        try:
            url_with_query = self.build_url_with_query(url=url, path_option=path_option, query=queries)
            headers = self.add_header(headers)
            self.logger.debug("headers = %s", headers)
            response = http_session.post(url_with_query, json=json_body, headers=headers, timeout=600)
            self.logger.debug("response = %s", response.content)
            if response.status_code == StatusCode.Success:
                response_json = json.loads(response.content.decode(encoding="utf-8"))
                if response_json.get('success') is True:
                    return response_json
                else:
                    return {"success": False}
            elif response.status_code == StatusCode.UnAuthorized:
                raise UnAuthorizedException
            else:
                return {"success": False}
        except UnAuthorizedException as exception:
            self.logger.error(exception, exc_info=1)
            raise exception
        except Exception as exception:
            self.logger.error(exception, exc_info=1)
            raise ServerInternalException
        finally:
            http_session.close()