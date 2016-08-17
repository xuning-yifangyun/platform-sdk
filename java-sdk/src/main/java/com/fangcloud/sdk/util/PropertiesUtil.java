package com.fangcloud.sdk.util;

import java.util.Properties;

/**
 * Created by xuning on 2016/8/17.
 */
public class PropertiesUtil {

    private static PropertiesUtil propertiesUtil = new PropertiesUtil();
    private static Properties properties = System.getProperties();
    ;

    private PropertiesUtil() {

    }

    public static PropertiesUtil getPropertiesUtil() {
        return propertiesUtil;
    }

    public static boolean isLinux() {
        String osName = properties.get("os.name").toString();
        return !(osName.startsWith("Win") || osName.startsWith("win"));
    }

    public static void main(String[] args) {
        System.out.println(PropertiesUtil.isLinux());
    }

}
