package com.ahong.designModel.observer;

/**
 * @Description 观察者
 * @Author Ricky
 * @Date 2021/10/7 2:41
 */
public class WechatObserver implements Observer {

    private String name;

    public WechatObserver(String name) {
        this.name = name;
    }

    @Override
    public void update(String SubjectName, int version) {
        System.out.println(SubjectName + "公众号发布了" + version + "版本的文章，" + name + "已接受到并查看！");
    }
}
