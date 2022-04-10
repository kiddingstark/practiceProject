package com.ahong.designModel.publish;


import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author Ricky
 * @Date 2021/10/7 2:37
 */
public class WechatSubject implements Subject {

    private String name;

    public WechatSubject(String name) {
        this.name = name;
    }

    private List<Subcriber> subcribers = new ArrayList<>();

    @Override
    public void addSubcriber(Subcriber subcriber) {
        subcribers.add(subcriber);
    }

    @Override
    public void deleteSubcriber(Subcriber subcriber) {
        subcribers.remove(subcriber);
    }

    @Override
    public void notifySubcriber(String name, Integer version) {
        subcribers.forEach(subcribers -> {
            subcribers.update(name, version);
        });
    }
}
