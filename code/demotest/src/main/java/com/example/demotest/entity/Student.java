package com.example.demotest.entity;

import java.io.Serializable;

import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.ibatis.type.JdbcType;

import tk.mybatis.mapper.annotation.ColumnType;
import tk.mybatis.mapper.annotation.KeySql;
import tk.mybatis.mapper.annotation.NameStyle;
import tk.mybatis.mapper.code.Style;

@Table(name = "student")
@NameStyle(Style.camelhumpAndLowercase)
public class Student implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@KeySql(useGeneratedKeys = true)
	private Integer id;
	
	@ColumnType(column = "name", jdbcType = JdbcType.VARCHAR)
	private String name;
	
	@ColumnType(column = "memo", jdbcType = JdbcType.VARCHAR)
	private String memo;
	
	@ColumnType(column = "state", jdbcType = JdbcType.INTEGER)
	private Integer state;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}
	
	@Override
    public String toString() {
        return "{" +
                "id: " + id +
                ", name: '" + name + "'" +
                ", memo: '" + memo + "'" +
                ", state: " + state +
                '}';
    }
	
}
