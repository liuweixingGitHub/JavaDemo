package com.ax.shop.mapper;

import com.ax.shop.entity.Student;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

import java.text.MessageFormat;
import java.util.List;

public class StudentMapperProvider {

    public String inserList(@Param("list") List<Student> list) {
        StringBuilder sb = new StringBuilder();
        sb.append("insert into student(name,sex,age,address) values");
        MessageFormat mf = new MessageFormat(
                "( #'{'list[{0}].name}, #'{'list[{0}].sex}, #'{'list[{0}].age}, #'{'list[{0}].address} )"
        );
        for (int i = 0; i < list.size(); i++) {
            sb.append(mf.format(new Object[]{i}));
            if (i < list.size() - 1) {
                sb.append(",");
            }
        }
        return sb.toString();
    }


    public String insertStudent(Student student) {
        return new SQL() {
            {
                INSERT_INTO("student");

                if (student.getName() != null) {
                    VALUES("name", "#{name}");
                }
                if (student.getAddress() != null) {
                    VALUES("address", "#{address}");
                }
            }
        }.toString();
    }

    public String selectAll() {
        return new SQL() {
            {
                SELECT("*");
                FROM("student");
            }
        }.toString();
    }


}
