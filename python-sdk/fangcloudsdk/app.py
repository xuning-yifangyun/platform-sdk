class app(object):

    @classmethod
    def build(self,
                 client_id,
                 client_secret,
                 redirect_url):
        self.client_id=client_id
        self.client_secret=client_secret
        self.redirect_url=redirect_url
        return self
    @property
    def app_info(self):
        return self