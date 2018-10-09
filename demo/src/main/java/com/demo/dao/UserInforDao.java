package com.demo.dao;

import com.demo.entity.Address;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInforDao {
    @Select("SELECT * FROM address where id = #{id}")
    Address Query(int id);
}
