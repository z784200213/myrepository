package com.reptile.service;

import com.reptile.entity.UserInfor;

public interface IUserInforService {
    UserInfor query(int id);

    int AddUserInfo(UserInfor info);
}
