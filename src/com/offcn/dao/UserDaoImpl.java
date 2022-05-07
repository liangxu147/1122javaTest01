package com.offcn.dao;

import com.offcn.bean.User;
import com.offcn.utile.UserUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl  implements UserDao{
    @Override
    public User UserByUnameAndPw(String username, String password) {
        User user=null;
        QueryRunner qr = new QueryRunner(UserUtils.getDataSource());
        String sql="select * from user where username = ? and password = ? ";
        try {
            user=qr.query(sql,new BeanHandler<>(User.class),username,password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return user;
    }

    @Override
    public List<User> selectAllUser() {
        //创建集合
        List<User> list=null;
        QueryRunner qr = new QueryRunner(UserUtils.getDataSource());
        String sql = "select * from user";
        try {
            list=qr.query(sql,new BeanListHandler<>(User.class));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    @Override
    public int insertUser(User user) {
        int result=0;
        QueryRunner qr = new QueryRunner(UserUtils.getDataSource());
        String sql="insert into user value(null,?,?,?,?,?)";
        try {
            result=qr.update(sql,user.getUsername(),user.getPassword(),user.getName(),user.getTelephone(),user.getBirthday());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }

    @Override
    public User CheckUserName(String username) {
        User user = null;
        QueryRunner qr = new QueryRunner(UserUtils.getDataSource());
        String sql = "select * from user where username = ?";
        try {
            user = qr.query(sql, new BeanHandler<>(User.class), username);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return user;

    }
}
