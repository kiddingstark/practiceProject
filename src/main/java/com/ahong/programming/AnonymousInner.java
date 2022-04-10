package com.ahong.programming;

public class AnonymousInner {

    public static void main(String[] args) {
        //1.正常内部类的生成
        A a = new A();
        A.B b = a.new B();
        b.sayName();

        //本质上只能算匿名类，不能算是匿名内部类
        //2.抽象类形式匿名内部类生成
        Inner2 inner2 = new Inner2(){
            private String name = "test";
            @Override
            public void sayName(){
                System.out.println("抽象类实现的匿名内部类名称："+name);
            }
        };//生成的inner2相当于Inner2的子类对象
        inner2.sayName();

        //抽象类形式匿名内部类生成
        Inner3 inner3 = new Inner3(){
            private String name = "test";
            @Override
            public void sayName(){
                System.out.println("接口实现的匿名内部类名称："+name);
            }
        };//生成的inner2相当于Inner2的子类对象
        inner2.sayName();
    }


}

//创建一个内部类
class A {

    private String name = "外部类A";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void sayName(){
        System.out.println("外部类名称："+this.name);
    }

    class B{
        private String name = "内部类B";



        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void sayName(){
            System.out.println("内部类名称："+this.name);
        }
    }

}

//匿名内部类：抽象类形式
abstract class Inner2{

    private String name = "匿名内部类inner2";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void sayName(){
        System.out.println("抽象类实现的匿名内部类名称："+this.name);
    }
}

//匿名内部类：接口形式
interface  Inner3{

    public void sayName();
}
