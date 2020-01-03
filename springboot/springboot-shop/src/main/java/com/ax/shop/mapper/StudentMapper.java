package com.ax.shop.mapper;

import com.ax.shop.entity.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface StudentMapper {

    //    @Insert("insert into student(name,age,sex,address) values(#{name},#{age},#{sex},#{address})")
    @InsertProvider(type = StudentMapperProvider.class, method = "insertStudent")
    public int insertStudent(Student student);

    @Delete("delete from student where id=#{0}")
    public int delStu(int id);

    @Select("select * from student where id=#{0}")
    public Student selectById(int id);

    //    @Select("select * from student")
    @SelectProvider(type = StudentMapperProvider.class, method = "selectAll")
    public List<Student> selectAll();


    @Select("select * from student limit #{param1},#{param2}")
    public List<Student> selectByLimit(int startRow, int endRow);

    @Update("update student set name=#{name},age=#{age},sex=#{sex},address=#{address} where id=#{id}")
    public int updateStu(Student student);


    @InsertProvider(type = StudentMapperProvider.class, method = "inserList")
    public int inserList(@Param("list") List<Student> list);


}