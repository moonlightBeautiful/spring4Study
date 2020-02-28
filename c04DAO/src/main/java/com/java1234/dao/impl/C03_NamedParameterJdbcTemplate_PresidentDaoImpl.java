package com.java1234.dao.impl;

import com.java1234.dao.C03_NamedParameterJdbcTemplate_PresidentDao;
import com.java1234.model.President;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author gaoxu
 * @date 2019-06-18 11:34
 * @description ... 类
 */
public class C03_NamedParameterJdbcTemplate_PresidentDaoImpl implements C03_NamedParameterJdbcTemplate_PresidentDao {

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public void setNamedParameterJdbcTemplate(
            NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public int addPresident(President president) {
        String sql = "insert into t_president values(null,:name,:age)";
        MapSqlParameterSource sps = new MapSqlParameterSource();
        sps.addValue("name", president.getName());
        sps.addValue("age", president.getAge());
        return namedParameterJdbcTemplate.update(sql, sps);
    }

    @Override
    public int updatePresident(President president) {
        String sql = "update t_president set name=:name,age=:age where id=:id";
        MapSqlParameterSource sps = new MapSqlParameterSource();
        sps.addValue("name", president.getName());
        sps.addValue("age", president.getAge());
        sps.addValue("id", president.getId());
        return namedParameterJdbcTemplate.update(sql, sps);
    }

    @Override
    public int deletePresident(int id) {
        String sql = "delete from t_president where id=:id";
        MapSqlParameterSource sps = new MapSqlParameterSource();
        sps.addValue("id", id);
        return namedParameterJdbcTemplate.update(sql, sps);
    }

    @Override
    public List<President> findPresidents() {
        String sql = "select * from t_president";
        final List<President> presidentList = new ArrayList<President>();
        namedParameterJdbcTemplate.query(sql, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet rs) throws SQLException {
                President president = new President();
                president.setId(rs.getInt("id"));
                president.setName(rs.getString("name"));
                president.setAge(rs.getInt("age"));
                presidentList.add(president);
            }
        });
        return presidentList;
    }
}
