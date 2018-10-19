package com.springboot005.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

@Configuration
@ConfigurationProperties(value = "spring.datasource")
public class DataSourceConfig {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDriverclassname() {
        return driverclassname;
    }

    public void setDriverclassname(String driverclassname) {
        this.driverclassname = driverclassname;
    }

    private String url;
    private String username;
    private String password;
    private String driverclassname;
    @Bean(name = "dataSource")
    public ComboPooledDataSource CreateDataSource() throws Exception {
    ComboPooledDataSource dataSource=new ComboPooledDataSource();
    dataSource.setUser(username);
    dataSource.setPassword(password);
    dataSource.setJdbcUrl(url);
    dataSource.setDriverClass(driverclassname);
    return dataSource;
}
}
