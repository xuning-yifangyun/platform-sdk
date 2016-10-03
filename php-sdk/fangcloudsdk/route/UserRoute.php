<?php
require_once "UrlTemplate.class.php";
/**
 * Created by PhpStorm.
 * User: xuning
 * Date: 16-10-2
 * Time: 下午3:00
 */
$info = new UrlTemplate("/user/%s/info");
$me_info = new UrlTemplate("/user/info");
$get_profile_pic = new UrlTemplate("/user/profile_pic_download");