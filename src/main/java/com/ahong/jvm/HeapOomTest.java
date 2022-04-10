package com.ahong.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description TODO
 * @Author Ricky
 * @Date 2021/11/3 17:25
 */
// -Xms60m -Xmx60m -XX:SurvivorRatio=8
public class HeapOomTest {

    public static void main(String[] args) {
        List<byte[]> list = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            byte[] bytes = new byte[1024 * 100];
            list.add(bytes);
            try {
                Thread.currentThread().sleep(120);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
