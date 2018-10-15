package com.zqh.schoolproject.service.imp;

import com.zqh.schoolproject.dao.UserInfoDao;
import com.zqh.schoolproject.entity.UserInfo;
import com.zqh.schoolproject.service.IUserInforService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInforService implements IUserInforService {
    @Autowired
    UserInfoDao userInfoDao;

    @Override
    public UserInfo Query(int id) {
        return userInfoDao.Query(id);
    }

    @Override
    public UserInfo QueryInculdCar(int id) {
        return userInfoDao.QueryWithCars(id);
    }

    @Override
    public int AddUserInfor(UserInfo userInfo) {
        return userInfoDao.AddUserInfo(userInfo);
    }
}
