package com.zqh.schoolproject.controller;

import com.zqh.schoolproject.entity.Address;
import com.zqh.schoolproject.service.IAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Address")
public class AddressController {
    @Autowired
    IAddressService addressService;
    @RequestMapping("/Query/id={id}")
    public Address Query(@PathVariable int id){
        return addressService.Query(id);
    }
}
