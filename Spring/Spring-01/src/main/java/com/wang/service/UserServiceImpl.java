package com.wang.service;

import com.wang.dao.UserDao;
import com.wang.dao.UserDaoImpl;

public class UserServiceImpl implements UserService{

    // 私有对象
    private UserDao userDao;
    public String name;

    public UserServiceImpl(String name){
        this.name = name;

    }
    // 通过设置set接口,将主动权交给使用者,让其自己选择使用那个UserDao的子类
    // 注意绑定Spring后,这里的setXXX不能被删除
    public void setUserDao(UserDao userdao) {
        this.userDao = userdao;
    }

    @Override
    public void getUser() {
        this.userDao.getUser();
    }
}
