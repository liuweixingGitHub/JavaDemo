package com.ax.shop.service;

import com.ax.shop.entity.Userinfo;

import java.util.List;

/**
 * @author axing
 */
public interface IUserinfoService {

    Userinfo get(Long id);

    List<Userinfo> getAllUserinfo();

}