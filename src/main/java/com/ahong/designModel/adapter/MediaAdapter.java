package com.ahong.designModel.adapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;

/**
 * @author: zhengruihong
 * @description 适配器模式：1、适配器实现MP3接口，包装MP4对象，播放MP4时实际调用MP4对象
 *                          2、适配器实现飞禽接口，包装猛虎对象，在飞禽的"飞翔"方法中调用猛虎的"捕猎"方法，从而实现"飞虎"功能
 * @date: 2022/7/12 10:38 下午
 */
public class MediaAdapter implements MediaPlayer {

    private AdvancedMediaPlayerImpl advancedMediaPlayer;

    @Override
    public void play(String mediaType, String fileName) {
        if (mediaType.equals("mp3")) {
            System.out.println("MediaPlayerImpl播放了mp3文件，文件名：" + fileName);
        } else if (mediaType.equals("avi")) {
            advancedMediaPlayer = new AdvancedMediaPlayerImpl();
            advancedMediaPlayer.playAvi(fileName);
        } else if (mediaType.equals("mp4")) {
            advancedMediaPlayer = new AdvancedMediaPlayerImpl();
            advancedMediaPlayer.playMp4(fileName);
        }
    }
}
