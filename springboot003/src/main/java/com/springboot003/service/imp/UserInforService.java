package com.springboot003.service.imp;

import com.springboot003.entity.UserInfor;
import com.springboot003.service.IUserInforService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInforService implements IUserInforService {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Override
    public UserInfor query(int id) {
        String sql="select * from user where id=?";
        UserInfor userInfor= jdbcTemplate.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<>(UserInfor.class));
        return userInfor;
    }

    @Override
    public List<UserInfor> queryList() {
        return null;
    }
}
