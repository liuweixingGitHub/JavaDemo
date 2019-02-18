package com.ax.study.all.service;

import com.ax.study.db.entity.Userinfo;

public interface ITokenService {

    String getToken(Userinfo user);
}
