package com.example.pmp.common.constant;

import com.example.pmp.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Value;

/**
 * 默认的一些值
 *
 * @author Dandan
 * @date 2023/6/28 15:44
 **/
public class DefaultValues {

    /**
     * 定义头像存放地址
     */
    // @Value("${file.save-path-user-avatar}")
    public static final String saveUserAvatar = "${file.save-path-user-avatar}";

    /**
     * 定义头像存的服务器地址
     * public String serverAddress = "http://10.52.6.32:9002/static/assets/user-avatar/";
     */
    public static final String serverAddress = "http://localhost" + ":8080/static/assets/user-avatar/user-avatar/";

    /**
     * 默认头像地址
     * public String serverAddress = "http://10.52.6.32:9002/static/assets/user-avatar/";
     */
    public static final String defaultUserAvatar = "http://localhost" + ":8080/static/assets/user-avatar/user-default-avatar/6.jpg";

    /**
     * 定义默认密码
     */
    public static final String defaultUserPassword = "123456";

    /**
     * 定义默认性别
     */
    public static final String defaultUserSex = "1";

    /**
     * 定义默认用户状态
     */
    public static final String defaultUserStatus = "1";

    /**
     * 定义默认用户名
     */
    public static final String defaultUserName = generateDefaultUsername();

    /**
     * 生成用户默认手机号码
     */
    public static final String defaultUserPhoneNumber = "18294942774";

    /**
     * 定义随机密码盐
     */
    public static final String randomSalt = MD5Utils.generateSalt();

    /**
     * 生成默认用户名，规则为"用户" + 当前时间戳
     *
     * @return
     */
    public static final String generateDefaultUsername() {
        return "用户" + System.currentTimeMillis();
    }

}
