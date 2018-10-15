package com.zqh.schoolproject.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.validation.constraints.Null;
import java.io.Serializable;
import java.util.List;

//@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class UserInfo implements Serializable {
    public int id;
    public String nick_name;
    public int address_id;

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> cars;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    private Address address;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNick_name() {
        return nick_name;
    }

    public void setNick_name(String nick_name) {
        this.nick_name = nick_name;
    }

    public int getAddress_id() {
        return address_id;
    }

    public void setAddress_id(int address_id) {
        this.address_id = address_id;
    }
}
