package com.cs.ssm.mapper;

import com.cs.ssm.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {

	@Select("select * from user where name=#{name}")
	public User getUserByName(String name);

	@Insert("insert into user values(default, #{name},#{password},#{account},#{createTime})")
	public void addUser(User user);



}
