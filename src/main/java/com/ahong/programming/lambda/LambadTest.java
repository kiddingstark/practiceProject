package com.ahong.programming.lambda;

import com.ahong.designModel.complexBuilder.Person;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 1.lambda表达式：匿名内部类的另外一种形式
 * 2.方法引用写法：简化lambda表达式，但是不可传参数
 * 3.stream常用方法：高版本的iterator
 */
public class LambadTest {

    //函数式接口,注解非必须
    //@FunctionalInterface
    interface LambdaInterface {
        public void square(int a);

    }

    public static void main(String[] args) {
        //1.匿名内部类方式
        LambdaInterface test1 = new LambdaInterface() {
            @Override
            public void square(int a) {
                System.out.println("匿名内部类实现：" + a * a);
            }
        };
        test1.square(10);
        //2.lambad表达式:是一个实现了函数式接口的方法(square方法)
        LambdaInterface test2 = (int a) -> {
            System.out.println("lambda表达式表达式实现：" + a * a);
        };
        test2.square(10);
        //2.1方法的引用：无法传递参数
        LambdaInterface test3 = System.out::println;
        test3.square(10);

        //3.lambad表达式表达式实例
        List<LambdaModel> list = new ArrayList<LambdaModel>();
        list.add(new LambdaModel("xiaoming"));
        list.add(new LambdaModel("xiaohong"));
        //forEach方法中的参数Consumer是一个函数式接口，相当于匿名内部类：实现了Consumer类并且重写其中的方法
        list.forEach(model -> {
            String name = model.getName();
            System.out.println(name);
        });

        //4.stream流常用方法
        //4.1 filter()
        List<String> filterLists = new ArrayList<>();
        filterLists.add("");
        filterLists.add("a");
        filterLists.add("b");
        //4.2 forEach()
        List afterList = filterLists.stream().filter(o -> !o.isEmpty()).collect(Collectors.toList());
        afterList.stream().forEach(o -> {
            System.out.println(o);
        });
        //4.3 map()
        List afterList1 = filterLists.stream().map(String::toUpperCase).collect(Collectors.toList());
        afterList1.stream().forEach(o -> {
            System.out.println(o);
        });
        //4.4 List转换Map
        List<LambdaModel> list1 = new ArrayList<>();
        list1.add(new LambdaModel("xiaoming"));
        list1.add(new LambdaModel("xiaohong"));
        list1.add(new LambdaModel("xiaoli"));
        //Function.identity()相当于o -> o
        HashMap<String, Object> test = new HashMap<>();
        Map<String, LambdaModel> map = list1.stream().collect(Collectors.toMap(o -> o.getName(), Function.identity()));
        for (String key : map.keySet()) {
            System.out.println("key:" + key + ",value:  " + map.get(key).toString());
        }
        //groupby分组
        Map<String, List<LambdaModel>> groupMap1 = list1.stream().collect(Collectors.groupingBy(LambdaModel::getName));
        Map<String, Map<String, LambdaModel>> groupMap2 = list1.stream().collect(
                Collectors.groupingBy(LambdaModel::getName, Collectors.toMap(LambdaModel::getName, Function.identity())));

        //判断空
//        Person person = new Person("Ricky", "male");
//        person.setAge(18);
        Person person = null;
        System.out.println(null != person && 0 != person.getAge() ? person.getAge() : 1);
        System.out.println(Optional.ofNullable(person).map(item -> item.getAge()).orElse(1));

        Function<Integer, Integer> plus = i -> i + 100;
        System.out.println(plus.apply(10));

    }

}
