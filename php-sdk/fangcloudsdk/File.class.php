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

    public function update($new_name = null, $new_descript = null) {
        $url = $this->file_route['update']->path(array($this->file_id))->get_url();
        $postbody = array(
            "name" => $new_name,
            "description" => $new_descript
        );
        $response = $this->request_session->send($url, "put", $postbody);
        return $response;
    }

    public function delete($file_ids = null) {
        $url = $this->file_route['delete']->get_url();
        $postbody = array(
            "file_ids" => $file_ids
        );
        $response = $this->request_session->send($url, "delete", $postbody);
        return $response;
    }

    public function delete_from_trash($file_ids = null, $clear_trash = false) {
        $url = $this->file_route['delete_from_trash']->get_url();
        $postbody = array(
            "file_ids" => $file_ids,
            "clear_trash" => $clear_trash
        );
        $response = $this->request_session->send($url, "delete", $postbody);
        return $response;
    }

    public function recovery_from_trash($file_ids = null, $recovery_all = false) {
        $url = $this->file_route['restore_from_trash']->get_url();
        $postbody = array(
            "file_ids" => $file_ids,
            "restore_all" => $recovery_all
        );
        $response = $this->request_session->send($url, "post", $postbody);
        return $response;
    }

    public function move($file_ids = null, $target_folder_id = null) {
        $url = $this->file_route['move']->get_url();
        $postbody = array(
            "file_ids" => $file_ids,
            "target_folder_id" => $target_folder_id
        );
        $response = $this->request_session->send($url, "post", $postbody);
        return $response;
    }

    public function upload($parent = null, $name = null) {
        $url = $this->file_route['upload']->get_url();
        $postbody = array(
            "parent_id" => $parent,
            "name" => $name,
            "upload_type" => "api"
        );
        $response = $this->request_session->send($url, "post", $postbody);
        return $response;
    }

    public function new_version($name = null, $remark = null) {
        $url = $this->file_route['new_version']->path(array($this->file_id))->get_url();
        $postbody = array(
            "name" => $name,
            "upload_type" => "api",
            "remark" => $remark
        );
        $response = $this->request_session->send($url, "post", $postbody);
        return $response;
    }

    public function download() {
        $url = $this->file_route['download']->path(array($this->file_id))->get_url();
        $response = $this->request_session->send($url, "get");
        return $response;
    }

    public function preview($force_regenerate = false, $kind = null) {
        $url = $this->file_route['preview']->path(array($this->file_id))->get_url();
        $postbody = array(
            "force_regenerate" => $force_regenerate,
            "kind" => $kind
        );
        $response = $this->request_session->send($url, "post", $postbody);
        return $response;
    }

    public function preview_download($page_index = null, $kind = null) {
        $url = $this->file_route['preview_download']->path(array($this->file_id))->get_url();
        $postbody = array(
            "page_index" => $page_index,
            "kind" => $kind
        );
        $response = $this->request_session->send($url, "post", $postbody);
        return $response;
    }


    public function copy($target_folder_id = null, $check_conflict = false) {
        $url = $this->file_route['copy']->get_url();
        $postbody = array(
            "file_id" => $this->file_id,
            "target_folder_id" => $target_folder_id,
            "is_check_conflict" => $check_conflict
        );
        $response = $this->request_session->send($url, "post", $postbody);
        return $response;
    }

}