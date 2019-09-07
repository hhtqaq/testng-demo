package com.ecjtu.hht.testngdemo.mapper;

import com.ecjtu.hht.testngdemo.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author hht
 * @date 2019/9/7 11:05
 */
@Mapper
public interface StudentMapper {
    @Select("select * from student")
    List<Student> getAllStudents();

    @Select("select * from student where id=#{id}")
    Student getStudentById(Integer id);
}
