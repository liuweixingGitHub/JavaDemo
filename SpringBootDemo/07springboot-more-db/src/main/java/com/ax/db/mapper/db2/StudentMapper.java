package com.ax.db.mapper.db2;

import com.ax.db.entity.db2.Student;

public interface StudentMapper {

     Student selectById(Long id);
}