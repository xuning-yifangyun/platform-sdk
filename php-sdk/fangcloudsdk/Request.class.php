<?php

require_once "Network.class.php";
require_once "LoggerFactory.class.php";
require_once "Interceptor.class.php";
require_once "OpenApiException.php";

/**
 * Created by PhpStorm.
 * User: xuning
 * Date: 16-10-1
 * Time: 下午5:16
 */
class Request {

    private $oauth;
    private static $logger = null;

    /**
     * Request constructor.
     */
    public function __construct($oauth) {
        $this->oauth = $oauth;
        self::$logger = LoggerFactory::getLogger("Request");
    }

    /**
     * @param $url
     * @param $method
     * @param array $postbody
     * @return mixed|null|Requests_Response|string
     * @throws Exception
     */
    public function send(
        $url,
        $method,
        $postbody = array()
    ) {
        $method = strtoupper($method);
        $headers = $this->oauth->getApiTokenHeader();
        switch ($method) {
            case "GET":
                $response = Network::get($url, $headers);
                break;
            case "POST":
                $response = Network::post($url, $headers, json_encode($postbody));
                break;
            case "PUT":
                $response = Network::put($url, $headers, json_encode($postbody));
                break;
            case "DELETE":
                $headers = $this->get_delete_headers();
                $response = Network::delete($url, $headers, json_encode($postbody));
                break;
            default:
                $response = null;
        }

        $status = $response->status_code;
        $request_log_msg = "[url: $url] [method: $method]" . " [headers: " . implode($headers) . "] ['postbody: " . json_encode($postbody) . "]";
        self::$logger->addInfo($request_log_msg);
        Interceptor::deal_response_err($response);
        if ($status == 200) {
            if ($response->headers['content-type'] == "image/jpeg;charset=utf-8") {
                $response = $response->body;
            } else {
                $response = json_decode($response->body, true);
            }
            return $response;
        } else {
            if ($status == 401) {
                if ((time() - $this->oauth->getApplyTime()) > $this->oauth->getExpiresIn() * 1000) {
                    //TODO: 如果有多线程方案后这个范围同步加锁，但php本身不支持多线程
                    $this->oauth->refresh();
                    $response = $this->send($url, $method, $postbody);
                } else {
                    throw new OpenApiException("request error, status code:" . $status);
                }
            }
        }
        return $response;
    }

    public function get_delete_headers() {
        return array(
            "authorization: Bearer " . $this->oauth->getAccessToken(),
            "content-type: application/json"
        );
    }
}