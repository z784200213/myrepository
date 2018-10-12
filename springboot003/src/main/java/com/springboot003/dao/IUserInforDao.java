package com.springboot003.dao;

import com.springboot003.entity.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserInforDao {
    @Select("select * from t_user where id=#{id}")
    User query(int id);
}
