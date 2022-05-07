package com.offcn.dao;

import com.offcn.bean.Country;
import com.offcn.utile.UserUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class CountryDaoImpl implements CountryDao{
    @Override
    public List<Country> selectCountry() {
        List<Country> list=null;
        QueryRunner qr = new QueryRunner(UserUtils.getDataSource());
        String sql="select * from country";
        try {
            list=qr.query(sql,new BeanListHandler<>(Country.class));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }
}
