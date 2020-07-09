package com.ax.shop.service;

import com.ax.shop.entity.Userinfo;

public interface ITokenService {

    String getToken(Userinfo user);
}
