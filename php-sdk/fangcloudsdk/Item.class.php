<?php
require_once "Base.class.php";

/**
 * Created by PhpStorm.
 * User: xuning
 * Date: 16-10-1
 * Time: 下午11:26
 */
class Item extends BaseObject {

    private $item_route;

    /**
     * Item constructor.
     */
    public function __construct($oauth = null) {
        global $item_route;
        $this->item_route = $item_route;
        $this->request_session = new Request($oauth);
    }

    public function search($query_words = null, $type = "all", $page_number = 0, $search_in_folder = null) {
        $url = $this->item_route['search']->query(
            array(
                "query_words" => $query_words,
                "type" => $type,
                "page_number" => $page_number,
                "search_in_folder" => $search_in_folder
            )
        )->get_url();
        $response = $this->request_session->send($url, "GET");
        return $response;
    }
}