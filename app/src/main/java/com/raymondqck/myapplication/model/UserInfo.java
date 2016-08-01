package com.raymondqck.myapplication.model;

import java.io.Serializable;

/**
 * Created by 陈其康 raymondchan on 2016/7/13 0013.
 */
public class UserInfo implements Serializable {

    private String name = null;
    private int age = 0;

    public UserInfo(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
