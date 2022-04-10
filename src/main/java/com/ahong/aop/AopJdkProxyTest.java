package com.ahong.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 基于JDK的动态代理：被代理的类需要有接口实现
 *
 * 优点：通过反射解决多个代理对象的问题，无须关心被代理对象时是哪个类型，统一设置为Object类型
 */
public class AopJdkProxyTest implements InvocationHandler{

    //1、注入一个要处理的对象
    private Object delegate;

    //2、通过要处理的对象生成一个代理对象:相当于绑定
    public Object bind(Object delegate) {
        this.delegate = delegate;
        return Proxy.newProxyInstance(
                this.delegate.getClass().getClassLoader(), this.delegate
                        .getClass().getInterfaces(), this);
        //3、第三个参数指定调用代理对象时，实际上调用的是下面的invoke方法
    }


    //绑定后调用要处理对象的方法是通过这里的反射调用的
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        try {
            System.out.println("记录日志前");
            //JVM通过这条语句执行原来的方法(反射机制)
            result = method.invoke(this.delegate, args);
            System.out.println("记录日志后");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void main(String[] args) {
        AopJdkProxyTest aopJdkProxyTest = new AopJdkProxyTest();
        UserDao userDao = (UserDao) aopJdkProxyTest.bind(new UserDaoImpl());
        userDao.saveUser();
        userDao.updateUser();
    }
}
