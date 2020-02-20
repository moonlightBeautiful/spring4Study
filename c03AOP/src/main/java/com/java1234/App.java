package com.java1234;

import com.java1234.service.StudentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        /**
         * xml 切面实现
         *
         * 环绕通知（发生异常时，后半通知不执行）>前置通知>后置通知（发生异常时，照样执行）>异常通知>返回通知
         */
        ApplicationContext ac = new ClassPathXmlApplicationContext("springContext.xml");//加载bean配置文件
        StudentService studentService = (StudentService) ac.getBean("studentService");
        studentService.addStudent("张三");
    }
}
