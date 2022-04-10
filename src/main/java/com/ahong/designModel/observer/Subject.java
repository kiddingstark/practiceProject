package com.ahong.designModel.observer;

/**
 * @Description TODO
 * @Author LS-IT
 * @Date 2021/10/7 2:35
 */
public interface Subject {

    void addObserver(Observer observer);

    void deleteObserver(Observer observer);

    void notifyObserver();
}
