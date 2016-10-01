<?php

/**
 * Created by PhpStorm.
 * User: xuning
 * Date: 16-10-1
 * Time: 下午4:51
 */
class Client {
    private $oauth=null;
    /**
     * Client constructor.
     */
    public function __construct($oauth) {
        $this->oauth=$oauth;
    }

    /**
     * User 路由
     * @param null $user_id
     */
    public function User($user_id=null){

    }

    /**
     * Item 路由
     */
    public function Item(){

    }

    /**
     * File 路由
     * @param null $file_id
     */
    public function File($file_id=null){

    }

    /**
     * Folder 路由
     * @param null $folder_id
     */
    public function Folder($folder_id=null){

    }

}