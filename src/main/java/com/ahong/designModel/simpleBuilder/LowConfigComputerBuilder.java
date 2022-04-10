package com.ahong.designModel.simpleBuilder;

/**
 * @Description TODO
 * @Author Ricky
 * @Date 2022/3/18 16:32
 */
public class LowConfigComputerBuilder implements AbstractComputerBuilder{

    private Computer computer;

    public LowConfigComputerBuilder() {
        this.computer = new Computer();
    }

    @Override
    public void setCpu() {
        computer.setCpu("i5");
    }

    @Override
    public void setMemory() {
        computer.setMemory("8G");
    }

    @Override
    public void setHardDisk() {
        computer.setHardDisk("1T");
    }

    @Override
    public void setKeyBoard() {
        computer.setKeyBoard("普通键盘");
    }

    @Override
    public void setMouse() {
        computer.setMouse("有线鼠标");
    }

    @Override
    public Computer getComputer() {
        return computer;
    }
}
