package com.ahong.designModel.complexBuilder;

/**
 * @Description TODO
 * @Author Ricky
 * @Date 2022/3/18 17:59
 */
public class ComplexMainTest {

    public static void main(String[] args) {
        Person person = PersonBuilder.newPerson()
                .setName("Ricky")
                .setAge(25)
                .setAddress("广东汕头")
                .setSex("male")
                .build();
        System.out.println(person);
    }

}
