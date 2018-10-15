package com.zqh.schoolproject.dao;

import com.zqh.schoolproject.entity.Car;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarDao {
    @Select("select * from car where id=#{id}")
    Car Query(int id);

    @Select("select * from car where user_id=#{id}")
    List<Car> QueryByUserid(int id);
}
