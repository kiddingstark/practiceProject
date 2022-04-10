package com.ahong.aop;

public class UserDaoImpl implements UserDao{

    @Override
    public void saveUser() {
        System.out.println("saveUser实现");
    }

    @Override
    public void updateUser() {
        System.out.println("updateUser实现");
    }
}
