package com.springboot005.service.imp;

import com.springboot005.dao.IUserInforDao;
import com.springboot005.entity.UserInfor;
import com.springboot005.service.IUserInforService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户操作服务层
 */
@Service
public class UserInforService implements IUserInforService {
    @Autowired
    IUserInforDao userInforDao;

    /**
     * 查询单个用户
     * @param id
     * @return
     */
    @Override
    public UserInfor query(int id) {
        return userInforDao.query(id);
    }

    /**
     * 删除用户
     * @param id
     * @return
     */
    @Override
    public int delete(int id) {
        return userInforDao.delete(id);
    }

    /**
     * 更新用户信息
     * @param userInfor
     * @return
     */
    @Override
    public int update(UserInfor userInfor) {
        return userInforDao.update(userInfor);
    }

    /**
     * 查询所有用户信息
     * @return
     */
    @Override
    public List<UserInfor> findAll() {
        return userInforDao.findAll();
    }

    /**
     * 插入用户信息
     * @param userInfor
     * @return
     */
    @Override
    public int insert(UserInfor userInfor) {
        return userInforDao.insert(userInfor);
    }
}
