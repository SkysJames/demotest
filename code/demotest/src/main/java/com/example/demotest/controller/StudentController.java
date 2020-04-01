package com.example.demotest.controller;

import java.util.List;
import java.util.Objects;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demotest.entity.Student;
import com.example.demotest.mapper.StudentMapper;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	private static Logger logger = Logger.getLogger(StudentController.class);
	
	@Resource
	private StudentMapper studentMapper;
	
	@RequestMapping(value = "/find_by_name", produces="application/json;text/plain;charset=utf-8")
	@ResponseBody
	public String findByName(String name) {
		System.out.println("----------findByName");
		logger.info("-----------hahah,ceshi:....");
		List<Student> students = studentMapper.findByName(name);
		return students.toString();
	}
	
	@RequestMapping(value = "/find_by_id", produces="application/json;text/plain;charset=utf-8")
	@ResponseBody
	public String findById(Integer id) {
		System.out.println("----------findById");
		Student student = studentMapper.selectByPrimaryKey(id);
//		Student cond = new Student();
//		cond.setId(id);
//		Student student = studentMapper.selectOne(cond);
		return Objects.isNull(student) ? null : student.toString();
	}
	
	@RequestMapping(value = "/add", produces="application/json;text/plain;charset=utf-8")
	@ResponseBody
	public String add(@RequestBody Student student) {
		System.out.println("----------add");
		int addInt = studentMapper.insert(student);
		return "添加情况：" + addInt;
	}
	
}
