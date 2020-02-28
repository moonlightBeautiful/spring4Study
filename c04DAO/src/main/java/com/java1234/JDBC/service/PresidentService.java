package com.java1234.JDBC.service;

import com.java1234.JDBC.model.President;

import java.util.List;

public interface PresidentService {

    public int addPresident(President president);

    public int updatePresident(President president);

    public int deletePresident(int id);

    public List<President> findPresidents();
}