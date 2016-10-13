<?php
use Monolog\Formatter\LineFormatter;
use Monolog\Logger;
use Monolog\Handler\StreamHandler;
use \Monolog\Handler\FirePHPHandler;

require_once "Config.class.php";


class LoggerFactory {
    private static $logger = null;
    private static $log_path = null;
    private static $log_level = Logger::WARNING;

    private function __construct() {
    }

    public static function getLogger($logger_name) {
        self::$log_level = Config::getLogLevel();
        self::$log_path = Config::getLogOutPath();
        if (self::$logger != null) {
            return self::$logger;
        } else {
            self::$logger = new Logger($logger_name);
            if (!Config::isLogDisplayConsole()) {
                $stream_handler = new StreamHandler(self::$log_path, self::$log_level);
                $dateFormat = "Y-n-j g:i:s";
                $output = "[%datetime%] %level_name% %message% \n";
                $formatter = new LineFormatter($output, $dateFormat);
                $stream_handler->setFormatter($formatter);
                self::$logger->pushHandler($stream_handler);
                self::$logger->pushHandler(new FirePHPHandler());
            }
            return self::$logger;
        }
    }
}