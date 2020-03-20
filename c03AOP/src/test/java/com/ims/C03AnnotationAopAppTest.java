package com.ims;

import com.ims.c03_annotationAop.service.StudentService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class C03AnnotationAopAppTest {

    @Test
    public void xmlAopTest() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("c03annotationAOP.xml");
        StudentService studentService = (StudentService) ac.getBean("studentService");
        studentService.addStudent("张三");
    }
}
