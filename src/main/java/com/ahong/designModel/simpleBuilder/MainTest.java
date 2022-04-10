package com.ahong.designModel.simpleBuilder;

/**
 * @Description TODO
 * @Author Ricky
 * @Date 2022/3/18 16:37
 */
public class MainTest {

    public static void main(String[] args) {
        Director director = new Director(new LowConfigComputerBuilder());
        director.createBuilder();
        System.out.println(director.getBuilder().getComputer());

        director = new Director(new HighConfigComputerBuilder());
        director.createBuilder();
        System.out.println(director.getBuilder().getComputer());
    }
}
