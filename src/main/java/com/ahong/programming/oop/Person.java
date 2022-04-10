package com.ahong.programming.oop;

/**
 * @Description
 * @Author Ricky
 * @Date 2020/9/3 14:50
 */
public class Person {

    private String name;

    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void eat(){
        System.out.println("Person is eating!");
    }

    //私有变量方法不能被对象调用不能被继承，只能在本类中使用，否则会打破封装性
    private void privateTest(){
        System.out.println("Person is privateTest!");
    }

    public static void main(String[] args) {
        Person p = new Student();
        p.eat();//调用的是Student的eat方法
        p.privateTest();//私有方法不能被覆盖，所以这里只能调用到Person自己的私有方法
    }
}
