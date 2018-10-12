package com.springboot003.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;

@Component
@ConfigurationProperties(prefix = "com.userinfor")
public class UserInfor {
    private  int id;
    private  String name;
    private  int age;
  @Override
    public  String toString(){
      return "UserInfor{" +
              "id=" + id +
              ",age=" + age +
              ", name='" + name + '\'' +
              '}';
  }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

