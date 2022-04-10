package com.ahong.programming.reflex;

/**
 * @Description TODO
 * @Author Ricky
 * @Date 2020/7/27 11:38
 */

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;

/**
 * JVM类加载：ReflexTest.Java——自动编译：ReflexTest.class——ClassLoader和它的子类负责将class文件加载到内存中，并为之自动生成对应的java.lang.Class的对象
 * 反射的三种方式：1.类名.getClass()
 * 2.Class.forName("全路径")
 * 3.类名.class
 * 反射常用的三个类：Constructor、Field、Method
 */
public class ReflexTest {

    public static void main(String[] args) {
        ReflexTest.reflexNewInstance();
        ReflexTest.reflexConstructor();
        ReflexTest.reflexField();
        ReflexTest.reflexInterFace();
    }

    //反射无参构造函数的对象
    public static void reflexNewInstance() {
        try {
            //全类名方式
            Class clazz = Class.forName("com.ahong.programming.reflex.ReflexClass");
            //无参构造函数
            ReflexClass reflexClass = (ReflexClass) clazz.newInstance();
            reflexClass.setId(1);
            reflexClass.setName("反射对象");
            System.out.println(reflexClass.toString());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

    }

    //反射带参数的构造函数对象
    public static void reflexConstructor() {
        Class clazz = ReflexClass.class;
        try {
            Constructor constructor = clazz.getDeclaredConstructor(Integer.class, String.class);
            constructor.setAccessible(true);
            ReflexClass reflexClass = (ReflexClass) constructor.newInstance(1, "反射带有参数的构造方法");
            System.out.println(reflexClass.toString());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    //反射属性
    public static void reflexField() {
        try {
            Class clazz = Class.forName("com.ahong.programming.reflex.ReflexClass");
            ReflexClass reflexClass = (ReflexClass) clazz.newInstance();
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                System.out.println("type:" + field.getGenericType() + ",field:" + field.getName());
            }
            Field field = clazz.getDeclaredField("name");
            field.setAccessible(true);
            field.set(reflexClass, "test");
            System.out.println(reflexClass.toString());
        } catch (ClassNotFoundException | NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

    }

    //反射实现接口的泛型类型
    public static void reflexInterFace() {
        try {
            Class clazz = Class.forName("com.ahong.programming.generic.FruitGeneric");
            String typeName = ((ParameterizedType)clazz.getGenericInterfaces()[0]).getActualTypeArguments()[0].getTypeName();
            System.out.println(typeName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
