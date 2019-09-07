package com.ecjtu.hht.testngdemo.controller;

import com.ecjtu.hht.testngdemo.entity.Student;
import com.ecjtu.hht.testngdemo.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author hht
 * @date 2019/9/7 11:06
 */
@RestController
public class StudentController {
    @Autowired
    private StudentMapper mapper;

    @RequestMapping("/student/list")
    public List<Student> getStudents() {
        return mapper.getAllStudents();
    }

    @RequestMapping("/student/get")
    public Student getStudentById(@RequestParam Integer id) {
        return mapper.getStudentById(id);
    }
}
