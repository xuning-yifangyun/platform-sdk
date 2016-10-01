<?php
require_once "../vendor/autoload.php";

/**
 * Created by PhpStorm.
 * User: xuning
 * Date: 16-10-1
 * Time: 下午5:20
 */
class Network {
    public static function get($url, $headers = array(), $options = array()) {
        return self::request($url, $headers, null, self::GET, $options);
    }

    public static function delete($url, $headers = array(), $options = array()) {
        return self::request($url, $headers, null, self::DELETE, $options);
    }

    public static function post($url, $headers = array(), $data = array(), $options = array()) {
        return self::request($url, $headers, $data, self::POST, $options);
    }

    public static function put($url, $headers = array(), $data = array(), $options = array()) {
        return self::request($url, $headers, $data, self::PUT, $options);
    }
}