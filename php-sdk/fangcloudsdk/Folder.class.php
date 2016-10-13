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
    private $folder_id;
    private $folder_route;

    /**
     * Folder constructor.
     */
    public function __construct($folder_id, $oauth) {
        global $folder_route;
        $this->folder_id = $folder_id;
        $this->folder_route = $folder_route;
        $this->request_session = new Request($oauth);

    }

    public function info() {
        $url = $this->folder_route['info']->path(
            array(
                $this->folder_id
            )
        )->get_url();
        $response = $this->request_session->send($url, "GET");
        return $response;
    }

    public function create($name = null, $parent_id = null) {
        $url = $this->folder_route['create']->get_url();
        $postbody = array(
            "name" => $name,
            "parent_id" => $parent_id
        );
        $response = $this->request_session->send($url, "post", $postbody);
        return $response;
    }

    public function update($new_name = null) {
        $url = $this->folder_route['update']->path(array($this->folder_id))->get_url();
        $postbody = array(
            "name" => $new_name
        );
        $response = $this->request_session->send($url, "PUT", $postbody);
        return $response;
    }

    public function delete($folder_ids = null) {
        $url = $this->folder_route['delete']->get_url();
        $postbody = array(
            "folder_ids" => $folder_ids
        );
        $response = $this->request_session->send($url, "delete", $postbody);
        return $response;
    }

    public function delete_from_trash($folder_ids = null, $clear_trash = false) {
        $url = $this->folder_route['delete_from_trash']->get_url();
        $postbody = array(
            "clear_trash" => $clear_trash,
            "folder_ids" => $folder_ids
        );
        $response = $this->request_session->send($url, "delete", $postbody);
        return $response;
    }

    public function recovery_from_trash($folder_ids = null, $recovery_all = false) {
        $url = $this->folder_route['restore_from_trash']->get_url();
        $postbody = array(
            "clear_trash" => $recovery_all,
            "folder_ids" => $folder_ids
        );
        $response = $this->request_session->send($url, "post", $postbody);
        return $response;
    }

    public function move($folder_ids = null, $target_folder_id = null) {
        $url = $this->folder_route['move']->get_url();
        $postbody = array(
            "folder_ids" => $folder_ids,
            "target_folder_id" => $target_folder_id
        );
        $response = $this->request_session->send($url, "post", $postbody);
        return $response;
    }

    public function get_children($folder_id = null, $page_id = null, $page_capacity = null, $type = null) {
        $url = $this->folder_route['children']->query(
            array(
                "folder_id" => $folder_id,
                "page_id" => $page_id,
                "page_capacity" => $page_capacity,
                "type" => $type
            )
        )->get_url();
        $response = $this->request_session->send($url, "get");
        return $response;
    }

}