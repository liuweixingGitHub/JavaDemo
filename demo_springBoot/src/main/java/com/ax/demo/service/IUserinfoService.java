package com.ax.demo.service;

import com.ax.demo.entity.Userinfo;

import java.util.List;

/**
 * @author axing
 */
public interface IUserinfoService {

    Userinfo get(Long id);

    List<Userinfo> getAllUserinfo();

}
