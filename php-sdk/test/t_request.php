<?php
use PHPUnit\Framework\TestCase;
require_once "../fangcloudsdk/Request.class.php";
require_once "../fangcloudsdk/Oauth.class.php";
require_once "../fangcloudsdk/Client.class.php";

/**
 * Created by PhpStorm.
 * User: xuning
 * Date: 16-10-11
 * Time: 上午11:51
 */
class t_request extends TestCase{
    public $request=null;

    /**
     * t_request constructor.
     * @param null $request
     */
    public function __construct() {
        $this->request = new Request("");
    }

    public function test_send(){
        echo $this->request->send($url="http://www.baidu.com", $method="get")->body;
    }

    public function test_api() {
        $client_id="bbe8e63d-89b0-4f31-ba07-5fd602d501d8";
        $client_secret="5c179dfe-0f5a-4124-9690-42b69ec3aef7";
        $client_redirect_url="http://121.41.52.18:8080/callback";
        $oauth=new Oauth($client_id, $client_secret, $client_redirect_url);
        $oauth->setAccessToken("025f4815-4161-4de8-a875-8bd334eb3e2f");
        $client=new Client($oauth);
        echo $client->File(501000524950)->info();
    }
}