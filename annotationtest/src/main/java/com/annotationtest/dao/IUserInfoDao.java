package com.annotationtest.dao;

import com.annotationtest.entity.UserInfor;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserInfoDao {
    @Insert("INSERT INTO db_school.user (id, nick_name, address_id)VALUES(#{id},#{nick_name}, " +
            "#{address_id})")
    int Add( UserInfor userInfor);
    @Select("select * from user where id=#{id} ")
    UserInfor Query(int id);
}
