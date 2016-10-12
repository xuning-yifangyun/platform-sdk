<?php
use PHPUnit\Framework\TestCase;

require_once "test_global_var.php";

/**
 * Created by PhpStorm.
 * User: xuning
 * Date: 16-10-12
 * Time: 上午9:43
 */
class t_oauth extends TestCase {
    public $oauth;
    public $test_refresh_token = "bceecd8b-ba45-4aca-8c4e-a80ed253f9f2";

    public function __construct() {
        $this->oauth = test_global_var::get_test_oauth();
        $this->oauth->setRefreshToken($this->test_refresh_token);
    }

    /**
     *获取授权请求url地址
     */
    public function test_get_auth_url() {
        echo $this->oauth->get_authorization_url();
    }

    /**
     * 根据授权码获取token，返回一个对象
     * 需要进行手动测试
     */
    public function test_get_token_by_authcode() {
        $auth_code = "8BdLRy";
        $token = $this->oauth->authenticate($auth_code);
        var_dump($token);
    }

    /**
     * 刷新token
     * 生产环境需要对用户不可见，为void即可
     */
    public function test_refresh_token() {
        var_dump($this->oauth->refresh());
    }

    /**
     * 撤销Token
     */
    public function test_revoke() {
        $this->oauth->revoke();
    }

}