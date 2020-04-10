package com.ax.demo.entity;

import lombok.*;

import java.io.Serializable;


@Data
@NoArgsConstructor                 //无参构造
@AllArgsConstructor                //有参构造
@ToString
@Builder
public class Student implements Serializable {


    ///忽略set方法
    @Setter(AccessLevel.NONE)
    private int id;
    private String name;



}
