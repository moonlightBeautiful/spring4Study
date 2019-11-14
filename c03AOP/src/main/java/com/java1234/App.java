package com.java1234;

import com.java1234.service.StudentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        //ApplicationContext：IOC容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("springContext.xml");//加载bean配置文件
        StudentService studentService = (StudentService) ac.getBean("studentService");
        studentService.addStudent("张三");
    }
}
