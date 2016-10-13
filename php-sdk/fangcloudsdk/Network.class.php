<?php
require_once "../vendor/autoload.php";

/**
 * Created by PhpStorm.
 * User: xuning
 * Date: 16-10-1
 * Time: 下午5:20
 */
class Network {

    public static function get($url, $headers = array()) {
        return Requests::request($url, $headers, null, "GET", array());
    }

    public static function post($url, $headers = array(), $data = array()) {
        return Requests::request($url, $headers, $data, "POST", array());
    }

    public static function delete($url, $headers = array(), $data = array()) {
        return Requests::request($url, $headers, $data, "DELETE", array());
    }

    public static function put($url, $headers = array(), $data = array()) {
        return Requests::request($url, $headers, $data, "PUT", array());
    }
}
