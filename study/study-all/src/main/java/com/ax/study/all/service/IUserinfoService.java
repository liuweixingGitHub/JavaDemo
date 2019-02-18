package com.ax.study.all.service;

import com.ax.study.db.entity.Userinfo;

import java.util.List;

/**
 * @author axing
 */
public interface IUserinfoService {

    Userinfo get(Long id);

    List<Userinfo> getAllUserinfo();

}
