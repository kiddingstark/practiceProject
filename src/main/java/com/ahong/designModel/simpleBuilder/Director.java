package com.ahong.designModel.simpleBuilder;

/**
 * @Description 操作者
 * @Author Ricky
 * @Date 2022/3/18 16:35
 */
public class Director {

    private AbstractComputerBuilder builder;

    public Director(AbstractComputerBuilder builder) {
        this.builder = builder;
    }

    public AbstractComputerBuilder getBuilder() {
        return builder;
    }

    public void createBuilder(){
        builder.setCpu();
        builder.setMemory();
        builder.setHardDisk();
        builder.setKeyBoard();
        builder.setMouse();
    }
}
