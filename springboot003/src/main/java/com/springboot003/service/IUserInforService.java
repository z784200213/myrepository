package com.springboot003.service;

import com.springboot003.entity.UserInfor;

import java.util.List;

public interface IUserInforService {
    UserInfor query(int id);
    List<UserInfor>queryList();
}
