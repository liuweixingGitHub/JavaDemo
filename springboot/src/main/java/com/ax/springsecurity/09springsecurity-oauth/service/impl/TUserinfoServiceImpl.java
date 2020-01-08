package com.ax.springsecurity.09springsecurity-oauth.service.impl;

import com.ax.springsecurity.09springsecurity-oauth.entity.TUserinfo;
import com.ax.springsecurity.09springsecurity-oauth.mapper.TUserinfoMapper;
import com.ax.springsecurity.09springsecurity-oauth.service.ITUserinfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jobob
 * @since 2020-01-09
 */
@Service
public class TUserinfoServiceImpl extends ServiceImpl<TUserinfoMapper, TUserinfo> implements ITUserinfoService {

}
