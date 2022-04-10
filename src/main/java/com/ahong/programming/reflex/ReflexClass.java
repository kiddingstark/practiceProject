package com.ahong.programming.reflex;

/**
 * @Description TODO
 * @Author Ricky
 * @Date 2020/7/27 11:55
 */
public class ReflexClass {

    private Integer id;

    private String name;

    public ReflexClass() {
        System.out.println("调用无参数的构造方法");
    }

    public ReflexClass(Integer id, String name) {
        this.id = id;
        this.name = name;
        System.out.println("调用参数的构造方法：id："+id+",name:"+name);
    }

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "调用toString方法：ReflexClass{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
