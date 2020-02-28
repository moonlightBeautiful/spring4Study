package com.java1234.service;

import com.java1234.model.President;

import java.util.List;

public interface C03_NamedParameterJdbcTemplate_PresidentService {

    public int addPresident(President president);

    public int updatePresident(President president);

    public int deletePresident(int id);

    public List<President> findPresidents();
}
