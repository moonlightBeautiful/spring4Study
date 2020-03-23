package com.ims.c03xmlAopTransaction.dao.impl;

import com.ims.c03xmlAopTransaction.dao.BankDao;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

public class BankDaoImpl implements BankDao {

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public void setNamedParameterJdbcTemplate(
            NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    /**
     * 故意t_count写成t_count2，无法转入
     *
     * @param money
     * @param userId
     */
    @Override
    public void inMoney(int money, int userId) {
        // TODO Auto-generated method stub
        //String sql = "update t_count set count=count+:money where userId=:userId";
        String sql = "update t_count2 set money=money+:money where userId=:userId";
        MapSqlParameterSource sps = new MapSqlParameterSource();
        sps.addValue("money", money);
        sps.addValue("userId", userId);
        namedParameterJdbcTemplate.update(sql, sps);
    }

    @Override
    public void outMoney(int money, int userId) {
        // TODO Auto-generated method stub
        String sql = "update t_count set money=money-:money where userId=:userId";
        MapSqlParameterSource sps = new MapSqlParameterSource();
        sps.addValue("money", money);
        sps.addValue("userId", userId);
        namedParameterJdbcTemplate.update(sql, sps);
    }

}
