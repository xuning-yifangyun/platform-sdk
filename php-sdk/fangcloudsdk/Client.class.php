<?php
require_once "./object/File.class.php";
require_once "./object/Folder.class.php";
require_once "./object/Item.class.php";
require_once "./object/User.class.php";

/**
 * Created by PhpStorm.
 * User: xuning
 * Date: 16-10-1
 * Time: 下午4:51
 */
class Client {
    private $oauth = null;

    public function __construct($oauth) {
        $this->oauth = $oauth;
    }

    public function File($file_id = null) {
        return new File($file_id, $this->oauth);
    }

    public function Folder($folder_id = null) {
        return new Folder($folder_id, $this->oauth);
    }

    public function User($user_id = null) {
        return new User($user_id, $this->oauth);
    }

    public function Item() {
        return new Item($this->oauth);
    }


}