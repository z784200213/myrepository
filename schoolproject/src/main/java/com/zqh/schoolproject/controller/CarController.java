package com.zqh.schoolproject.controller;

import com.zqh.schoolproject.entity.Car;
import com.zqh.schoolproject.service.ICarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Car")
public class CarController{
    @Autowired
    ICarService carService;
    @RequestMapping("/Query/id={id}")
    public Car Query(@PathVariable  int id){
        return carService.Query(id);
    }
}
