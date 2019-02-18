package com.ax.demo.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.ax.demo.entity.Userinfo;
import com.ax.demo.service.ITokenService;

public class TokenServiceImpl implements ITokenService {

    @Override
    public String getToken(Userinfo user) {
        String token = JWT.create().withAudience(user.getId().toString())
                .sign(Algorithm.HMAC256(user.getPassWord()));
        return token;
    }
}
