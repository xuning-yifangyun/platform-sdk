<?php
require_once "UrlTemplate.class.php";
/**
 * Created by PhpStorm.
 * User: xuning
 * Date: 16-10-2
 * Time: 下午1:54
 */
$info = new UrlTemplate("/file/%s/info");
$update = new UrlTemplate("/file/update");
$delete = new UrlTemplate("/file/delete");
$delete_from_trash = new UrlTemplate("/file/delete_from_trash");
$restore_from_trash = new UrlTemplate("/file/restore_from_trash");
$move = new UrlTemplate("/file/move");
$upload = new UrlTemplate("/file/upload");
$new_version = new UrlTemplate("/file/%s/new_version");
$download = new UrlTemplate("/file/%s/download");
$preview = new UrlTemplate("/file/%s/preview");
$preview_download = new UrlTemplate("/file/%s/preview_download");
$copy = new UrlTemplate("/file/copy");