<?php

/**
 * Created by PhpStorm.
 * User: xuning
 * Date: 16-10-1
 * Time: 下午9:28
 */
class Config {
    private static $base_api_url = "https://oauth-server.fangcloud.net/oauth";
    private static $base_oauth_url = "https://platform.fangcloud.net/api";
    private $log_level = "INFO";
    private $log_out_path = "/home/xuning/log/fangcloud/sdk.log";

    /**
     * @return string
     */
    public function getLogLevel() {
        return $this->log_level;
    }

    /**
     * @param string $log_level
     */
    public function setLogLevel($log_level) {
        $this->log_level = $log_level;
    }

    /**
     * @return string
     */
    public function getLogOutPath() {
        return $this->log_out_path;
    }

    /**
     * @param string $log_out_path
     */
    public function setLogOutPath($log_out_path) {
        $this->log_out_path = $log_out_path;
    }

    /**
     * @return string
     */
    public static function getBaseApiUrl() {
        return self::$base_api_url;
    }

    /**
     * @return string
     */
    public static function getBaseOauthUrl() {
        return self::$base_oauth_url;
    }

}