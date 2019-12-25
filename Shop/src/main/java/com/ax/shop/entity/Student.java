package com.ax.shop.entity;

import lombok.Data;
import lombok.ToString;
import org.apache.ibatis.type.Alias;

import java.io.Serializable;

@Alias("Student")
@Data
@ToString
public class Student implements Serializable {


    private int id;
    private String name;
    private int age;
    private int sex;
    private String address;

}
