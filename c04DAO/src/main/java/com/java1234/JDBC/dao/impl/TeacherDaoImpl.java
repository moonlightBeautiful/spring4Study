package com.java1234.JDBC.dao.impl;

import com.java1234.JDBC.dao.TeacherDao;
import com.java1234.JDBC.model.Teacher;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author gaoxu
 * @date 2019-06-18 11:34
 * @description ... 类
 */
public class TeacherDaoImpl extends JdbcDaoSupport implements TeacherDao {


    @Override
    public int addTeacher(Teacher teacher) {
        String sql = "insert into t_teacher values(null,?,?)";
        Object[] params = new Object[]{teacher.getName(), teacher.getAge()};
        return this.getJdbcTemplate().update(sql, params);
    }

    @Override
    public int updateTeacher(Teacher teacher) {
        String sql = "update t_teacher set name=?,age=? where id=?";
        Object[] params = new Object[]{teacher.getName(), teacher.getAge(), teacher.getId()};
        return this.getJdbcTemplate().update(sql, params);
    }

    @Override
    public int deleteTeacher(int id) {
        String sql = "delete from t_teacher where id=?";
        Object[] params = new Object[]{id};
        return this.getJdbcTemplate().update(sql, params);
    }

    @Override
    public List<Teacher> findTeachers() {
        String sql = "select * from t_teacher";
        final List<Teacher> teacherList = new ArrayList<Teacher>();
        this.getJdbcTemplate().query(sql, new RowCallbackHandler() {

            @Override
            public void processRow(ResultSet rs) throws SQLException {
                Teacher teacher = new Teacher();
                teacher.setId(rs.getInt("id"));
                teacher.setName(rs.getString("name"));
                teacher.setAge(rs.getInt("age"));
                teacherList.add(teacher);
            }

        });
        return teacherList;
    }
}
