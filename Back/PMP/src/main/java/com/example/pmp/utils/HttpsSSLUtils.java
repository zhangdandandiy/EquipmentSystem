package com.example.pmp.utils;

import com.example.pmp.common.lang.MyX509TrustManager;
import com.example.pmp.common.lang.NullHostNameVerifier;

import javax.net.ssl.*;
import java.io.*;
import java.net.URL;
import java.security.KeyStore;

/**
 * @author Dandan
 * @date 2023/10/12 12:52
 **/
public class HttpsSSLUtils {

    /**
     * 发送https json 携带SSL证书请求
     *
     * @param keystoreFile 证书文件
     * @param keystorePass 证书密码
     * @param urlStr       服务端地址
     * @param jsonMsg      json信息内容
     * @param charsetName  编码
     * @return ${ result 响应参数}
     */
    public static String sendHttpSSLJsonMsg(String keystoreFile, String keystorePass, String keystoreType, String urlStr, String jsonMsg, String charsetName) throws Exception {
        try {
            if (charsetName.isEmpty()) {
                charsetName = "UTF-8";
            }
            // 设置可通过 IP 地址访问 HTTPS 请求
            HttpsURLConnection.setDefaultHostnameVerifier(new NullHostNameVerifier());

            // 加载证书
            KeyStore keyStore = KeyStore.getInstance(keystoreType);
            FileInputStream fis = new FileInputStream(keystoreFile);
            keyStore.load(fis, keystorePass.toCharArray());
            fis.close();

            // 创建 SSLContext 对象，并初始化
            KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
            kmf.init(keyStore, keystorePass.toCharArray());
            TrustManager[] tm = {new MyX509TrustManager()};
            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(kmf.getKeyManagers(), tm, null);

            // 从 SSLContext 对象中获取 SSLSocketFactory 对象
            SSLSocketFactory ssf = sslContext.getSocketFactory();
            URL url = new URL(urlStr);
            HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
            con.setSSLSocketFactory(ssf);
            con.setRequestMethod("POST"); // 设置以 POST 方式提交数据
            con.setDoInput(true); // 打开输入流，以便从服务器获取数据
            con.setDoOutput(true);// 打开输出流，以便向服务器提交数据

            PrintWriter out = new PrintWriter(new OutputStreamWriter(con.getOutputStream(), charsetName));
            // 设置发送参数
            out.print(jsonMsg);
            out.flush();
            out.close();

            // 读取请求返回值
            InputStreamReader in = new InputStreamReader(con.getInputStream(), charsetName);
            BufferedReader bfreader = new BufferedReader(in);
            System.out.println("bfreader:" + bfreader);
            StringBuilder result = new StringBuilder();
            String line;
            while ((line = bfreader.readLine()) != null) {
                result.append(line);
            }
            return result.toString();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

}
