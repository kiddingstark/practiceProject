package com.ahong.designModel.observer;

/**
 * @Description TODO
 * @Author LS-IT
 * @Date 2021/10/7 2:38
 */
public interface Observer {

    void update(String SubjectName, int version);
}
