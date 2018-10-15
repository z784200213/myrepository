package com.demo.service.imp;

import com.demo.dao.UserInforDao;
import com.demo.entity.Address;
import com.demo.service.IUserInforService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInforService implements IUserInforService {
    @Autowired
    UserInforDao userInforDao;

    @Override
    public Address Query(int id) {
        return userInforDao.Query(id);
    }
}
