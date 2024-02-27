package com.example.pmp.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * MD5加密工具类
 *
 * @author Dandan
 * @date 2023/6/2 8:48
 */
public class MD5Utils {
    /**
     * 生成含有随机盐的密码
     *
     * @param password 明文密码
     * @param salt     盐
     * @return 包含随机盐的密码
     */
    public static String generate(String password, String salt) {
        // 将盐和密码拼接
        String saltedPassword = salt + password;

        // 对加盐后的密码进行摘要生成
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            byte[] saltedPasswordBytes = saltedPassword.getBytes();
            byte[] hash = digest.digest(saltedPasswordBytes);
            return bytesToHex(hash);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 生成一个随机的盐值
     *
     * @return 随机的盐值
     */
    public static String generateSalt() {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        return bytesToHex(salt);
    }

    /**
     * 将字节数组转换成十六进制字符串
     *
     * @param bytes 字节数组
     * @return 十六进制字符串
     */
    private static String bytesToHex(byte[] bytes) {
        StringBuilder builder = new StringBuilder();
        for (byte b : bytes) {
            builder.append(String.format("%02x", b));
        }
        return builder.toString();
    }

    /**
     * 校验密码
     *
     * @param inputPassword
     * @param salt
     * @param targetPassword
     * @return
     */
    public static boolean validatePassword(String inputPassword, String salt, String targetPassword) {
        String inputPasswordMD5 = MD5Utils.generate(inputPassword, salt);
        return inputPasswordMD5.equals(targetPassword);
    }

}