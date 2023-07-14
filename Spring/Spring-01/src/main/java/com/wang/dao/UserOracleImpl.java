package com.wang.dao;

public class UserOracleImpl implements UserDao{
    @Override
    public void getUser() {
        System.out.println("Oracley用户登录");
    }
}
