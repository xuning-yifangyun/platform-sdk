<?php
require_once "Network.class.php";
require_once "Route.php";

/**
 * Created by PhpStorm.
 * User: xuning
 * Date: 16-10-1
 * Time: 下午4:26
 */
class Oauth {
    private $client_id;
    private $client_secret;
    private $client_redirect_url;
    private $access_token;
    private $refresh_token;
    private $expires_in;
    private $apply_time;
    private $oauth_route;

    /**
     * Oauth constructor.
     * @param $client_id
     * @param $client_secret
     * @param $client_redirect_url
     */
    public function __construct($client_id, $client_secret, $client_redirect_url) {
        global $oauth_route;
        $this->oauth_route = $oauth_route;
        $this->client_id = $client_id;
        $this->client_secret = $client_secret;
        $this->client_redirect_url = $client_redirect_url;
    }

    /**
     * 获取授权url
     */
    public function get_authorization_url() {
        return $this->oauth_route['authorize']->query(
            array(
                "client_id" => $this->client_id,
                "redirect_uri" => $this->client_redirect_url,
                "response_type" => "code",
                "state" => ""
            )
        )->get_url();
    }

    /**
     * 根据授权码获取token
     * @param null $auth_code
     */
    public function authenticate($auth_code = null) {
        $url = $this->oauth_route['token']->query(
            array(
                "grant_type" => "authorization_code",
                "code" => $auth_code,
                "redirect_uri" => $this->client_redirect_url
            )
        )->get_url();
        $headers = $this->getOauthHeader();
        $token = $this->send_oauth_request($url, $headers);
        $this->update_token($token);
    }

    /**
     * /刷新token
     * @param $this
     */
    public function refresh() {
        $url = $this->oauth_route['token']->query(
            array(
                "grant_type" => "refresh_token",
                "refresh_token" => $this->refresh_token
            )
        )->get_url();
        $headers = $this->getOauthHeader();
        $token = $this->send_oauth_request($url, $headers);
        $this->update_token($token);
        return $token;
    }

    /**
     * 更新token数据
     * @param $token
     */
    public function update_token($token) {
        $this->access_token = $token['access_token'];
        $this->refresh_token = $token['refresh_token'];
        $this->expires_in = $token['expires_in'];
        $this->apply_time = time();
    }

    /**
     * 撤销token认证
     */
    public function revoke() {
        $this->access_token = null;
    }

    /**
     * @return mixed
     */
    public function getAccessToken() {
        return $this->access_token;
    }

    /**
     * @param mixed $access_token
     */
    public function setAccessToken($access_token) {
        $this->access_token = $access_token;
    }

    /**
     * @return mixed
     */
    public function getRefreshToken() {
        return $this->refresh_token;
    }

    /**
     * @param mixed $refresh_token
     */
    public function setRefreshToken($refresh_token) {
        $this->refresh_token = $refresh_token;
    }

    /**
     * @return mixed
     */
    public function getExpiresIn() {
        return $this->expires_in;
    }

    /**
     * @param mixed $expires_in
     */
    public function setExpiresIn($expires_in) {
        $this->expires_in = $expires_in;
    }

    /**
     * @return mixed
     */
    public function getApplyTime() {
        return $this->apply_time;
    }

    /**
     * @param mixed $apply_time
     */
    public function setApplyTime($apply_time) {
        $this->apply_time = $apply_time;
    }

    public function getApiTokenHeader() {
        $arr = array(
            "Content-Type" => "application/json",
            "Authorization" => "Bearer " . $this->getAccessToken()
        );
        return $arr;
    }

    public function getOauthHeader() {
        return array(
            "Authorization" => "Basic " . base64_encode($this->client_id . ":" . $this->client_secret)
        );
    }

    public function send_oauth_request($url) {
        $headers = $this->getOauthHeader();
        $response = Network::post($url = $url, $headers = $headers);
        if ($response->status_code == 200) {
            return json_decode($response->body, true);
        } else {
            //异常
            throw new Exception($message = "update token is error , response status code is :" . $response->status_code);
        }
    }
}