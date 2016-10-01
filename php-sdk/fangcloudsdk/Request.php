<?php
require_once "./Network.php";
/**
 * Created by PhpStorm.
 * User: xuning
 * Date: 16-10-1
 * Time: 下午5:16
 */
class Request {

    private $oauth;
    /**
     * Request constructor.
     */
    public function __construct($oauth) {
        $this->oauth=$oauth;
    }

    public function send($url, $method, $headers=null, $querys=null, $postbody=null){
        Requests::request($url=$url );
    }
}