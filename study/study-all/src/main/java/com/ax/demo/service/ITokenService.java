package com.ax.demo.service;

import com.ax.demo.entity.Userinfo;

public interface ITokenService {

    String getToken(Userinfo user);
}
