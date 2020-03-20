package com.ims;

import com.ims.c02JdbcDaoSupport.model.Teacher;
import com.ims.c02JdbcDaoSupport.service.TeacherService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Unit test for simple App.
 */
public class C02_JdbcDaoSupportAppTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("c02jdbcDaoSupport.xml");
        TeacherService teacherService = (TeacherService) ac.getBean("studentService");
        teacherService.addTeacher(new Teacher("李四", 144));
        teacherService.deleteTeacher(11);
        teacherService.updateTeacher(new Teacher(2, "李四", 144));
        List<Teacher> teacherList = teacherService.findTeachers();
        for (Teacher teacher : teacherList) {
            System.out.println(teacher);
        }
    }
}
