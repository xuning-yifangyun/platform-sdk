<?php
require_once "Item.class.php";

class User extends Item {
    private $user_id;
    private $user_route;

    /**
     * User constructor.
     */
    public function __construct($user_id = null, $oauth = null) {
        global $user_route;
        $this->user_id = $user_id;
        $this->user_route = $user_route;
        $this->request_session = new Request($oauth);
    }

    public function info() {
        if ($this->user_id == null) {
            $url = $this->user_route['me_info']->get_url();
        } else {
            $url = $this->user_route['info']->path(array($this->user_id))->get_url();
        }
        $response = $this->request_session->send($url, "GET");
        return $response;
    }

    public function get_profile_pic($profile_pic_key = null) {
        $url = $this->user_route['get_profile_pic']->query(
            array(
                "user_id" => $this->user_id,
                "profile_pic_key" => $profile_pic_key
            )
        )->get_url();
        $response = $this->request_session->send($url, "GET");
        return $response;
    }
}