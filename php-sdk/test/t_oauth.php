<?php
use PHPUnit\Framework\TestCase;

/**
 * Created by PhpStorm.
 * User: xuning
 * Date: 16-10-12
 * Time: 上午9:43
 */
class t_oauth extends TestCase{

    public function __construct() {
        $client_id="bbe8e63d-89b0-4f31-ba07-5fd602d501d8";
        $client_secret="5c179dfe-0f5a-4124-9690-42b69ec3aef7";
        $client_redirect_url="http://121.41.52.18:8080/callback";
        $oauth=new Oauth($client_id, $client_secret, $client_redirect_url);
    }


    public function test_get_token_by_authcode(){

    }

}