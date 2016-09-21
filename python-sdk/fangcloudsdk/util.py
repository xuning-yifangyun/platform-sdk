class request_util:
    @staticmethod
    def build_headers(headers=None):
        if headers is None:
            headers={}
        for key, value in headers.items():
            headers[key]=value
        return headers

    @staticmethod
    def quick_build_url(uri):
        from fangcloudsdk.url_template import url_template
        return url_template(uri).build_url