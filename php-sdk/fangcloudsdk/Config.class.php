<?php
use Monolog\Logger;
/**
 * Created by PhpStorm.
 * User: xuning
 * Date: 16-10-1
 * Time: 下午9:28
 */
class Config {
    private static $base_api_url = "https://platform.fangcloud.net/api";
    private static $base_oauth_url = "https://oauth-server.fangcloud.net/oauth";
    private static $log_level = Logger::INFO;
    private static $log_out_path = "sdk.log";
    private static $log_display_console=true;
    private static $config=null;
    /**
     * Config constructor.
     */
    private function __construct() {
    }

    public static function get_config(){
        if(self::$config==null){
            return new Config();
        }else{
            return self::$config;
        }
    }
    /**
     * @return string
     */
    public static function getLogLevel() {
        return self::$log_level;
    }

    /**
     * @return boolean
     */
    public static function isLogDisplayConsole() {
        return self::$log_display_console;
    }

    /**
     * @param boolean $log_display_console
     */
    public static function setLogDisplayConsole($log_display_console) {
        self::$log_display_console = $log_display_console;
    }

    /**
     * @param string $log_level
     */
    public static function setLogLevel($log_level) {
        self::$log_level = $log_level;
    }

    /**
     * @return string
     */
    public static function getLogOutPath() {
        return self::$log_out_path;
    }

    /**
     * @param string $log_out_path
     */
    public static function setLogOutPath($log_out_path) {
        self::$log_out_path = $log_out_path;
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