package com.ahong.programming.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 泛型类与泛型方法
 * @Author Ricky
 * @Date 2020/7/14 10:20
 */
public class GenericTest<T> {
    //=======================================================================================================
    public void show_1(T t) {
        System.out.println(t.toString());
    }

    //泛型方法单独声明泛型，类上无须声明泛型
    //在泛型类中声明了一个泛型方法，使用泛型E，这种泛型E可以为任意类型。可以类型与T相同，也可以不同。
    //由于泛型方法在声明的时候会声明泛型<E>，因此即使在泛型类中并未声明泛型，编译器也能够正确识别泛型方法中识别的泛型。
    public <E> void show_3(E t) {
        System.out.println(t.toString());
    }

    //在泛型类中声明了一个泛型方法，使用泛型T，注意这个T是一种全新的类型，可以与泛型类中声明的T不是同一种类型。
    public <T> void show_2(T t) {
        System.out.println(t.toString());
    }

    //静态方法要使用类上的泛型，必须是一个泛型方法
    public static <T> void show_4(T t){
        System.out.println(t.toString());
    }

    //=======================================================================================================
    //泛型的无界、上界、下界：限制传入的范围,?表示一个不确切的类型，而T表示一个确切的类型
    public static void testBird (List<? extends Animal> animals){
        for(Animal animal:animals){
            System.out.println(animal.getName());
        }
    }

    public static void testAnimal (List<Animal> animals){
        for(Animal animal:animals){
            System.out.println(animal.getName());
        }
    }

    //=======================================================================================================
    public static void main(String[] args) {
        GenericTest<String> generateTest1 = new GenericTest<String>();
        generateTest1.show_1("类上定义好的String泛型");
        generateTest1.show_2("泛型方法，此处可以出入一个不同于String的全新类型");
        generateTest1.show_3(123456);
        GenericTest.show_4(123456);

        List<Animal> animalList = new ArrayList<Animal>();
        List<Bird> birdList = new ArrayList<Bird>();
        animalList.add(new Animal("animal",1));
        birdList.add(new Bird("bird",1));
        GenericTest.testAnimal(animalList);
        GenericTest.testBird(animalList);
        //List<Animal>跟List<Bird>之间没有继承关系，List<Animal>跟List<? extends Animal>才有继承关系
        //GenericTest.testAnimal(birdList);
        GenericTest.testBird(birdList);


    }
}
class Animal{
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

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
class Bird extends Animal{

    public Bird(String name, int age) {
        super(name, age);
    }
}