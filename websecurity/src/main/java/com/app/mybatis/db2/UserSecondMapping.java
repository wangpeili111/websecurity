package com.app.mybatis.db2;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.app.mybatis.User;

@Mapper

public interface UserSecondMapping{

	@Select("select * from student where id = #{id}")
	User findUserById(int id);
	@Select("select * from student")
	List<User> findall();
}
