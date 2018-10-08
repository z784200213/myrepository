package com.reptile.dao;

import com.reptile.entity.UserInfor;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component
public interface IUserInforDao {
    @Select("Select * from user where id=#{id}")
    UserInfor query(int id);
    @Insert("INSERT INTO user (id, name, age)VALUES(#{id},#{name}, " +
            "#{age})")
    int AddUserInfo(UserInfor info);
}
