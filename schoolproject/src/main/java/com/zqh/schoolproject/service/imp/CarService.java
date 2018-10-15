package com.zqh.schoolproject.service.imp;

import com.zqh.schoolproject.dao.CarDao;
import com.zqh.schoolproject.entity.Car;
import com.zqh.schoolproject.service.ICarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarService implements ICarService {
    @Autowired
    CarDao carDao;

    @Override
    public Car Query(int id) {
        return carDao.Query(id);
    }
}
