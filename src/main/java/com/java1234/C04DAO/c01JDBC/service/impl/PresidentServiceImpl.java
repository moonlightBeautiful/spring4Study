package com.java1234.C04DAO.c01JDBC.service.impl;


import com.java1234.C04DAO.c01JDBC.dao.PresidentDao;
import com.java1234.C04DAO.c01JDBC.model.President;
import com.java1234.C04DAO.c01JDBC.service.PresidentService;

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
