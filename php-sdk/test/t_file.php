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
    public $test_file_id = 501000524950;
    public $test_target_folder_id = 501000005400;

    public function __construct() {
        $this->oauth = test_global_var::get_test_oauth();
        $this->client = new Client($this->oauth);
    }

    public function test_info() {
        $res = $this->client->File($this->test_file_id)->info();
        TestCase::assertEquals(true, $res['success']);
    }

    public function test_update() {
        $res = $this->client->File($this->test_file_id)->update("dog.png", "xuning test update");
        TestCase::assertEquals(true, $res['success']);
    }

    public function test_delete() {
        $res = $this->client->File()->delete(array($this->test_file_id));
        TestCase::assertEquals(true, $res['success']);
    }

    public function test_delete_from_trash() {
        $res = $this->client->File()->delete_from_trash(array($this->test_file_id));
        TestCase::assertEquals(true, $res['success']);
    }

    public function test_recovery_from_trash() {
        $res = $this->client->File()->recovery_from_trash(array($this->test_file_id));
        TestCase::assertEquals(true, $res['success']);
    }

    public function test_move() {
        $res = $this->client->File()->move(array($this->test_file_id), $this->test_target_folder_id);
        TestCase::assertEquals(true, $res['success']);
    }

    public function test_new_version() {
        $res = $this->client->File($this->test_file_id)->new_version("dog,png", "test_new_version");
        TestCase::assertEquals(true, $res['success']);
    }

    public function test_upload() {
        $res = $this->client->File()->upload($this->test_target_folder_id, "dog.png");
        TestCase::assertEquals(true, $res['success']);
    }

    public function test_download() {
        $res = $this->client->File($this->test_file_id)->download();
        TestCase::assertEquals(true, $res['success']);
    }

    public function test_preview() {
        $res = $this->client->File($this->test_file_id)->preview(false, "image_64");
        TestCase::assertEquals(true, $res['success']);
    }

    public function test_preview_download() {
        $res = $this->client->File($this->test_file_id)->preview_download(1, "image_64");
        TestCase::assertEquals(true, $res['success']);
    }

    public function test_copy() {
        $res = $this->client->File()->copy($this->test_file_id, $this->test_target_folder_id);
        TestCase::assertEquals(true, $res['success']);
    }

}