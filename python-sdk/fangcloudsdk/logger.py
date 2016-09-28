# -*- coding: utf-8 -*-
import logging
import threading


class LoggerFactory(object):
    Logger = None
    LoggerLock = threading.RLock()

    @staticmethod
    def get_logger_instance():
        # todo: 增加文件存储, 传参数制定文件路径, 记录在config中
        if LoggerFactory.Logger is None:
            try:
                LoggerFactory.LoggerLock.acquire()
                if LoggerFactory.Logger is None:
                    LoggerFactory.Logger = logging.getLogger("open_platform")
                    LoggerFactory.Logger.setLevel(logging.DEBUG)
                    formatter = logging.Formatter(
                        "%(asctime)s - %(thread)d - %(levelname)s - %(filename)s[line:%(lineno)d] - %(message)s")
                    console_handler = logging.StreamHandler()
                    console_handler.setLevel(logging.DEBUG)
                    console_handler.setFormatter(formatter)
                    LoggerFactory.Logger.addHandler(console_handler)
            finally:
                LoggerFactory.LoggerLock.release()
        return LoggerFactory.Logger
