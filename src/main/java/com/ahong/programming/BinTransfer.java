package com.ahong.programming;

/**
 * @Description 十进制转换为二进制
 * @Author Ricky
 * @Date 2022/3/8 23:14
 */
public class BinTransfer {

    public static void main(String[] args) {
        System.out.println(Math.sqrt(11));
        System.out.println(transferToBin(11));
    }

    public static int transferToBin(int number) {
        int bin = 0;
        int r;//表示余数
        int n = 0;//表示位数
        while (number != 0) {
            r = number % 2;
            number = number / 2;
            bin += r * Math.pow(10, n);
            n++;
        }
        return bin;
    }

}
