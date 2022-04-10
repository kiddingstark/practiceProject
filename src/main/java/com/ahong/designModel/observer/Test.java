package com.ahong.designModel.observer;

/**
 * @Description TODO
 * @Author Ricky
 * @Date 2021/10/7 2:48
 */
public class Test {

    public static void main(String[] args) {
        WechatSubject wechatSubject = new WechatSubject("广东共青团",1);
        WechatObserver wechatObserver1 = new WechatObserver("郑锐鸿");
        WechatObserver wechatObserver2 = new WechatObserver("赵虹雨");
        wechatSubject.addObserver(wechatObserver1);
        wechatSubject.addObserver(wechatObserver2);
        wechatSubject.notifyObserver();
    }
}
