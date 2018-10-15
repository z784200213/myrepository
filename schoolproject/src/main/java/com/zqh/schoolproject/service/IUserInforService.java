package com.zqh.schoolproject.service;

import com.zqh.schoolproject.entity.UserInfo;

public interface IUserInforService {
    UserInfo Query(int id);

    UserInfo QueryInculdCar(int id);

    int AddUserInfor(UserInfo userInfo);
}
