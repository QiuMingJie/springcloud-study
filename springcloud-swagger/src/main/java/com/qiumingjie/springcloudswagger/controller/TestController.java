package com.qiumingjie.springcloudswagger.controller;

import com.qiumingjie.springcloudswagger.dto.Student;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author QiuMingJie
 * @date 2020-03-31 20:37
 * @description
 */
@RequestMapping("/teset")
@RestController
@Api("测试控制层")
public class TestController {

    @ApiOperation("演示接口")
    @GetMapping("/getTest")
    public String swagger() {
        return "测试";
    }

    @ApiOperation("获取学生接口")
    @ApiImplicitParam(name = "student", value = "学生", required = true, dataType = "Student")
    @PostMapping("/getStudent")
    public Student getStudent(Student student) {
        Student student1 = new Student();
        student1.setId("123");
        student1.setName("fds");
        return student1;
    }
}
