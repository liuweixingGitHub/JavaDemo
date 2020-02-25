package com.ax.springsecurity.mapper;

import com.ax.springsecurity.entity.Userinfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserinfoMapper {

    Userinfo selectUserWithRelo(Long id);

    Userinfo selectUserAndReloByName(String username);
}
