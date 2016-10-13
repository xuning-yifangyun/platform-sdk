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

    }

    public function delete($file_ids = null) {

    }

    public function delete_from_trash($file_ids = null, $clear_trash = false) {

    }

    public function recovery_from_trash($file_ids = null, $recovery_all = false) {

    }

    public function move($file_ids = null, $target_folder_id = null) {

    }

    public function upload($parent = null, $name = null) {

    }

    public function new_version($name = null, $remark = null) {

    }

    public function download() {

    }

    public function preview($force_regenerate = null, $kind = null) {

    }

    public function preview_download($page_index = null, $kind = null) {

    }

    public function get_preview_frame_url($file_name = null) {

    }

    public function copy($target_folder_id = null, $check_conflict = null) {

    }
}