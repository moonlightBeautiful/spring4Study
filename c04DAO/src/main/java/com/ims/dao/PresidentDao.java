package com.ims.dao;

import com.ims.c03NamedParameterJdbcTemplate.model.President;

import java.util.List;

/**
 * @author gaoxu
 * @date 2019-06-18 11:28
 * @description ... 类
 */
public interface PresidentDao {
    int addPresident(President president);

    int updatePresident(President president);

    int deletePresident(int id);

    List<President> findPresidents();
}
