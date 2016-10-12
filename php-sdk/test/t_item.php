<?php
use PHPUnit\Framework\TestCase;

require_once "test_global_var.php";
require_once "../fangcloudsdk/Client.class.php";

/**
 * Created by PhpStorm.
 * User: xuning
 * Date: 16-10-12
 * Time: 下午2:48
 */
class t_item extends TestCase {
    public $oauth;
    public $client;

    public function __construct() {
        $this->oauth = test_global_var::get_test_oauth();
        $this->client = new Client($this->oauth);
    }

    public function test_search() {
        $res = $this->client->Item()->search("test");
        TestCase::assertEquals(true, $res['success']);
    }
}