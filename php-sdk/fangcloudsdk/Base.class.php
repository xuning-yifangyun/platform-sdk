<?php
require_once "Request.class.php";
require_once "Route.php";

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

    protected $request_session;
    protected $oauth;

    public function __construct() {

    }

    public function show_error($var) {
        print_r(var_dump($var));
    }

}