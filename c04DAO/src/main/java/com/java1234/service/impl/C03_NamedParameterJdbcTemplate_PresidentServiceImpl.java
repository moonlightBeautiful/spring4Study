package com.java1234.service.impl;


import com.java1234.dao.C03_NamedParameterJdbcTemplate_PresidentDao;
import com.java1234.model.President;
import com.java1234.service.C03_NamedParameterJdbcTemplate_PresidentService;

import java.util.List;

public class C03_NamedParameterJdbcTemplate_PresidentServiceImpl implements C03_NamedParameterJdbcTemplate_PresidentService {

    private C03_NamedParameterJdbcTemplate_PresidentDao presidentDao;

    public void setPresidentDao(C03_NamedParameterJdbcTemplate_PresidentDao presidentDao) {
        this.presidentDao = presidentDao;
    }

    @Override
    public int addPresident(President president) {
        return presidentDao.addPresident(president);
    }

    @Override
    public int updatePresident(President president) {
        return presidentDao.updatePresident(president);
    }

    @Override
    public int deletePresident(int id) {
        return presidentDao.deletePresident(id);
    }

    @Override
    public List<President> findPresidents() {
        return presidentDao.findPresidents();
    }


}
