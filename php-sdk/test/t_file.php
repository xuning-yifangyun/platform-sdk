<?php
use PHPUnit\Framework\TestCase;
require_once "test_global_var.php";
require_once "../fangcloudsdk/Client.class.php";
/**
 * Created by PhpStorm.
 * User: xuning
 * Date: 16-10-12
 * Time: 下午12:58
 */
class t_file extends TestCase {

    public $oauth;
    public $client;


    public function __construct() {
        $this->oauth = test_global_var::get_test_oauth();
        $this->client=new Client($this->oauth);
    }

    /**
     * 获取文件信息
     */
    public function test_info(){
        $res=$this->client->File(501000524950)->info();
        TestCase::assertEquals(true, $res['success']);
    }
}