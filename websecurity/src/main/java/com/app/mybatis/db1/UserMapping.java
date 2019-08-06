package com.app.mybatis.db1;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.app.security.bean.Users;



@Mapper

public interface UserMapping{

	@Select("select * from users where id = #{id}")
	Users findUserById(int id);
	@Select("select * from users")
	List<Users> findall();
}
