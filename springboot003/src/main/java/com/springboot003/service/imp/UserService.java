package com.springboot003.service.imp;

import com.springboot003.dao.IUserInforDao;
import com.springboot003.entity.User;
import com.springboot003.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    @Autowired
    IUserInforDao userInforDao;
    @Override
    public User query(int id) {
       User u= userInforDao.query(id);
        return u;
    }
}
