import ConfigParser
import os


class ConfigReader(object):

    def __init__(self, config_path):
        self.config = ConfigParser.ConfigParser()
        self.config.read(config_path)
        print(os.getcwd())

    def get_database_info(self):
        database_info = {
            "address": self.config.get("database", "address"),
            "port": self.config.get("database", "port"),
            "user_name": self.config.get("database", "username"),
            "password": self.config.get("database", "password"),
            "schema": self.config.get("database", "schema")
        }
        return database_info

    def get_demo_info(self):
        demo_info = {
            "host": self.config.get("demo", "base_host")
        }
        return demo_info

    def get_cloud_info(self):
        cloud_info = {
            "host": self.config.get("cloud", "base_host"),
            "schema": self.config.get("cloud", "schema")
        }
        return cloud_info

    def get_admin_info(self):
        admin_info = {
            "enable": self.config.get("admin", "enable"),
            "user_name": self.config.get("admin", "user_name"),
            "password": self.config.get("admin", "password")
        }
        if self.config.get("admin", "enable") in ["True", "TRUE", "true"]:
            admin_info["enable"] = True
        else:
            admin_info["enable"] = False
        return admin_info

    def get_oauth_info(self):
        oauth_info = {
            "client_id": self.config.get("oauth", "client_id"),
            "client_secret": self.config.get("oauth", "client_secret"),
            "authorization_base_url": self.config.get("oauth", "authorization_base_url"),
            "token_url": self.config.get("oauth", "token_url")
        }
        return oauth_info


