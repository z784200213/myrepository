package com.springboot005.util;

import java.lang.reflect.Field;

public class ReflactClass<T> {
    public   Object getIntanceFieldvale(T t,String fieldname) throws NoSuchFieldException, IllegalAccessException {
        Object o=t.getClass();
        Field field=t.getClass().getDeclaredField(fieldname);
        field.setAccessible(true);
        Object object= field.get(t);
        return  object;
    }
    public  void  getInstanceMethodvalue(T t,String methodname) throws NoSuchMethodException {
        t.getClass().getDeclaredMethod(methodname,null);
    }
}
