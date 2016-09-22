# -*- coding: utf-8 -*-
try:
    from .base_object import BaseObject
except:
    from fangcloudsdk.object.base_object import BaseObject


class Item(BaseObject):
    def __init__(self):
        BaseObject.__init__(self)
        pass