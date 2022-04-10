package com.ahong.aop;

/**
 * 简单模拟AOP实现，核心还是注入一个对象当做属性。与观察者模式中注入观察者当做属性一样
 * 缺点：如果有不同的要代理对象如UserDao、RoleDao、MenuDao，就要生成很多相应的代理类，被代理类新增了一个方法，则所有的代理类都要针对这个方法进行复写代理
 */
public class AopDiyProxyTest implements UserDao{

    private UserDao userDao;

    /**
     * UserDao对象是基于AopProxyTest这个代理对象创建的
     * @param userDao
     */
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }


    @Override
    public void saveUser() {
        System.out.println("记录日志前");
        userDao.saveUser();
        System.out.println("记录日志后");
    }

    @Override
    public void updateUser() {
        System.out.println("记录日志前");
        userDao.updateUser();
        System.out.println("记录日志后");
    }

    public static void main(String[] args) {
        AopDiyProxyTest aopDiyProxyTest = new AopDiyProxyTest();
        aopDiyProxyTest.setUserDao(new UserDaoImpl());
        aopDiyProxyTest.saveUser();
    }
}
