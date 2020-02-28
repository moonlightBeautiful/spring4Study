package com.java1234.JDBC;


import com.java1234.JDBC.service.StudentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        ApplicationContext ac = new ClassPathXmlApplicationContext("c041beans.xml");//加载bean配置文件

        /*
           对DAO的支持：Jdbctemplate作为dao类的属性使用
        */
        //1.jdbctemplate作为dao类的属性使用
        StudentService studentService = (StudentService) ac.getBean("studentService");
        //studentService.addStudent(new Student("李四", 144));
        //studentService.deleteStudent(11);
        //studentService.updateStudent(new Student(2,"李四", 144));
       /* List<Student> studentList=studentService.findStudents();
        for(Student student:studentList){
            System.out.println(student);
        }*/

       /*
           2.JdbcSupport作为dao类的父类使用，JdbcSupport有Jdbctemplate属性
        */
        /*TeacherService teacherService = (TeacherService) ac.getBean("teacherService");
        teacherService.addTeacher(new Teacher("李四", 1));*/

         /*
           3.NamedParameterJdbcTemplate作为dao类的属性使用
        */
       /* PresidentService presidentService = (PresidentService) ac.getBean("presidentService");
        presidentService.addPresident(new President("李四", 1));*/

    }
}
