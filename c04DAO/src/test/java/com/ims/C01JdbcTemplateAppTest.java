package com.ims;

import com.ims.c01JdbcTemplate.model.Student;
import com.ims.c01JdbcTemplate.service.StudentService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Unit test for simple App.
 */
public class C01JdbcTemplateAppTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("c01jdbcTemplate.xml");
        StudentService studentService = (StudentService) ac.getBean("studentService");
        studentService.addStudent(new Student("李四", 144));
        studentService.deleteStudent(11);
        studentService.updateStudent(new Student(2, "李四", 144));
        List<Student> studentList = studentService.findStudents();
        for (Student student : studentList) {
            System.out.println(student);
        }
    }
}
