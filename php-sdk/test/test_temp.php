<?php
use PHPUnit\Framework\TestCase;

/**
 * Created by PhpStorm.
 * User: xuning
 * Date: 16-10-11
 * Time: 上午11:43
 */
//TODO: 这里和python不同，这里不是按照字典序执行，是按照位置顺序
class test_temp extends TestCase {
    public function test_02() {
        echo "aa";
    }

    public function test_01() {
        echo "bb";
    }



}