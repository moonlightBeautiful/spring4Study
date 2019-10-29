package com.java1234.c04jdbc;


import com.java1234.c04jdbc.model.President;
import com.java1234.c04jdbc.service.PresidentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        ApplicationContext ac = new ClassPathXmlApplicationContext("c04JDBC/c04beans.xml");//加载bean配置文件
        /*//jdbctemplate作为dao类的属性使用
        StudentService studentService = (StudentService) ac.getBean("studentService");
        studentService.addStudent(new Student("离开", 1));*/

        /*TeacherService teacherService = (TeacherService) ac.getBean("teacherService");
        teacherService.addTeacher(new Teacher("李四", 1));*/

        PresidentService presidentService = (PresidentService) ac.getBean("presidentService");
        presidentService.addPresident(new President("李四", 1));

    }
}
