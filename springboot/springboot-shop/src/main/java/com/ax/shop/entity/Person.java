package com.ax.shop.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author axing
 */
public class Person {


    private Long id;
    private String name;
    private Integer age;


    private User user2;


    private List list1 = new ArrayList();


    public List getList1() {
        return list1;
    }

    public void setList1(List list1) {
        this.list1 = list1;
    }

    public User getUser2() {
        return user2;
    }

    public void setUser2(User user2) {
        this.user2 = user2;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }


}
