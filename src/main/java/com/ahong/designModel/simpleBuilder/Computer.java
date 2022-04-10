package com.ahong.designModel.simpleBuilder;

import lombok.Data;

/**
 * @Description 需要组装的产品
 * @Author Ricky
 * @Date 2022/3/18 16:26
 */

@Data
public class Computer {

    private String cpu;

    private String memory;

    private String hardDisk;

    private String keyBoard;

    private String mouse;

    @Override
    public String toString() {
        return "Computer{" +
                "cpu='" + cpu + '\'' +
                ", memory='" + memory + '\'' +
                ", hardDisk='" + hardDisk + '\'' +
                ", keyBoard='" + keyBoard + '\'' +
                ", mouse='" + mouse + '\'' +
                '}';
    }
}
