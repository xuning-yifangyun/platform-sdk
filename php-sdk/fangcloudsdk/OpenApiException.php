<?php

/**
 * Created by PhpStorm.
 * User: xuning
 * Date: 16-10-12
 * Time: 下午7:32
 */
class OpenApiException extends Exception {

    /**
     * OpenApiException constructor.
     */
    public function __construct($message) {
        parent::__construct($message);
    }
}