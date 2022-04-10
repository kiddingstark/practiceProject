package com.ahong.designModel.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 主体，即被观察的对象，核心事项是讲观察者封装成一个list作为主体的一个属性
 *                  如果是走发布-订阅模式的话就多了一个发布者：发布者-主体-订阅者（观察者），加一个发布者类中有一个属性为Subject再包一层即可
 * @Author Ricky
 * @Date 2021/10/7 2:37
 */
public class WechatSubject implements Subject {

    private String name;
    private int version;

    public WechatSubject(int version) {
        this.version = version;
    }

    public WechatSubject(String name, int version) {
        this.name = name;
        this.version = version;
    }

    private List<Observer> observers = new ArrayList<>();

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void deleteObserver(Observer observer) {
        observers.remove(observer);
    }

    /**
     * 循环调用每个属性的update方法
     */
    @Override
    public void notifyObserver() {
        observers.forEach(observer -> {
            observer.update(name, version);
        });
    }
}
