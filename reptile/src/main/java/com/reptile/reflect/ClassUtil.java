package com.reptile.reflect;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Enumeration;

public class ClassUtil {
    @SuppressWarnings({"rawtypes", "unchecked"})
    public static ArrayList<Class> getAllClassByInterface(Class clazz) {
        ArrayList<Class> list = new ArrayList<>();
        // 判断是否是一个接口
        if (clazz.isInterface()) {
            try {
                ArrayList<Class> allClass = getAllClass(clazz.getPackage().getName());
                /**
                 * 循环判断路径下的所有类是否实现了指定的接口 并且排除接口类自己
                 */
                for (int i = 0; i < allClass.size(); i++) {
                    /**
                     * 判断是不是同一个接口
                     */
                    // isAssignableFrom:判定此 Class 对象所表示的类或接口与指定的 Class
                    // 参数所表示的类或接口是否相同，或是否是其超类或超接口
                    if (clazz.isAssignableFrom(allClass.get(i))) {
                        if (!clazz.equals(allClass.get(i))) {
                            // 自身并不加进去
                            list.add(allClass.get(i));
                        }
                    }
                }
            } catch (Exception e) {
                System.out.println("出现异常");
            }
        } else {
            // 如果不是接口，则获取它的所有子类
            try {
                ArrayList<Class> allClass = getAllClass(clazz.getPackage().getName());
                /**
                 * 循环判断路径下的所有类是否继承了指定类 并且排除父类自己
                 */
                for (int i = 0; i < allClass.size(); i++) {
                    if (clazz.isAssignableFrom(allClass.get(i))) {
                        if (!clazz.equals(allClass.get(i))) {
                            // 自身并不加进去
                            list.add(allClass.get(i));
                        }
                    }
                }
            } catch (Exception e) {
                System.out.println("出现异常");
            }
        }
        return list;
    }

    /**
     * 从一个指定路径下查找所有的类
     */
    @SuppressWarnings("rawtypes")
    private static ArrayList<Class> getAllClass(String packagename) throws Exception {
        ArrayList<Class> list = new ArrayList<>();
        // 返回对当前正在执行的线程对象的引用。
        // 返回该线程的上下文 ClassLoader。
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

        String path = packagename.replace('.', '/');
        try {
            ArrayList<File> fileList = new ArrayList<>();
            /**
             * 这里面的路径使用的是相对路径 如果大家在测试的时候获取不到，请理清目前工程所在的路径 使用相对路径更加稳定！
             * 另外，路径中切不可包含空格、特殊字符等！
             */
            // getResources:查找所有给定名称的资源
            // 获取jar包中的实现类:Enumeration<URL> enumeration =
            // classLoader.getResources(path);

            Enumeration<URL> enumeration = classLoader.getResources(path);
            while (enumeration.hasMoreElements()) {
                URL url = enumeration.nextElement();
                //String u = url.getFile();
               /* String u1=URLDecoder.decode(u, "UTF-8");
                ArrayList<File> list1=   getFiles(u);*/
                // 获取此 URL 的文件名
                fileList.add(new File(URLDecoder.decode(url.getFile(), "UTF-8")));
            }
            for (int i = 0; i < fileList.size(); i++) {
                list.addAll(findClass(fileList.get(i), packagename));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static ArrayList<File> getFiles(String path) throws Exception {
        //目标集合fileList
        ArrayList<File> fileList = new ArrayList<File>();
        File file = new File("D:\\java\\码云\\reptile\\src\\main\\java\\com\\reptile\\service");
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File fileIndex : files) {
                //如果这个文件是目录，则进行递归搜索
                if (fileIndex.isDirectory()) {
                    getFiles(fileIndex.getPath());
                } else {
                    //如果文件是普通文件，则将文件句柄放入集合中
                    fileList.add(fileIndex);
                }
            }
        }
        return fileList;
    }

    /**
     * 如果file是文件夹，则递归调用findClass方法，或者文件夹下的类 如果file本身是类文件，则加入list中进行保存，并返回
     *
     * @param file
     * @param packagename
     * @return
     */
    @SuppressWarnings("rawtypes")
    private static ArrayList<Class> findClass(File file, String packagename) {
        ArrayList<Class> list = new ArrayList<>();

        if (!file.exists()) {
            return list;
        }
        // 返回一个抽象路径名数组，这些路径名表示此抽象路径名表示的目录中的文件。
        File[] files = file.listFiles();
        for (File file2 : files) {
            if (file2.isDirectory()) {
                // assert !file2.getName().contains(".");// 添加断言用于判断
                if (!file2.getName().contains(".")) {
                    ArrayList<Class> arrayList = findClass(file2, packagename + "." + file2.getName());
                    list.addAll(arrayList);
                }
            } else if (file2.getName().endsWith(".class")) {
                try {
                    // 保存的类文件不需要后缀.class
                    list.add(Class.forName(packagename + '.' + file2.getName().substring(0, file2.getName().length() - 6)));
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
        return list;
    }
}
