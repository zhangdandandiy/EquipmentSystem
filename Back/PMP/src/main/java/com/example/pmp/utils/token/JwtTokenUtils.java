package com.example.pmp.utils.token;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * JWT 工具类
 *
 * @author Dandan
 * @date 2023/6/10 15:51
 **/

@Component
public class JwtTokenUtils {

    private static String secret = "admin";

    private static int expiration = 86400;

    /**
     * 生成 token
     *
     * @param userJobNumber
     * @return
     */
    public static String generateToken(String userJobNumber) {
        Map<String, Object> claims = new HashMap<>();
        // 主题
        claims.put("userJobNumber", userJobNumber);
        // 创造时间
        claims.put("created", new Date());
        return Jwts.builder()
                // 载荷(payload)
                .setClaims(claims)
                .setExpiration(new Date(System.currentTimeMillis() + expiration * 1000))
                // 数字签名(signature)
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    public static boolean validateToken(String token, String username) {
        String tokenUsername = getUsernameFromToken(token);
        return tokenUsername.equals(username) && !isTokenExpired(token);
    }

    private static Date getExpirationDateFromToken(String token) {
        Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
        return claims.getExpiration();
    }

    private static String getUsernameFromToken(String token) {
        Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
        return claims.getSubject();
    }

    private static boolean isTokenExpired(String token) {
        Date expiration = getExpirationDateFromToken(token);
        return expiration != null && expiration.before(new Date());
    }

}
