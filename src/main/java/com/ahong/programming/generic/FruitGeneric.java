package com.ahong.programming.generic;

import java.util.Random;

/**
 * @Description TODO
 * @Author LS-IT
 * @Date 2020/7/14 10:09
 */
public class FruitGeneric implements GenericInterface<String>{

    private String[] fruits = new String[]{"apple","pear","watermelon"};
    @Override
    public String next() {
        Random random = new Random();
        return fruits[random.nextInt(3)];
    }

    public static void main(String[] args) {
        FruitGeneric fruitGeneric = new FruitGeneric();
        for(int i = 0;i<fruitGeneric.fruits.length;i++){
            System.out.println(fruitGeneric.next());
        }
    }
}
