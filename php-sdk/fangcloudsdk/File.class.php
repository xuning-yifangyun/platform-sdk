<?php
require_once "Item.class.php";
require_once "Request.class.php";
/**
 * Created by PhpStorm.
 * User: xuning
 * Date: 16-10-1
 * Time: 下午11:26
 */
class File extends Item {

    private $file_id;
    private $oauth;
    private $file_route;
    private $request_session;
    /**
     * File constructor.
     */
    public function __construct($file_id = null, $oauth = null) {
        global $file_route;
        $this->file_id=$file_id;
        $this->oauth=$oauth;
        $this->file_route=$file_route;
        $this->request_session=new Request($this->oauth);
    }

    public function info() {
        $response=$this->request_session->send($url="http://www.baidu.com",$method="get");
        echo $response->body;
    }

    public function update() {

    }

    public function delete() {

    }

    public function preview() {

    }

}

$file=new File("", "");
$file->info();