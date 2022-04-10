package com.ahong.jvm;

/**
 * @Description 栈帧的组成之一：局部变量表，是一个数字数组，存放方法内的变量
 * @Author Ricky
 * @Date 2021/10/13 2:39
 */
public class LocalVariablesTest {

    private int i = 0;

    private static int staticI = 0;

    public static void main(String[] args) {
        LocalVariablesTest localVariablesTest = new LocalVariablesTest();
        int number = 0;
        System.out.println("我是局部变量表的main函数...");
        //该main方法的局部变量表是一个长度为3的数字数组，存放三个参数
    }

    public void method1() {
        //this是一个变量，会放在局部变量表的第一个中
        int i = 0;
        System.out.println(this.i);
    }

    public static void staticTest() {
        LocalVariablesTest localVariablesTest = new LocalVariablesTest();
        int i = 0;
        //静态方法没有将this压入局部变量表，所以不能使用this
        //System.out.println(this.i);
    }
}
