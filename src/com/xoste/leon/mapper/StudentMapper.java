package com.xoste.leon.mapper;

import com.xoste.leon.pojo.Student;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface StudentMapper {
    @Select("select * from student where tid = #{tid}")
    List<Student> selectByTid(int tid);
}
