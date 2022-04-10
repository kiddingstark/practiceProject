package com.ahong.programming;

/**
 * @Description TODO
 * @Author Ricky
 * @Date 2022/3/15 11:47
 */
public class Factorial {

    public static void main(String[] args) {
        System.out.println(factorial(4));
    }

    public static int factorial(int number) {
        if (number != 0) {
            return number * factorial(number - 1);
        }
        return 1;
    }
}
