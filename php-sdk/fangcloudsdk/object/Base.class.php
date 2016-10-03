<?php
/**
 * Created by PhpStorm.
 * User: xuning
 * Date: 16-10-1
 * Time: 下午11:26
 */
class BaseObject {

    /**
     * BaseObject constructor.
     */
    protected $request_session = null;

    public function __construct() {

    }

    public function show_error($var) {
        var_dump($var);
    }
}