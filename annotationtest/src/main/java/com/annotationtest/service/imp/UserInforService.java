package com.annotationtest.service.imp;

import com.annotationtest.dao.IUserInfoDao;
import com.annotationtest.entity.UserInfor;
import com.annotationtest.service.IUserInforService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class UserInforService implements IUserInforService {
    @Autowired
    IUserInfoDao userInfoDao;

    @Override
    public int Add(UserInfor userInfor) {
        return userInfoDao.Add(userInfor);
    }

    @Cacheable(key = "id")
    @Override
    public UserInfor Query(int id) {
        return userInfoDao.Query(id);
    }
}
