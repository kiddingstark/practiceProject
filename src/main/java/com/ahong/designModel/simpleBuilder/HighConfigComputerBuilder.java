package com.ahong.designModel.simpleBuilder;

/**
 * @Description TODO
 * @Author Ricky
 * @Date 2022/3/18 16:34
 */
public class HighConfigComputerBuilder implements AbstractComputerBuilder{

    private Computer computer;

    public HighConfigComputerBuilder() {
        this.computer = new Computer();
    }

    @Override
    public void setCpu() {
        computer.setCpu("i7");
    }

    @Override
    public void setMemory() {
        computer.setMemory("16G");
    }

    @Override
    public void setHardDisk() {
        computer.setHardDisk("2T");
    }

    @Override
    public void setKeyBoard() {
        computer.setKeyBoard("机械键盘");
    }

    @Override
    public void setMouse() {
        computer.setMouse("无线鼠标");
    }

    @Override
    public Computer getComputer() {
        return computer;
    }
}
