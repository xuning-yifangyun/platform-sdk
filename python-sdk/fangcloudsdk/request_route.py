# -*- coding: utf-8 -*-
try:
    from .urltemplate import UrlTemplate as url_tp
except Exception:
    from fangcloudsdk.urltemplate import UrlTemplate as url_tp

class RequestRoute(object):
    pass


class UserRoute(object):
    info = url_tp("/user/%s/info")
    me_info = url_tp("/user/info")
    get_profile_pic = url_tp("/user/profile_pic_download")


class FileRoute(object):
    info = url_tp("/file/%s/info")
    update = url_tp("/file/%s/update")
    delete = url_tp("/file/delete")
    delete_from_trash = url_tp("/file/delete_from_trash")
    restore_from_trash = url_tp("/file/restore_from_trash")
    move = url_tp("/file/move")
    upload = url_tp("/file/upload")
    new_version = url_tp("/file/%s/new_version")
    download = url_tp("/file/%s/download")
    preview = url_tp("/file/%s/preview")
    preview_download = url_tp("/file/%s/preview_download")
    copy = url_tp("/file/copy")


class FolderRoute(object):
    info = url_tp("/folder/%s/info")
    create = url_tp("/folder/create")
    update = url_tp("/folder/%s/update")
    delete = url_tp("/folder/delete")
    delete_from_trash = url_tp("/folder/delete_from_trash")
    restore_from_trash = url_tp("/folder/restore_from_trash")
    move = url_tp("/folder/move")
    children = url_tp("/folder/children")


class ItemRoute(object):
    search = url_tp("/item/search")