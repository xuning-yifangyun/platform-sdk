<?php

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
    private $expirse_in;
    private $apply_time;


    /**
     * Oauth constructor.
     * @param $client_id
     * @param $client_secret
     * @param $client_redirect_url
     */
    public function __construct($client_id, $client_secret, $client_redirect_url) {
        $this->client_id = $client_id;
        $this->client_secret = $client_secret;
        $this->client_redirect_url = $client_redirect_url;
    }

    /**
     * 获取授权url
     */
    public function get_authorization_url() {

    }

    /**
     * 根据授权码获取token
     * @param null $auth_code
     */
    public function authenticate($auth_code = null) {

    }

    /**
     * /刷新token
     * @param $this
     */
    public function update_token($this) {

    }

    /**
     * 撤销token认证
     */
    public function revoke() {

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
    public function getExpirseIn() {
        return $this->expirse_in;
    }

    /**
     * @param mixed $expirse_in
     */
    public function setExpirseIn($expirse_in) {
        $this->expirse_in = $expirse_in;
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



}