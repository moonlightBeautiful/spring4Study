package com.java1234;


/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        /**
         * spring对DAO的支持1：Jdbctemplate作为dao实现类的属性使用
         */
       /* ApplicationContext ac = new ClassPathXmlApplicationContext("01jdbcTemplate.xml");
        C01_JdbcTemplate_StudentService studentService = (C01_JdbcTemplate_StudentService) ac.getBean("studentService");*/
        //studentService.addStudent(new Student("李四", 144));
        //studentService.deleteStudent(11);
        //studentService.updateStudent(new Student(2,"李四", 144));
        /* List<Student> studentList=studentService.findStudents();
        for(Student student:studentList){
            System.out.println(student);
        }*/

        /**
         * spring对DAO的支持2：JdbcSupport作为dao类的父类使用，JdbcSupport有Jdbctemplate属性
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
