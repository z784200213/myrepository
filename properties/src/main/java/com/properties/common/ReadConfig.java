package com.properties.common;

import com.properties.service.ApplicationContextUtils;
import com.properties.service.FooProperties;
import com.properties.service.PostInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.Bindable;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class ReadConfig {
    @Autowired
    ApplicationContextUtils applicationContextUtils;
    public   <T> T  read(String name,Class<T>tClass){
        T t=null;

        Binder binder=getBinder();
        t=  binder.bind(name,Bindable.of(tClass)).get();
        return t;

        /*// 绑定简单配置
        FooProperties foo = binder.bind("com.didispace", Bindable.of(FooProperties.class)).get();
        System.out.println(foo.getFoo());

        // 绑定List配置
        List<String> post = binder.bind("com.didispace.post", Bindable.listOf(String.class)).get();
        System.out.println(post);

        List<PostInfo> posts = binder.bind("com.didispace.posts", Bindable.listOf(PostInfo.class)).get();
        System.out.println(posts);

        // 读取配置
        System.out.println(context.getEnvironment().containsProperty("com.didispace.database-platform"));
        System.out.println(context.getEnvironment().containsProperty("com.didispace.databasePlatform"));*/
    }
    public <T> List<T>reads(String name,Class<T>tClass){
        List<T>ts=null;
        Binder binder=getBinder();
        ts=binder.bind(name,Bindable.listOf(tClass)).get();
        return ts;
    }
    private  Binder getBinder(){
        ApplicationContext context=applicationContextUtils.getContext();
        Binder binder=Binder.get(context.getEnvironment());
        return binder;
    }
    public  List<PostInfo>getPostinfos(){
        ApplicationContext context=applicationContextUtils.getContext();
        Binder binder=Binder.get(context.getEnvironment());
        List<PostInfo> posts = binder.bind("com.test.objects", Bindable.listOf(PostInfo.class)).get();
        return posts;
    }
}
