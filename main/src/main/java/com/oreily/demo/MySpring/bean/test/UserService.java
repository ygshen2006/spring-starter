package com.oreily.demo.MySpring.bean.test;

public class UserService {
    private String name;

    private UserDao userDao;

    public void printUser() {
        System.out.println("Hello user");
    }
}
