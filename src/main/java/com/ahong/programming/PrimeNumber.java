package com.ahong.programming;

import org.junit.Test;

/**
 * @author zhengruihong
 * 输出101到200中的素数
 */
public class PrimeNumber {
    @Test
    public void test() {
        int number = 101;
        int primeNumber = 0;
        first:
        for (; number <= 200; number = number + 2) {
            second:
            for (int i = 2; i <= number; i++) {
                if (number % i != 0) {
                    continue;
                }
                if (i == number) {//被自身整除
                    primeNumber++;
                    System.out.println("素数：" + number);
                } else {
                    break second;
                }
            }
        }
        System.out.println("素数个数：" + primeNumber);
    }
}
