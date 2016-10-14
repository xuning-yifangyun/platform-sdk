<?php
require_once "../fangcloudsdk/Oauth.class.php";

/**
 * Created by PhpStorm.
 * User: xuning
 * Date: 16-10-12
 * Time: 下午1:39
 */

class test_global_var{
    public static function get_test_oauth(){
        $client_id="bbe8e63d-89b0-4f31-ba07-5fd602d501d8";
        $client_secret="5c179dfe-0f5a-4124-9690-42b69ec3aef7";
        $client_redirect_url="http://121.41.52.18:8080/callback";
        $test_access_token="ed8aadd1-b453-4f34-b372-43f5f7d679ad";
        $test_refresh_token="bceecd8b-ba45-4aca-8c4e-a80ed253f9f2";
        $oauth=new Oauth($client_id, $client_secret, $client_redirect_url);
        $oauth->setAccessToken($test_access_token);
        $oauth->setRefreshToken($test_refresh_token);
        return $oauth;
    }

}