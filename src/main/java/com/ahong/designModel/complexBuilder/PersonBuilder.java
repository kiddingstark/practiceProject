package com.ahong.designModel.complexBuilder;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @Description TODO
 * @Author Ricky
 * @Date 2022/3/18 17:56
 */

@Data
@Accessors(chain = true)
public class PersonBuilder implements Serializable {

    private String name;

    private String sex;

    private int age;

    private String address;

    public PersonBuilder() {

    }

    public PersonBuilder(String name, String sex) {
        this.name = name;
        this.sex = sex;
    }

    public static PersonBuilder newPerson() {
        return new PersonBuilder();
    }

    public Person build() {
        return new Person(this);
    }
}
