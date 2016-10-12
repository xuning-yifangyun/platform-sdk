<?php

require_once "Network.class.php";
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
        $this->oauth = $oauth;
    }

    public function send(
        $url,
        $method,
        $postbody = array()
    ) {
        $method = strtoupper($method);
        $headers=$this->oauth->getApiTokenHeader();
        switch ($method) {
            case "GET":
                $response = Network::get($url, $headers);
                break;
            case "POST":
                $response = Network::post($url, $headers, $postbody);
                break;
            case "PUT":
                $response = Network::put($url, $headers, $postbody);
                break;
            case "DELETE":
                $response = Network::delete($url, $headers, $postbody);
                break;
            default:
                $response = null;
        }
        $status = $response->status_code;
        var_dump($url, $method, $headers, $postbody);
        if ($status == 200) {
            return $response;
        } else {
//            if ($status == 401) {
//                if ((time() - ($this->oauth->getApplyTime())) > ($this->oauth->getExpirseIn())) {
//                    $this->oauth->update_token();
//                    $this->send($url, $method, $postbody = array());
//                } else {
//                    throw new Exception("反回错误码：" . $status);
//                }
//            }
            return $response;
        }

    }
}