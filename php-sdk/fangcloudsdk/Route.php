<?php
require_once "UrlTemplate.class.php";

$oauth_route = array(
    "authorize" => new UrlTemplate("/authorize"),
    "token" => new UrlTemplate("/token")
);

$file_route = array(
    "info" => new UrlTemplate("/file/%s/info"),
    "update" => new UrlTemplate("/file/update"),
    "delete" => new UrlTemplate("/file/delete"),
    "delete_from_trash" => new UrlTemplate("/file/delete_from_trash"),
    "restore_from_trash" => new UrlTemplate("/file/restore_from_trash"),
    "move" => new UrlTemplate("/file/move"),
    "upload" => new UrlTemplate("/file/upload"),
    "new_version" => new UrlTemplate("/file/%s/new_version"),
    "download" => new UrlTemplate("/file/%s/download"),
    "preview" => new UrlTemplate("/file/%s/preview"),
    "preview_download" => new UrlTemplate("/file/%s/preview_download"),
    "copy" => new UrlTemplate("/file/copy")
);

$folder_route = array(
    "create" => new UrlTemplate("/folder/create"),
    "update" => new UrlTemplate("/folder/%s/update"),
    "delete" => new UrlTemplate("/folder/delete"),
    "delete_from_trash" => new UrlTemplate("/folder/delete_from_trash"),
    "restore_from_trash" => new  UrlTemplate("/folder/restore_from_trash"),
    "move" => new  UrlTemplate("/folder/move"),
    "children" => new  UrlTemplate("/folder/children")
);

$user_route = array(
    "info" => new UrlTemplate("/user/%s/info"),
    "me_info" => new UrlTemplate("/user/info"),
    "get_profile_pic" => new UrlTemplate("/user/profile_pic_download")
);

$item_route = array(
    "search" => new UrlTemplate("/item/search")
);