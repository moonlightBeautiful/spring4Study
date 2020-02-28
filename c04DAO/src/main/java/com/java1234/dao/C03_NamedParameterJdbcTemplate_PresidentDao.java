package com.java1234.dao;

import com.java1234.model.President;

import java.util.List;

/**
 * @author gaoxu
 * @date 2019-06-18 11:28
 * @description ... 类
 */
public interface C03_NamedParameterJdbcTemplate_PresidentDao {
    public int addPresident(President president);

    public int updatePresident(President president);

    public int deletePresident(int id);

    public List<President> findPresidents();
}
