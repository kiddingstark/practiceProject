package com.ahong.designModel.publish;

import com.ahong.designModel.observer.Observer;

/**
 * @Description TODO
 * @Author LS-IT
 * @Date 2021/10/7 2:35
 */
public interface Subject {

    void addSubcriber(Subcriber subcriber);

    void deleteSubcriber(Subcriber subcriber);

    void notifySubcriber(String name, Integer version);
}
