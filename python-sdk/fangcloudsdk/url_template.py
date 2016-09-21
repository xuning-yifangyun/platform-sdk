class url_template(object):
    def __init__(self, uri=None):
        self.__uri = uri
        self.__target_url = None
        self.__base_url = None

    def build_url(self, options=None, base_url=None):
        self.__base_url = base_url
        if self.__base_url is None:
            raise "base url can't is null"
        if options is None:
            self.__target_url = self.__base_url + self.__uri
        else:
            self.__url = self.__uri % options
            self.__target_url = self.__base_url + self.__url
        return self.__target_url

    def get_url_with_query(url, query=None):
        if query is None:
            return url
        if type(query) != dict:
            raise "request option must is dict"
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

    @property
    def target_url(self):
        return self.__target_url

    @target_url.setter
    def target_url(self, value=None):
        self.__target_url = value

    @property
    def uri(self):
        return self.__uri

    @uri.setter
    def uri(self, value):
        self.__uri = value
