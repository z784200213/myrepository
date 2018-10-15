package com.springboot004.service.imp;

import com.springboot004.dao.IUserDao;
import com.springboot004.entity.UserInfor;
import com.springboot004.service.IUserInforService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInforService implements IUserInforService {
    @Autowired
    IUserDao dao;
    @Override
    public UserInfor query(int id) {
        return dao.query(id);
    }
}
