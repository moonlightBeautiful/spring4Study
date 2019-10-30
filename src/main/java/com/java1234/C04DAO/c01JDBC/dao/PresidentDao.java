package com.java1234.C04DAO.c01JDBC.dao;

import com.java1234.C04DAO.c01JDBC.model.President;

import java.util.List;

/**
 * @author gaoxu
 * @date 2019-06-18 11:28
 * @description ... 类
 */
public interface PresidentDao {
    public int addPresident(President president);

    public int updatePresident(President president);

    public int deletePresident(int id);

    public List<President> findPresidents();
}
