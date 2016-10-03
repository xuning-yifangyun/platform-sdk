<?php
require_once "Config.class.php";

/**
 * Created by PhpStorm.
 * User: xuning
 * Date: 16-10-1
 * Time: 下午9:27
 */
class UrlTemplate {
    private $target_url;

    public function __construct($uri = null) {
        $base_url = Config::getBaseApiUrl();
        $this->target_url = $base_url . $uri;
    }

    public function path($path_option = null) {
        if ($path_option == null) {
            return $this->target_url;
        }
        $this->target_url = $this->sprintf_array($this->target_url, $path_option);
        return $this;
    }

    public function query($query_option = null) {
        if (count($query_option) <= 0) {
            return $this->target_url;
        } else {
            $this->target_url .= "?";
            $flag = 0;
            foreach ($query_option as $key => $value) {
                if ($flag == 0) {
                    $this->target_url .= ($key . "=" . $value);
                } else {
                    $this->target_url .= ("&" . $key . "=" . $value);
                }
                $flag++;
            }
        }
        return $this;
    }

    private function sprintf_array($format, $arr) {
        return call_user_func_array('sprintf', array_merge((array)$format, $arr));
    }

    public function get_url() {
        return $this->target_url;
    }
}