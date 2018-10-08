package com.reptile.service.imp;

import com.reptile.dao.IUserInforDao;
import com.reptile.entity.UserInfor;
import com.reptile.service.IUserInforService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInforService implements IUserInforService {
    @Autowired
    IUserInforDao userInforDao;
    @Override
    public UserInfor query(int id) {
        return userInforDao.query(id);
    }

    @Override
    public int AddUserInfo(UserInfor info) {
        return userInforDao.AddUserInfo(info);
    }
}
