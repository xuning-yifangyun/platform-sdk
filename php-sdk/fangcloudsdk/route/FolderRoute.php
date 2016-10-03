<?php
require_once "UrlTemplate.class.php";
/**
 * Created by PhpStorm.
 * User: xuning
 * Date: 16-10-2
 * Time: 下午2:54
 */
$folder_route=array(
    "info" => new  UrlTemplate("/folder/%s/info")

);
$create = new UrlTemplate("/folder/create");
$update = new UrlTemplate("/folder/%s/update");
$delete = new UrlTemplate("/folder/delete");
$delete_from_trash = new UrlTemplate("/folder/delete_from_trash");
$restore_from_trash = new  UrlTemplate("/folder/restore_from_trash");
$move = new  UrlTemplate("/folder/move");
$children = new  UrlTemplate("/folder/children");