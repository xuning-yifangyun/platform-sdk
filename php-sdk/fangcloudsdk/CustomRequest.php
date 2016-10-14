<?php
require_once "../vendor/autoload.php";
require_once "OpenApiException.php";

/**
 * Created by PhpStorm.
 * User: xuning
 * Date: 16-10-13
 * Time: 下午5:40
 */
class CustomRequest {
    public static function delete($url = null, $headers = null, $postbody = null) {
        $response = new Requests_Response();
        $curl = curl_init();
        curl_setopt_array(
            $curl,
            array(
                CURLOPT_URL => $url,
                CURLOPT_RETURNTRANSFER => true,
                CURLOPT_ENCODING => "utf-8",
                CURLOPT_MAXREDIRS => 10,
                CURLOPT_TIMEOUT => 30,
                CURLOPT_HTTP_VERSION => CURL_HTTP_VERSION_1_1,
                CURLOPT_CUSTOMREQUEST => "DELETE",
                CURLOPT_POSTFIELDS => $postbody,
                CURLOPT_HTTPHEADER => $headers,
            ));

        curl_exec($curl);
        //设置返回成员变量的值
        $response->status_code = curl_getinfo($curl, CURLINFO_HTTP_CODE);
        $response->headers['content-type'] = "application/json;charset=utf-8";
        $response->body = curl_multi_getcontent($curl);
        curl_close($curl);
        return $response;
    }
}