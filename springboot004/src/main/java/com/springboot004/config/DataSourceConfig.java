package com.springboot004.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.springboot004.util.AESUtil;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.springboot004.dao")
@ConfigurationProperties(prefix = "spring.datasource")
public class DataSourceConfig {
    private  String url;
    private  String username;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDriverclassname() {
        return driverclassname;
    }

    public void setDriverclassname(String driverclassname) {
        this.driverclassname = driverclassname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private  String driverclassname;
    private  String password;
    //创建一个dataSource对象
 @Bean(name = "dataSource")
 public ComboPooledDataSource createDataSourceBean() throws Exception {
 //创建dataSource对象 并设置属性
 ComboPooledDataSource dataSource = new ComboPooledDataSource();
 dataSource.setDriverClass(driverclassname);
 dataSource.setJdbcUrl(url);
 dataSource.setUser(AESUtil.aesDecrypt(username)); //需要先进行解密工作
 dataSource.setPassword(AESUtil.aesDecrypt(password));
return dataSource;
 }

}
