package com.example.pmp.utils;

import java.net.InetAddress;

/**
 * 电脑相关工具类
 *
 * @author Dandan
 * @date 2023/6/5 8:49
 **/
public class ComputerUtils {

    /**
     * 获取电脑IP地址(动态IP)
     *
     * @return
     */
    public static String getComputerIp() {
        try {
            InetAddress address = InetAddress.getLocalHost();
            return address.getHostAddress();
        } catch (Exception e) {
            e.printStackTrace();
            return "无法获取本机IP地址！";
        }
    }

}
