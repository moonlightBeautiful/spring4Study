package com.ims;

import com.ims.c01noAop.service.StudentService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class C01NoAopAppTest {

    @Test
    public void noAopTest() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("c01noAop.xml");
        StudentService studentService = (StudentService) ac.getBean("studentService");
        studentService.addStudent("张三");
    }
}
