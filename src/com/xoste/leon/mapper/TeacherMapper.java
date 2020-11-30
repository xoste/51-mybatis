package com.xoste.leon.mapper;

import com.xoste.leon.pojo.Teacher;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface TeacherMapper {
    @Select("select * from teacher")
    List<Teacher> selectAll();

    @Insert("insert into teacher values(default,#{tname})")
    int insertTeacher(Teacher teacher);

    @Update("update teacher set tname = #{tname} where tid = #{tid}")
    int updateTeacher(Teacher teacher);

    @Delete("delete from teacher where tid = #{tid}")
    int deleteTeacher(Teacher teacher);

    @Results(value = {
            @Result(id = true, property = "tid", column = "tid"),
            @Result(property = "tname", column = "tname"),
            @Result(property = "listStudent", column = "tid", many = @Many(select = "com.xoste.leon.mapper.StudentMapper.selectByTid"))
    })
    @Select("select * from teacher")
    List<Teacher> selectTeacher();
}
