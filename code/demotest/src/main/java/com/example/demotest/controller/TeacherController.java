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
import com.example.demotest.entity.Teacher;
import com.example.demotest.mapper.TeacherMapper;

@Controller
@RequestMapping("/teacher")
public class TeacherController {
	
	private static Logger logger = Logger.getLogger(TeacherController.class);
	
	@Resource
	private TeacherMapper teacherMapper;
	
	@RequestMapping(value = "/find_by_name", produces="application/json;text/plain;charset=utf-8")
	@ResponseBody
	public String findByName(String name) {
		System.out.println("----------findByName");
		List<Teacher> teachers = teacherMapper.findByName(name);
		return teachers.toString();
	}
	
	@RequestMapping(value = "/find_by_id", produces="application/json;text/plain;charset=utf-8")
	@ResponseBody
	public String findById(Integer id) {
		System.out.println("----------findById");
		Teacher teacher = teacherMapper.selectByPrimaryKey(id);
//		Student cond = new Student();
//		cond.setId(id);
//		Student student = studentMapper.selectOne(cond);
		return Objects.isNull(teacher) ? null : teacher.toString();
	}
	
	@RequestMapping(value = "/add", produces="application/json;text/plain;charset=utf-8")
	@ResponseBody
	public String add(@RequestBody Teacher teacher) {
		System.out.println("----------add");
		int addInt = teacherMapper.insert(teacher);
		return "添加情况：" + addInt;
	}
	
}
