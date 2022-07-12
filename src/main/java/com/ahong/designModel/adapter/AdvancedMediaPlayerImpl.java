package com.ahong.designModel.adapter;

/**
 * @author: zhengruihong
 * @description
 * @date: 2022/7/12 10:35 下午
 */
public class AdvancedMediaPlayerImpl implements AdvancedMediaPlayer {
    @Override
    public void playAvi(String fileName) {
        System.out.println("AdvancedMediaPlayer播放了avi文件，文件名：" + fileName);
    }

    @Override
    public void playMp4(String fileName) {
        System.out.println("AdvancedMediaPlayer播放了mp4文件，文件名：" + fileName);
    }
}
