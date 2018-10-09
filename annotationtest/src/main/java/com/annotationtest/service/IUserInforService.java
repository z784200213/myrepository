package com.annotationtest.service;

import com.annotationtest.entity.UserInfor;
import org.apache.ibatis.annotations.Insert;
import org.springframework.cache.annotation.Cacheable;

public interface IUserInforService {
    int Add(UserInfor userInfor);

    UserInfor Query(int id);
}
