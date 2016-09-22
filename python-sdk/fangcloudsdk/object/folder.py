# -*- coding: utf-8 -*-
try:
    from .item import Item
except:
    from fangcloudsdk.object.item import Item


class Folder(Item):
    def __init__(self):
        pass
