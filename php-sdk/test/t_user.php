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
class t_user extends TestCase {
    public $oauth;
    public $client;
    public $test_user_id = 22149;
    public $test_access_token = "e35d4382-4d89-4f64-b34f-707fa18248c1";
    public $test_refresh_token = "bceecd8b-ba45-4aca-8c4e-a80ed253f9f2";

    public function __construct() {
        $this->oauth = test_global_var::get_test_oauth();
        $this->oauth->setAccessToken($this->test_access_token);
        $this->oauth->setRefreshToken($this->test_refresh_token);
        $this->client = new Client($this->oauth);
    }

    /**
     * 获取用户信息
     */
    public function test_get_user_info() {
        $res = $this->client->User($this->test_user_id)->info();
        TestCase::assertEquals(true, $res['success']);
    }

    /**
     * 获取用户头像
     */
    public function test_get_user_profile_pic() {
        $res = $this->client->User($this->test_user_id)->get_profile_pic("b3c69fcb4a2f95fceee21f16ced8a07c");
        $test_file = fopen("dog.png", "wr");
        fwrite($test_file, $res);
        fclose($test_file);
    }
}