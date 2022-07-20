package com.itheima.mapper;

import com.itheima.poij.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    @Select("select * from tb_user where user_name=#{userName} and password=#{password}")
    @ResultMap("UserResultMap")
    User login(User user);

    /*判断用户名是否存在*/
    @ResultMap("UserResultMap")
    @Select("select * from tb_user where user_name=#{userName}")
    User selectByName(String userName);

    /*新增用户*/
    @Insert("insert into tb_user values (#{id}, #{userName}, #{password})")
    void addUser(User user);
}
