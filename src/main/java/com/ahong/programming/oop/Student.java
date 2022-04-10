package com.ahong.programming.oop;

/**
 * @Description TODO
 * 1.封装：通过电视机遥控器就能操作电视机进行换台/音量调节等操作，无需打开电视机后盖进行电路板的操作
 * 2.继承
 * 3.抽象：抽象代表“是不是”，接口代表有没有，如门有设置open(),close(),alarm()等方法，开跟关属于门的行为特性，而报警可有可无，属于延申行为
 * 则设置抽象类：abstract Class Door，实现抽象方法open(),close()，再设置报警的接口Alram,实现alarm()，需要报警的Door则implements Alaram
 * 4.多态：父类引用指向的是子类对象,多态建立在继承、重写上，例:同样的按键如F1在window,word,flash平台上的功能不同
 * @Author Ricky
 * @Date 2020/9/3 14:58
 */
public class Student extends Person{

    private String grade;

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public void eat() {
        System.out.println("Student is eating!");
    }

    public void privateTest(){
        System.out.println("Student is prprivateTest!");
    }
}
