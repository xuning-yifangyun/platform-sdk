<?php
require_once '../vendor/autoload.php';
$response=Requests::get("http://www.networklab.cn/test/parm.php",array("username"=>"xuning"));
echo $response->body;