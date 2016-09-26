class Singleton(object):
    def __new__(cls, *args, **kwargs):
        if not hasattr(cls, '_instance'):
            orig = super(Singleton, cls)
            cls._instance = orig.__new__(cls, *args, **kwargs)
            return cls._instance
    def f(self):
        print("aaaa")
    @property
    def get_ins(self):
        return self


sin1=Singleton().get_ins
sin2=Singleton().get_ins
print(sin1)
print(sin2)
