package com.xoste.leon.test;

import com.xoste.leon.mapper.TeacherMapper;
import com.xoste.leon.pojo.Teacher;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Test {
    public static void  main(String[] args) throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        SqlSession session = factory.openSession();
        TeacherMapper teacherMapper = session.getMapper(TeacherMapper.class);
        /*List<Teacher> teacherList = teacherMapper.selectAll();
        System.out.println(teacherList);*/

        /*Teacher teacher = new Teacher();
        teacher.setTname("测试");
        int index = teacherMapper.insertTeacher(teacher);
        System.out.println(index)*/;

        /*Teacher teacher = new Teacher();
        teacher.setTid(4);
        teacher.setTname("王五");
        int index = teacherMapper.updateTeacher(teacher);
        System.out.println(index);*/

        /*Teacher teacher = new Teacher();
        teacher.setTid(5);
        int index = teacherMapper.deleteTeacher(teacher);
        System.out.println(index);*/

        List<Teacher> teacherList = teacherMapper.selectTeacher();
        System.out.println(teacherList);
        session.commit();
        session.close();
        System.out.println("程序执行结束");
    }
}
