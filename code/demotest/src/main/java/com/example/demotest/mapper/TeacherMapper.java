package com.example.demotest.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.example.demotest.entity.Teacher;

import tk.mybatis.mapper.common.Mapper;

@Repository
public interface TeacherMapper extends Mapper<Teacher> {

//	@Select("select * from student where id = #{id}")
//	@ResultMap("studentMap")
//	Student findById(Integer id);
	
	@Select("select * from teacher where name = #{name}")
	List<Teacher> findByName(@Param("name") String name);
	
//	@Insert("insert into student (id, name, memo, state) " + 
//			"values (#{id,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, #{memo,jdbcType=VARCHAR}, #{state,jdbcType=INTEGER})")
//	@Options(keyProperty="student.id",useGeneratedKeys=true)
//	int insert(Student student);
}
