<?php
require_once "Item.class.php";

class File extends Item {

    private $file_id;

    protected $file_route;

    /**
     * File constructor.
     */
    public function __construct($file_id, $oauth) {
        global $file_route;
        $this->file_id = $file_id;
        $this->file_route = $file_route;
        $this->request_session = new Request($oauth);
    }

    public function info() {
        $url = $this->file_route['info']->path(array($this->file_id))->get_url();
        $response = $this->request_session->send($url = $url, $method = "GET");
        return $response;
    }

    public function update() {

    }

    public function delete() {

    }

    public function preview() {

    }

}