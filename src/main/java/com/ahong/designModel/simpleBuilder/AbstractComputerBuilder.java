package com.ahong.designModel.simpleBuilder;

/**
 * @Description TODO
 * @Author Ricky
 * @Date 2022/3/18 16:28
 */
public interface AbstractComputerBuilder {

    void setCpu();

    void setMemory();

    void setHardDisk();

    void setKeyBoard();

    void setMouse();

    Computer getComputer();
}
