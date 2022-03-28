package com.ply.flashsalessystem.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

@Slf4j
public class JWTUtil {
    // 过期时间5分钟
    private static final long EXPIRE_TIME = 60* 60 * 60 * 1000;
    private static final String secret = "aslkdjlaksdklj";

    /**
     * 生成签名,5min后过期
     *
     * @param name name
     * @return 加密的token
     */

    public static String sign(Long id, String name, String type) {

        Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
        Algorithm algorithm = Algorithm.HMAC256(secret);
        // 附带name, id, type信息
        return JWT.create()
                .withClaim("id", id)
                .withClaim("name", name)
                .withClaim("type", type)
                .withExpiresAt(date)
                .sign(algorithm);
    }

    /**
     * 校验token是否正确
     *
     * @param token 密钥
     * @return 是否正确
     */
//    public static boolean verify(String token, String username, String secret) {
    public static boolean verify(String token) {
        Algorithm algorithm = Algorithm.HMAC256(secret);
        JWTVerifier verifier = JWT.require(algorithm)
                .build();
        try {
            //出现异常 说明 验证Token 失败
            DecodedJWT jwt = verifier.verify(token);
            UserUtils.addUserUtils(jwt.getClaim("id").asLong(),jwt.getClaim("name").asString(),jwt.getClaim("type").asString());
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public static boolean verifyToken(String token, String type) {
        if (!verify(token)) {
            log.info("token:{}" ,token);
            log.info("token错误");
            return false;
        }

        Date expireTime = getDate(token);

        if (new Date(System.currentTimeMillis()).compareTo(expireTime) > 0) {
//            System.out.println(System.currentTimeMillis() + "\t" + expireTime);
            log.info("当前的时间:{},token的过期时间:{},无效的token", System.currentTimeMillis(), expireTime);
            return false;
        }
        log.info("登录成功:{} \n过期时间:{}", UserUtils.getUserName() , expireTime);

        return true;
    }


    /**
     * 获得token中的信息无需secret解密也能获得
     *
     * @return token中包含的用户名
     */
//    public static String getUsername(String token) {
//        DecodedJWT jwt = JWT.decode(token);
//        return jwt.getClaim("name").asString();
//    }

    /**
     * 获得token中的信息无需secret解密也能获得
     *
     * @return token中的过期时间
     */
    public static Date getDate(String token) {
        DecodedJWT jwt = JWT.decode(token);
        return jwt.getExpiresAt();
    }
}
