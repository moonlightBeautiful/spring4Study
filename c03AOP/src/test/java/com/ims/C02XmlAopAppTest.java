package com.ims;

import com.ims.c02_xmlAop.service.StudentService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class C02XmlAopAppTest {

    @Test
    public void xmlAopTest() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("c02xmlAop.xml");
        StudentService studentService = (StudentService) ac.getBean("studentService");
        studentService.addStudent("张三");
    }
}
