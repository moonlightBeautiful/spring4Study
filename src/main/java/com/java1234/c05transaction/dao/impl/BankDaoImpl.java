package com.java1234.c05transaction.dao.impl;

import com.java1234.c05transaction.dao.BankDao;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;


public class BankDaoImpl implements BankDao {

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;


    public void setNamedParameterJdbcTemplate(
            NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public void inMoney(int money, int userId) {
        // TODO Auto-generated method stub
        //故意写错表，转账不进来
        String sql = "update t_count2 set count=count+:money where userId=:userId";
        MapSqlParameterSource sps = new MapSqlParameterSource();
        sps.addValue("money", money);
        sps.addValue("userId", userId);
        namedParameterJdbcTemplate.update(sql, sps);
    }

    @Override
    public void outMoney(int money, int userId) {
        // TODO Auto-generated method stub
        String sql = "update t_count set count=count-:money where userId=:userId";
        MapSqlParameterSource sps = new MapSqlParameterSource();
        sps.addValue("money", money);
        sps.addValue("userId", userId);
        namedParameterJdbcTemplate.update(sql, sps);
    }

}
