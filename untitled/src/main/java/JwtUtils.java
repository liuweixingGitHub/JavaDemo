import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;


public class JwtUtils {

    public static String generalKey = "aaa";

    /**
     * 签发JWT
     *
     * @param id
     * @param subject 可以是JSON数据 尽可能少
     * @param timeout
     * @return String
     */
    public static String createJWT(String id, String subject, long timeout) {

        String token = null;

        Algorithm algorithm;

        try {
            algorithm = Algorithm.HMAC256(generalKey);
        } catch (Exception e) {
            return null;
        }

        long nowMillis = System.currentTimeMillis();
        Date now = new Date();

        JWTCreator.Builder builder = JWT.create().withJWTId(id).withIssuer("user").withSubject(subject);

        if (timeout >= 0) {
            long expMillis = nowMillis + timeout;
            Date expDate = new Date(expMillis);
            builder.withExpiresAt(expDate); // 过期时间
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
        Algorithm algorithm = null;

        try {
            algorithm = Algorithm.HMAC256(generalKey);

        } catch (Exception e) {
            return false;
        }

        try {
            JWTVerifier verifier  = JWT.require(algorithm).withIssuer("user").build();
            verifier.verify(token);

            return true;

        } catch (JWTVerificationException e) {

            System.out.println("验证失败" + e);
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

        return JWT.decode(token);
    }
}
