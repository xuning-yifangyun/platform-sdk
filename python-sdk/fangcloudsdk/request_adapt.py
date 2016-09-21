class Singleton(object):
    def __new__(cls, *args, **kw):
        if not hasattr(cls, '_instance'):
            orig = super(Singleton, cls)
            cls._instance = orig.__new__(cls, *args, **kw)
        return cls._instance


from platform import system
class request_adapt(object):
    def __init__(self):
        self.__system_type = None

    def os_is_mac(self):

        self.__system_type = system()
        if (self.__system_type is "Mac"):
            return True
        else:
            return False

    @property
    def system_type(self):
        self.__system_type=system()
        return self.__system_type