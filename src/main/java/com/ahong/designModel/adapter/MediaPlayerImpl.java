package com.ahong.designModel.adapter;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author: zhengruihong
 * @description
 * @date: 2022/7/12 10:37 下午
 */
public class MediaPlayerImpl implements MediaPlayer {

    private MediaAdapter mediaAdapter;

    @Override
    public void play(String mediaType, String fileName) {
        mediaAdapter = new MediaAdapter();
        mediaAdapter.play(mediaType, fileName);
    }
}
