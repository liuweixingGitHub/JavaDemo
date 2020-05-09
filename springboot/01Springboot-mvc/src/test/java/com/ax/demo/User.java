package com.ax.demo;

import java.util.concurrent.Callable;

public class User {

    private Integer id;

    private String name;

    private Integer age;

    private String address;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "com.xiaowan.User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }

    public User() {
    }


    public User test(Callable<String> callable) {

        try {
            String object = callable.call();
            System.out.println("object = " + object);
            return this;
        } catch (Exception e) {
            return this;
        }
    }

    public void test2(Runnable runnable) {

        try {
            runnable.run();
            System.out.println("test2==========");
        } catch (Exception e) {

        }
    }


}

