# -*- coding: utf-8 -*-
try:
    from .urltemplate import UrlTemplate
except Exception:
    from fangcloudsdk.urltemplate import UrlTemplate as UrlTemplate

class RequestRoute(object):
    pass


class UserRoute(object):
    info = UrlTemplate("/user/%s/info")
    me_info = UrlTemplate("/user/info")
    get_profile_pic = UrlTemplate("/user/profile_pic_download")


class FileRoute(object):
    info = UrlTemplate("/file/%s/info")
    update = UrlTemplate("/file/%s/update")
    delete = UrlTemplate("/file/delete")
    delete_from_trash = UrlTemplate("/file/delete_from_trash")
    restore_from_trash = UrlTemplate("/file/restore_from_trash")
    move = UrlTemplate("/file/move")
    upload = UrlTemplate("/file/upload")
    new_version = UrlTemplate("/file/%s/new_version")
    download = UrlTemplate("/file/%s/download")
    preview = UrlTemplate("/file/%s/preview")
    preview_download = UrlTemplate("/file/%s/preview_download")
    copy = UrlTemplate("/file/copy")


class FolderRoute(object):
    info = UrlTemplate("/folder/%s/info")
    create = UrlTemplate("/folder/create")
    update = UrlTemplate("/folder/%s/update")
    delete = UrlTemplate("/folder/delete")
    delete_from_trash = UrlTemplate("/folder/delete_from_trash")
    restore_from_trash = UrlTemplate("/folder/restore_from_trash")
    move = UrlTemplate("/folder/move")
    children = UrlTemplate("/folder/children")


class ItemRoute(object):
    search = UrlTemplate("/item/search")