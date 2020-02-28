package com.java1234;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        /**
         * 无AOP，手动做日志，严重侵入代码
         */
       /* ApplicationContext ac = new ClassPathXmlApplicationContext("01noAOP.xml");
        StudentService studentService = (StudentService) ac.getBean("studentService");
        studentService.addStudent("张三");*/


        /**
         * xml AOP
         */
       /* ApplicationContext ac = new ClassPathXmlApplicationContext("02xmlAOP.xml");
        StudentService studentService = (StudentService) ac.getBean("studentService");
        studentService.addStudent("张三");*/


        /**
         * 注解 AOP
         */
       /* ApplicationContext ac = new ClassPathXmlApplicationContext("03annotationAOP.xml");
        StudentService studentService = (StudentService) ac.getBean("studentService");
        studentService.addStudent("张三");*/

    }
}
