package com.zqh.schoolproject.service.imp;

import com.zqh.schoolproject.dao.AddressDao;
import com.zqh.schoolproject.entity.Address;
import com.zqh.schoolproject.service.IAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService implements IAddressService {
    @Autowired
    AddressDao addressDao;

    @Override
    public Address Query(int id) {
        return addressDao.Query(id);
    }
}
