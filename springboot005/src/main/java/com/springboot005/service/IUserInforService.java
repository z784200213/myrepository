package com.springboot005.service;

import com.springboot005.entity.UserInfor;

import java.util.List;

public interface IUserInforService {
    UserInfor query(int id);
    int delete(int id);
    int update(UserInfor userInfor);
    List<UserInfor>findAll();
    int insert(UserInfor userInfor);
}
