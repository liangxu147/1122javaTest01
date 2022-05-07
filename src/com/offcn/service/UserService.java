package com.offcn.service;

import com.offcn.bean.User;

import java.util.List;

public interface UserService {
    User findUserByUnameAndPw(String username, String password);
    List<User> selectAllUser();
    int insertUser(User user);
    User CheckUserName(String username);
}
