package com.offcn.service;

import com.offcn.bean.User;
import com.offcn.dao.UserDao;
import com.offcn.dao.UserDaoImpl;

import java.util.List;

public class UserServiceImpl implements UserService{
     UserDao ud= new UserDaoImpl();

    @Override
    public User findUserByUnameAndPw(String username, String password) {
        return ud.UserByUnameAndPw(username,password);
    }

    @Override
    public List<User> selectAllUser() {
        return ud.selectAllUser();
    }

    @Override
    public int insertUser(User user) {
        return ud.insertUser(user);
    }

    @Override
    public User CheckUserName(String username) {
        return ud.CheckUserName(username);
    }
}
