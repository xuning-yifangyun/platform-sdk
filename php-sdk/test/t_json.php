<?php
/**
 * Created by PhpStorm.
 * User: xuning
 * Date: 16-10-11
 * Time: 下午7:26
 */
$str="
    {\"aaa\":
        {
            \"bbb\":222
        }
    }
";
$json=json_decode($str);
var_dump($json);
echo $json->aaa->bbb;