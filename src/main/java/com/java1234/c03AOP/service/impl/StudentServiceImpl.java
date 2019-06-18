package com.java1234.c03AOP.service.impl;


import com.java1234.c03AOP.service.StudentService;

public class StudentServiceImpl implements StudentService {

    @Override
    public void addStudent(String name) {
        // System.out.println("��ʼ���ѧ��"+name);
        System.out.println("添加学生：" + name);
        // System.out.println("���ѧ��"+name+"�����");
    }

}
