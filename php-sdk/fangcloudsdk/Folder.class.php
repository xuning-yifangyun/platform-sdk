<?php
require_once "Item.class.php";
require_once "Route.php";

/**
 * Created by PhpStorm.
 * User: xuning
 * Date: 16-10-1
 * Time: 下午11:26
 */
class Folder extends Item {

    /**
     * Folder constructor.
     */
    public function __construct() {
        global $folder_route;

    }
}

$folder = new Folder();