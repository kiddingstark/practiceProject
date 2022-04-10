package com.ahong.jvm;

/**
 * @Description TODO
 * @Author Ricky
 * @Date 2021/10/11 23:51
 */
public class ClinitTest {

    //一开始编译后的class文件中的常量池存放所有信息
    //加载到内存模式中时，常量池的静态变量以及字符串常量池放在堆中，其它普通变量放方法区的运行时常量池

    private static int i = 1;//ClassLoader阶段会加载类变量，对应的是字节码中的clinit方法.类变量放在堆中而不是方法区的运行时常量池中


    private int j = 2;//变量存放方法区的运行时常量池中


    static {
        i = 5;//ClassLoader阶段会加载静态代码块，对应的是字节码中的clinit方法
    }

    public ClinitTest() {//ClassLoader阶段会加载类的构造器，对应的是字节码中的init方法
        i = i + 1;
    }

    public static void main(String[] args) {
        ClinitTest clinitTest = new ClinitTest();
        clinitTest.method();
    }

    public void method() {
        //栈帧中的本地变量表要用到的话就跟方法区中的运行时常量池拿数据
        //这里本地变量表压入了两个，一个是默认的this，一个是mainNumber
        int mainNumber = 50;
        System.out.println(mainNumber + j);
    }
}
