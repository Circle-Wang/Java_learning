package com.wang.dao;

public class UserOracleImpl implements UserDao{
    @Override
    public void getUser() {
        System.out.println("Oracle用户登录");
    }
}
