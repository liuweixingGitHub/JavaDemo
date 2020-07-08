package com.ax.demo.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;


@Data
@NoArgsConstructor                 //无参构造
@AllArgsConstructor                //有参构造
@ToString
@Builder
@ApiModel(value = "返回学生")
public class Student implements Serializable {


    ///忽略set方法
    @Setter(AccessLevel.NONE)
    @ApiModelProperty(value = "学生id")
    private int id;
    private String name;

}
