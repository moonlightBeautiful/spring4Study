package com.ims.service.impl;


import com.ims.c03NamedParameterJdbcTemplate.dao.PresidentDao;
import com.ims.c03NamedParameterJdbcTemplate.model.President;
import com.ims.service.PresidentService;

import java.util.List;

public class PresidentServiceImpl implements PresidentService {

    private PresidentDao presidentDao;

    public void setPresidentDao(PresidentDao presidentDao) {
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
