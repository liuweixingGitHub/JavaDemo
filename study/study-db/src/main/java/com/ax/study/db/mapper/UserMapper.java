package com.ax.study.db.mapper;

import com.ax.study.db.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


/**
 * @author axing
 */
@Mapper
public interface UserMapper {

    void insert(User user);

    void update(User user);

    User get(Long id);

    void delete(Long id);

    List<User> list();

}
