package com.example.demotest.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.example.demotest.entity.Student;

import tk.mybatis.mapper.common.Mapper;

@Repository
public interface StudentMapper extends Mapper<Student> {

//	@Select("select * from student where id = #{id}")
//	@ResultMap("studentMap")
//	Student findById(Integer id);
	
	@Select("select * from student where name = #{name}")
	@ResultMap("studentMap")
	List<Student> findByName(@Param("name") String name);
	
//	@Insert("insert into student (id, name, memo, state) " + 
//			"values (#{id,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, #{memo,jdbcType=VARCHAR}, #{state,jdbcType=INTEGER})")
//	@Options(keyProperty="student.id",useGeneratedKeys=true)
//	int insert(Student student);
}
