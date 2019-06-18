package com.java1234.c04jdbc;


import com.java1234.c04jdbc.model.Student;
import com.java1234.c04jdbc.service.StudentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        ApplicationContext ac = new ClassPathXmlApplicationContext("c04beans.xml");//加载bean配置文件
        /*//jdbctemplate作为dao类的属性使用
        StudentService studentService = (StudentService) ac.getBean("studentService");
        studentService.addStudent(new Student("离开", 1));*/
    }
}
