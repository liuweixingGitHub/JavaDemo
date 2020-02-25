package com.ax.shop.util.axUtil;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;


/**
 * @author xing
 */
public class AxJwtUtil {

    public static String generalKey = "aaa";
    public static String issuer = "user";

    /**
     * 签发JWT
     *
     * @param id
     * @param audience 对方
     * @param subject  可以是JSON数据 尽可能少
     * @param timeout  大于0 表示有效期
     * @return String
     */
    public static String createJWT(String id, String audience, String subject, long timeout) {

        String token = null;

        Algorithm algorithm;

        try {
            algorithm = Algorithm.HMAC256(generalKey);
        } catch (Exception e) {
            return null;
        }

        long nowMillis = System.currentTimeMillis();
        Date now = new Date();

        JWTCreator.Builder builder = JWT.create().withJWTId(id).withIssuer(issuer);

        if (subject != null) {
            builder.withSubject(subject);
        }
        if (audience != null) {
            builder.withAudience(audience);
        }


        if (timeout > 0) {
            long expMillis = nowMillis + timeout;
            Date expDate = new Date(expMillis);
            // 过期时间
            builder.withExpiresAt(expDate);
        }

        try {
            token = builder.sign(algorithm);
        } catch (Exception e) {

        }

        return token;
    }

    /**
     * 验证JWT
     *
     * @param token
     * @return
     */
    public static boolean validateJWT(String token) {

        Algorithm algorithm ;

        try {
            algorithm = Algorithm.HMAC256(generalKey);
        } catch (Exception e) {
            return false;
        }

//        JWTVerifier verifier = JWT.require(algorithm).withIssuer(issuer).build();
//        verifier.verify(token);
//        return true;


        try {
            JWTVerifier verifier  = JWT.require(algorithm).withIssuer(issuer).build();
            verifier.verify(token);
            System.out.println("token验证成功");
            return true;
        } catch (Exception e) {
            System.out.println("token验证失败" + e);
            return false;
        }

    }

    /**
     * 解析JWT字符串
     *
     * @param token
     * @return
     * @throws Exception
     */
    public static DecodedJWT parseJWT(String token) {

        try {
            System.out.println("解析JWT字符串成功");
            return JWT.decode(token);
        } catch (Exception e) {
            System.out.println("解析JWT字符串" + e);
            return null;
        }
    }
}
