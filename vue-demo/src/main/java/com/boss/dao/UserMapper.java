package com.boss.dao;

import com.boss.pojo.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author LGX_TvT
 * @date 2019-12-04 16:23
 */
@Mapper
public interface UserMapper {

    @Select("select * from user where name = #{name}")
    public User getUserByName(String name);


    @Select("select * from user")
    public List<User> getAllUser();

    @Select("select * from user where name like CONCAT('%',#{data},'%')")
    public List<User> searchUser(String data);

    @Insert("insert into user values(#{id}, #{name}, #{password}, #{age})")
    public Integer insertUser(User user);

    @Delete("delete from user where id = #{id}")
    public Integer deleteUserById(String id);

    @Update("update user set name = #{name}, password=#{password}, age=#{age} where id = #{id}")
    public Integer updateUser(User user);

    @Update("update user set name = #{name}, age=#{age} where id = #{id}")
    public Integer updateUserExcludePassword(User user);

    @Select("select * from user where id = #{id}")
    public User getUserById(String id);



}
