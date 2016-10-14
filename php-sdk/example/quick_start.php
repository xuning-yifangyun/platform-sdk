<?php
require_once "../fangcloudsdk/Oauth.class.php";
require_once "../fangcloudsdk/Client.class.php";

/**
 * Created by PhpStorm.
 * User: xuning
 * Date: 16-10-14
 * Time: 下午2:43
 */
$oauth=new Oauth(
    "you client_id",
    "you client_secret",
    "you client_rediect_url"
);

$oauth->authenticate("you auth code");
$client=new Client($oauth);

$client->File("you file_id")->info();
$client->Folder()->move("you option");
//....