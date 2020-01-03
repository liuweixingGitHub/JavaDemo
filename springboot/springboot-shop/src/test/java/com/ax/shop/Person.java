package com.ax.shop;

import com.alibaba.fastjson.JSON;
import lombok.*;

@ToString
@NonNull
@Builder
@NoArgsConstructor//: 自动生成无参数构造函数。
@AllArgsConstructor//: 自动生成全参数构造函数。

public class Person {

@Setter
@Getter
    private String name;
    @Getter
    private Integer age;


    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
