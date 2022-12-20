package com.chenzhi.common.utils;


import com.chenzhi.common.utils.uuid.IdUtils;
import com.chenzhi.domain.dto.LoginUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


import java.util.HashMap;
import java.util.Map;


@Component
public class TokenService {



    // 令牌自定义标识
    @Value("${token.header}")
    private  String header;

    // 令牌秘钥
    @Value("${token.secret}")
    private  String secret;

    // 令牌有效期（默认30分钟）
    @Value("${token.expireTime}")
    private  int expireTime;

    protected static final long MILLIS_SECOND = 1000;

    protected static final long MILLIS_MINUTE = 60 * MILLIS_SECOND;

    private static final Long MILLIS_MINUTE_TEN = 20 * 60 * 1000L;

    /**
     * 创建令牌
     *
     * @param loginUser 用户信息
     * @return 令牌
     */
    public  String createToken(LoginUser loginUser)
    {
        String uuid = IdUtils.fastUUID();
        loginUser.setToken(uuid);
//        setUserAgent(loginUser);
//        refreshToken(loginUser);

        Map<String, Object> claims = new HashMap<>();
        claims.put("login_user_key", uuid);
        return createToken(claims);
    }
    /**
     * 从数据声明生成令牌
     *
     * @param claims 数据声明
     * @return 令牌
     */
    private  String createToken(Map<String, Object> claims)
    {
        String token = Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, secret).compact();
        return token;
    }

    /**
     * 从令牌中获取数据声明
     *
     * @param token 令牌
     * @return 数据声明
     */
    public  Claims parseToken(String token)
    {
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();
    }

//    /**
//     * 设置用户代理信息
//     *
//     * @param loginUser 登录信息
//     */
//    public void setUserAgent(LoginUser loginUser)
//    {
//        UserAgent userAgent = UserAgent.parseUserAgentString(ServletUtils.getRequest().getHeader("User-Agent"));
//        String ip = IpUtils.getIpAddr(ServletUtils.getRequest());
//        loginUser.setIpaddr(ip);
//        loginUser.setLoginLocation(AddressUtils.getRealAddressByIP(ip));
//        loginUser.setBrowser(userAgent.getBrowser().getName());
//        loginUser.setOs(userAgent.getOperatingSystem().getName());
//    }

//    /**
//     * 刷新令牌有效期
//     *
//     * @param loginUser 登录信息
//     */
//    public void refreshToken(LoginUser loginUser)
//    {
//        loginUser.setLoginTime(System.currentTimeMillis());
//        loginUser.setExpireTime(loginUser.getLoginTime() + expireTime * MILLIS_MINUTE);
//        // 根据uuid将loginUser缓存
//        String userKey = getTokenKey(loginUser.getToken());
//        redisCache.setCacheObject(userKey, loginUser, expireTime, TimeUnit.MINUTES);
//    }

}
