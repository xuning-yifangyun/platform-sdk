<?php
require_once "Item.class.php";
class User extends Item  {

    /**
     * User constructor.
     */
    public function __construct() {
    }

    public function info(){
        echo 'Hello';
    }
}