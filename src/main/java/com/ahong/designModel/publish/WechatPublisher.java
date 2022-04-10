package com.ahong.designModel.publish;

/**
 * @author 郑锐鸿
 * @Description: TODO
 * @date 2022/3/24 23:26
 */
public class WechatPublisher implements Publisher {

    private String name;
    private Integer version;

    public WechatPublisher(String name, Integer version) {
        this.name = name;
        this.version = version;
    }

    @Override
    public void publish(Subject subject) {
        subject.notifySubcriber(this.name,this.version);
    }
}
