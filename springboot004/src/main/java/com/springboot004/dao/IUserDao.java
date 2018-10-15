package com.springboot004.dao;

import com.springboot004.entity.UserInfor;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserDao {
    @Select("select * from user where id=#{id}")
    UserInfor query(int id);
}
