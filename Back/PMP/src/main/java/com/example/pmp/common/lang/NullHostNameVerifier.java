package com.example.pmp.common.lang;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

/**
 * 预前检验
 *
 * @author Dandan
 * @date 2023/10/12 12:54
 **/
public class NullHostNameVerifier implements HostnameVerifier {
    @Override
    public boolean verify(String s, SSLSession sslSession) {
        return true;
    }
}
