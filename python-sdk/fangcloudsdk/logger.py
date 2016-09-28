# -*- coding: utf-8 -*-
try:
    from .config import Config
except Exception:
    from fangcloudsdk.config import Config
import logging
import threading


class LoggerFactory(object):
    Logger = None
    LoggerLock = threading.RLock()

    @staticmethod
    def get_logger_instance():
        if LoggerFactory.Logger is None:
            try:
                LoggerFactory.LoggerLock.acquire()
                if LoggerFactory.Logger is None:
                    LoggerFactory.Logger = logging.getLogger("open_platform")
                    LoggerFactory.Logger.setLevel(Config.get_log_level())
                    formatter = logging.Formatter(
                        "%(asctime)s - %(thread)d - %(levelname)s - %(filename)s[line:%(lineno)d] - %(message)s")
                    console_handler = logging.StreamHandler()
                    console_handler.setLevel(logging.DEBUG)
                    console_handler.setFormatter(formatter)
                    LoggerFactory.Logger.addHandler(console_handler)
                    logging.basicConfig(
                        format="%(asctime)s - %(thread)d - %(levelname)s - %(filename)s[line:%(lineno)d] - %(message)s",
                        filename=Config.get_log_file_path(),
                        filemode='a'
                    )
            finally:
                LoggerFactory.LoggerLock.release()
        return LoggerFactory.Logger
