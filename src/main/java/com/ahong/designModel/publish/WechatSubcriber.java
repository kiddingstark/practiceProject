package com.ahong.designModel.publish;

import com.ahong.designModel.observer.Observer;

/**
 * @Description
 * @Author Ricky
 * @Date 2021/10/7 2:41
 */
public class WechatSubcriber implements Subcriber {

    private String name;

    public WechatSubcriber(String name) {
        this.name = name;
    }

    @Override
    public void update(String publisher, int version) {
        System.out.println(publisher + "公众号发布了" + version + "版本的文章，" + name + "已接受到并查看！");
    }
}
