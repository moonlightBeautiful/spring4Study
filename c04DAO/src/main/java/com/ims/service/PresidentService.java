package com.ims.service;

import com.ims.c03NamedParameterJdbcTemplate.model.President;

import java.util.List;

public interface PresidentService {

    public int addPresident(President president);

    public int updatePresident(President president);

    public int deletePresident(int id);

    public List<President> findPresidents();
}
