package com.offcn.dao;

import com.offcn.bean.User;

import java.util.List;

public interface UserDao {
    User UserByUnameAndPw(String username,String password);
    List<User> selectAllUser();
    int insertUser(User user);
    User CheckUserName(String username);
}
