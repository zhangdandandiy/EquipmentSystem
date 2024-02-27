package com.example.pmp.common.lang;

import javax.net.ssl.X509TrustManager;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/**
 * 信任管理器
 *
 * @author Dandan
 * @date 2023/10/12 12:55
 **/
public class MyX509TrustManager implements X509TrustManager {

//    X509TrustManager sunJSSEX509TrustManager;
//
//    public MyX509TrustManager(String keystoreFile, String pass) throws Exception {
//        KeyStore ks = KeyStore.getInstance("JKS");
//        ks.load(new FileInputStream(keystoreFile), pass.toCharArray());
//        TrustManagerFactory tmf = TrustManagerFactory.getInstance("SunX509", "SunJSSE");
//        tmf.init(ks);
//        TrustManager tms[] = tmf.getTrustManagers();
//        for (int i = 0; i < tms.length; i++) {
//            if (tms[i] instanceof X509TrustManager) {
//                sunJSSEX509TrustManager = (X509TrustManager) tms[i];
//                return;
//            }
//        }
//        throw new Exception("Couldn't initialize");
//    }
//
//    @Override
//    public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
//        try {
//            sunJSSEX509TrustManager.checkClientTrusted(chain, authType);
//        } catch (CertificateException excep) {
//            excep.printStackTrace();
//        }
//    }
//
//    @Override
//    public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
//        try {
//            sunJSSEX509TrustManager.checkServerTrusted(chain, authType);
//        } catch (CertificateException excep) {
//            excep.printStackTrace();
//        }
//    }
//
//    @Override
//    public X509Certificate[] getAcceptedIssuers() {
//        return sunJSSEX509TrustManager.getAcceptedIssuers();
//    }

    // 检查客户端证书
    public void checkClientTrusted(X509Certificate[] cert, String authType) throws CertificateException {
    }

    // 检查服务器端证书
    public void checkServerTrusted(X509Certificate[] cert, String authType) throws CertificateException {
    }

    // 返回受信任的X509证书数组
    public X509Certificate[] getAcceptedIssuers() {
        return null;
    }

}
