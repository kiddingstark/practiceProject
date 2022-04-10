package com.ahong.designModel.publish;


/**
 * @author 郑锐鸿
 * @Description: TODO
 * @date 2022/3/24 23:32
 */
public class PublishTest {

    public static void main(String[] args) {
        WechatPublisher wechatPublisher = new WechatPublisher("广东共青团",1);

        WechatSubject wechatSubject = new WechatSubject("微信公众号订阅");
        WechatSubcriber wechatSubcriber1 = new WechatSubcriber("郑锐鸿");
        WechatSubcriber wechatSubcriber2 = new WechatSubcriber("赵虹雨");

        wechatSubject.addSubcriber(wechatSubcriber1);
        wechatSubject.addSubcriber(wechatSubcriber2);

        wechatPublisher.publish(wechatSubject);

    }
}
