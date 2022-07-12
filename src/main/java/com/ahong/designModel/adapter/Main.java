package com.ahong.designModel.adapter;

/**
 * @author: zhengruihong
 * @description
 * @date: 2022/7/12 10:40 下午
 */
public class Main {

    public static void main(String[] args) {
        MediaPlayerImpl mediaPlayer = new MediaPlayerImpl();
        mediaPlayer.play("mp3","mp3文件");
        mediaPlayer.play("mp4","mp4文件");
        mediaPlayer.play("avi","avi文件");


    }
}
