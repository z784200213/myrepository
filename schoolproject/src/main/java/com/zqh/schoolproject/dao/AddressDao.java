package com.zqh.schoolproject.dao;

import com.zqh.schoolproject.entity.Address;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressDao {
    @Select("SELECT * FROM address where id = #{id}")
    Address Query(int id);
}
