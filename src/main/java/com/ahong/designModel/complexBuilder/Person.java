package com.ahong.designModel.complexBuilder;

import lombok.Data;

/**
 * @Description TODO
 * @Author Ricky
 * @Date 2022/3/18 17:53
 */

@Data
public class Person {

    /**
     * 必须
     */
    private final String name;

    /**
     * 必须
     */
    private final String sex;

    private int age;

    private String address;

    public Person(String name, String sex) {
        this.name = name;
        this.sex = sex;
    }

    /**
     * 构造函数个数多的情况可能会传错
     *
     * @param name
     * @param sex
     * @param age
     * @param address
     */
    public Person(String name, String sex, int age, String address) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.address = address;
    }

    /**
     * 使用builder模式
     *
     * @param personBuilder
     */
    public Person(PersonBuilder personBuilder) {
        this.name = personBuilder.getName();
        this.sex = personBuilder.getSex();
        this.age = personBuilder.getAge();
        this.address = personBuilder.getAddress();
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }
}
