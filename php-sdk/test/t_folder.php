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
class t_folder extends TestCase {
    public $oauth;
    public $client;
    public $test_access_token = "e35d4382-4d89-4f64-b34f-707fa18248c1";
    public $test_refresh_token = "bceecd8b-ba45-4aca-8c4e-a80ed253f9f2";
    private $test_folder_id = 501000031450;
    private $test_target_folder_id = 501000005400;

    public function __construct() {
        $this->oauth = test_global_var::get_test_oauth();
        $this->oauth->setAccessToken($this->test_access_token);
        $this->oauth->setRefreshToken($this->test_refresh_token);
        $this->client = new Client($this->oauth);
    }

    public function test_info() {
        $res = $this->client->Folder($this->test_folder_id)->info();
        TestCase::assertEquals(true, $res['success']);
    }

    public function test_create() {
        $res = $this->client->Folder()->create("aaa", 0);
        TestCase::assertEquals(true, $res['success']);
    }

    public function test_update() {
        $res = $this->client->Folder($this->test_folder_id)->update("testapi");
        TestCase::assertEquals(true, $res['success']);
    }


    public function test_delete() {
        $res = $this->client->Folder()->delete(array($this->test_folder_id));
        TestCase::assertEquals(true, $res['success']);
    }

    public function test_delete_from_trash() {
        $res = $this->client->Folder()->delete_from_trash(array($this->test_folder_id));
        TestCase::assertEquals(true, $res['success']);
    }

    public function test_recovery_folder_from_trash() {
        $res = $this->client->Folder()->recovery_from_trash(array($this->test_folder_id));
        TestCase::assertEquals(true, $res['success']);
    }
    //TODO: 文档描述错误，不应该是target_folder
    public function test_move() {
        $res = $this->client->Folder()->move(array($this->test_folder_id), $this->test_target_folder_id);
        TestCase::assertEquals(true, $res['success']);
    }

    public function test_children(){
        $res = $this->client->Folder()->get_children($this->test_folder_id, 0, 10, "file");
        TestCase::assertEquals(true, $res['success']);
    }
}