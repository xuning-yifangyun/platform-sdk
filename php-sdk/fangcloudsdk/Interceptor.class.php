<?php
require_once "LoggerFactory.class.php";

/**
 * Created by PhpStorm.
 * User: xuning
 * Date: 16-10-12
 * Time: 下午7:31
 */
class Interceptor {

    public static function deal_response_err($response = null) {
        $logger = LoggerFactory::getLogger("Response");
        if ($response != null) {
            $status_code = $response->status_code;
            switch ($status_code) {
                case 500:
                    throw new Exception("server error");
                    break;
                case 401:
                    null;
                    break;
                case 200:
                    null;
                    break;
                default:
                    throw new Exception("error code:" + $status_code);
            }
            if (!($response->headers['content-type'] == "image/jpeg;charset=utf-8")) {
                $con=array(" ","　","\t","\n","\r");
                $response_log_msg = "[status code: $status_code] [content: " . str_replace($con, null, $response->body) . "]";
            } else {
                $response_log_msg = "[status code: $status_code] [content: is stream]";
            }
            $logger->addInfo($response_log_msg);
        }
    }
}