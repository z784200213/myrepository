package com.zqh.schoolproject.dao;

import com.zqh.schoolproject.entity.UserInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Repository

public interface UserInfoDao {

    @Select("SELECT * FROM user where id = #{id}")
    @Results({
            @Result(property = "address", column = "address_id",
                    one = @One(select = "com.zqh.schoolproject.dao.AddressDao.Query"))
    })
    UserInfo Query(int id);

    @Select("SELECT * FROM user where id = #{id}")
    @Results({
            @Result(property = "cars", column = "id",
                    one = @One(select = "com.zqh.schoolproject.dao.CarDao.QueryByUserid"))
    })
    UserInfo QueryWithCars(int id);

    @Insert("INSERT INTO db_school.user (id, nick_name, address_id)VALUES(#{id},#{nick_name}, " +
            "#{address_id})")
    int AddUserInfo(UserInfo info);
}
