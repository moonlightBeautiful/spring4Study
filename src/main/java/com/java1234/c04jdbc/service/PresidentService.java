package com.java1234.c04jdbc.service;

import com.java1234.c04jdbc.model.President;
import com.java1234.c04jdbc.model.Student;

import java.util.List;

public interface PresidentService {

    public int addPresident(President president);

    public int updatePresident(President president);

    public int deletePresident(int id);

    public List<President> findPresidents();
}
