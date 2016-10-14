<?php
require_once "../vendor/autoload.php";
require_once "CustomRequest.php";
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
        //TODO: 这里由于request框架过滤掉了delete方法，只能自定义delete方法
        //return Requests::request($url, $headers, $data, "DELETE", array());
        return CustomRequest::delete($url, $headers, $data);
    }


    public static function put($url, $headers = array(), $data = array()) {
        return Requests::request($url, $headers, $data, "PUT", array());
    }
}
