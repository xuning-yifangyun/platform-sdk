<?php
require_once "Item.class.php";
/**
 * Created by PhpStorm.
 * User: xuning
 * Date: 16-10-1
 * Time: 下午11:26
 */
require_once "../route/FolderRoute.php";
class Folder extends Item {

    /**
     * Folder constructor.
     */
    public function __construct() {
        global $folder_route;
        var_dump($folder_route['info']->path(array(111))->get_url());
    }
}
$folder=new Folder();