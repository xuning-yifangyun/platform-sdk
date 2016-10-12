<?php
use PHPUnit\Framework\TestCase;
require_once "test_global_var.php";
require_once "../fangcloudsdk/Client.class.php";
/**
 * Created by PhpStorm.
 * User: xuning
 * Date: 16-10-12
 * Time: 下午2:49
 */
class t_user extends TestCase{
    public $oauth;
    public $client;
    public $test_access_token="e35d4382-4d89-4f64-b34f-707fa18248c1";
    public $test_refresh_token = "bceecd8b-ba45-4aca-8c4e-a80ed253f9f2";

    public function __construct() {
        $this->oauth = test_global_var::get_test_oauth();
        $this->oauth->setAccessToken($this->test_access_token);
        $this->oauth->setRefreshToken($this->test_refresh_token);
        $this->client=new Client($this->oauth);
    }

    /**
     * 获取用户信息
     */
    public function test_get_user_info(){

    }
}