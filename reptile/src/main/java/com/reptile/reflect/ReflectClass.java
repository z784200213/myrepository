package com.reptile.reflect;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class ReflectClass<T>  {
    @SuppressWarnings("unchecked")
    public   List<Class<T>> getAllSubclassOfTestInterface(String interfaceName) {
        Field field = null;
        Vector v = null;
        List<Class<T>> allSubclass = new ArrayList<Class<T>>();
                ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        Class<?> classOfClassLoader = classLoader.getClass();
        try {

            Class<T>Tes= (Class<T>) Class.forName(interfaceName);//"com.xxx.xxx.xxx.TestInterface"
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(
                    "无法获取到TestInterface的Class对象!查看包名,路径是否正确");
        }
        while (classOfClassLoader != ClassLoader.class) {
            classOfClassLoader = classOfClassLoader.getSuperclass();
        }
        try {
            field = classOfClassLoader.getDeclaredField("classes");
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(
                    "无法获取到当前线程的类加载器的classes域!");
        }
        field.setAccessible(true);
        try {
            v = (Vector) field.get(classLoader);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(
                    "无法从类加载器中获取到类属性!");
        }
        for (int i = 0; i < v.size(); ++i) {
            Class<?> c = (Class<?>) v.get(i);
            /*if (scmJobClass.isAssignableFrom(c) && !scmJobClass.equals(c) && !abstractScmJobClass
                    .equals(c)) {
                allSubclass.add((Class<ScmJob>) c);
            }*/
        }
        return allSubclass;
    }

}
