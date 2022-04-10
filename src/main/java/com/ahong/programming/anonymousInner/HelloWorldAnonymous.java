package com.ahong.programming.anonymousInner;

public class HelloWorldAnonymous {
    interface HelloWorld {
        public void greet();

        public void greetSomeone(String someone);
    }

    class Animal{
        private String name;

        public void sayName(){
            System.out.println("Hello " + this.name);
        }
    }

    public void sayHello() {
        //匿名内部类：chines属于HelloWorldAnonymous的内部接口HelloWorld的实现
        HelloWorld chinese = new HelloWorld() {
            String name = "world";
            @Override
            public void greet() {
                greetSomeone("world");
            }
            @Override
            public void greetSomeone(String someone) {
                name = someone;
                System.out.println("Hello " + name);
            }
        };
        chinese.greetSomeone("匿名内部类");
        //匿名内部类：bird属于HelloWorldAnonymous的内部类Animal的继承
        Animal bird = new Animal(){
            private String name = "yanzi";

            @Override
            public void sayName(){
                System.out.println("Hello " + this.name);
            }
        };
        bird.sayName();
    }

    public static void main(String[] args) {
        HelloWorldAnonymous hello = new HelloWorldAnonymous();
        hello.sayHello();
    }
}
