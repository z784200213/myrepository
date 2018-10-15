package com.properties.service;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/*@Data
@ConfigurationProperties(prefix = "com.didispace")*/
public class FooProperties {
    public String getFoo() {
        return foo;
    }

    public void setFoo(String foo) {
        this.foo = foo;
    }

    public String getDatabasePlatform() {
        return databasePlatform;
    }

    public void setDatabasePlatform(String databasePlatform) {
        this.databasePlatform = databasePlatform;
    }

    private String foo;

    private String databasePlatform;
}
