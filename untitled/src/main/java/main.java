import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.io.UnsupportedEncodingException;
import java.util.Date;

public class main {

    public static void main(String[] args)  {



        String id = "1";

        String subject = "{'name':'jim'}";
        String generalKey = "aaa";
long ttlMillis = 1000;



     String token =  JwtUtils.createJWT("1",subject,ttlMillis);



//        Algorithm algorithm = null;
//
//        try {
//            algorithm = Algorithm.HMAC256(generalKey);
//        }catch (Exception e){
//
//        }
//
//        long nowMillis = System.currentTimeMillis();
//        Date now = new Date();
//
//        JWTCreator.Builder builder = JWT.create().withJWTId(id).withIssuer("user").withSubject(subject);
//
//        if (ttlMillis >= 0) {
//            long expMillis = nowMillis + ttlMillis;
//            Date expDate = new Date(expMillis);
//            builder.withExpiresAt(expDate); // 过期时间
//        }
//        String token = null;
//
//        try {
//             token =  builder.sign(Algorithm.HMAC256(generalKey));
//        }catch (Exception e){
//
//        }


        System.out.println("token = " + token);
//try {
//
//    Thread.sleep(2000);
//}catch (Exception e){
//
//}


//        try {
//            DecodedJWT decodedJWT =  JWT.require(algorithm).withIssuer("user").build().verify(token);
//
//            System.out.println("decodedJWT.getId() = " + decodedJWT.getId());
//
//            System.out.println("decodedJWT.getSubject() = " + decodedJWT.getSubject());
//
//            System.out.println("   decodedJWT.getToken() = " +    decodedJWT.getToken());
//
//        }catch (Exception e){
//
//            System.out.println("验证失败"+e);
//        }
        System.out.println(" JwtUtils.validateJWT(token) = " + JwtUtils.validateJWT(token));
        System.out.println(" JWT.decode(token).getAudience().get(0); = " +  JwtUtils.parseJWT(token).getIssuer());
;



    }
}