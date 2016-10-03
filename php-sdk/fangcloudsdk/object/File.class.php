<?php
require_once "Item.class.php";
require_once "../Route.php";
require_once "../Request.class.php";
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
    private $req;
    /**
     * File constructor.
     */
    public function __construct($file_id = null, $oauth = null) {
        $this->file_id=$file_id;
        $this->oauth=$oauth;
        global $file_route;
        $this->file_route=$file_route;
        $this->req=new Request($this->oauth);
    }

    public function info() {

        $response=$this->req->send("http://www.baidu.com","GET");
        echo $response->body;
    }

    public function update() {

    }

    public function delete() {

    }

    public function preview() {

    }

}

$file=new File("");
$file->info();