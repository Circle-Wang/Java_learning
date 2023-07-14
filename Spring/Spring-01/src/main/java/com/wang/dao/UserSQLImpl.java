package com.wang.dao;

public class UserSQLImpl implements UserDao{
    @Override
    public void getUser() {
        System.out.println("SQL用户登录");
    }
}
