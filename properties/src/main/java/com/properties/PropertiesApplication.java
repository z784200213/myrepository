package com.properties;

import com.properties.service.FooProperties;
import com.properties.service.PostInfo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.bind.Bindable;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class PropertiesApplication {

    public static void main(String[] args) {
        ApplicationContext context =   SpringApplication.run(PropertiesApplication.class, args);
        Binder binder = Binder.get(context.getEnvironment());

        // 绑定简单配置
        FooProperties foo = binder.bind("com.test", Bindable.of(FooProperties.class)).get();
        System.out.println(foo.getFoo());

        // 绑定List配置
        List<String> post = binder.bind("com.test.object", Bindable.listOf(String.class)).get();
        System.out.println(post);

        List<PostInfo> posts = binder.bind("com.test.objects", Bindable.listOf(PostInfo.class)).get();
        System.out.println(posts);

        // 读取配置
        System.out.println(context.getEnvironment().containsProperty("com.test.database-platform"));
        System.out.println(context.getEnvironment().containsProperty("com.test.databasePlatform"));
    }
}
