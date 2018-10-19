package com.springboot005.dao;

import com.springboot005.entity.UserInfor;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IUserInforDao {
    @Select("select * from user where id=#{id}")
    UserInfor query(int id);
    @Delete("delete from user where id=#{id}")
    int delete(int id);
    @Update("update user set name=#{name},age=#{age} where id=#{id}")
    int update(UserInfor userInfor);
    @Select("select * from user")
    List<UserInfor> findAll();
    @Insert("insert into user(id,name,age) values (#{id},#{name},#{age})")
    int insert(UserInfor userInfor);
}
