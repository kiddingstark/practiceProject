package com.ahong.jvm;

import jdk.internal.org.objectweb.asm.ClassWriter;
import jdk.internal.org.objectweb.asm.Opcodes;

/**
 * @Description 测试自定义的类加载器不断加载类的字节码文件(class文件)导致方法区溢出
 * @Author Ricky
 * @Date 2021/10/16 16:51
 */
public class MethodAreaOOMTest extends ClassLoader{

    public static void main(String[] args) {
        int j = 0;
        try {
            MethodAreaOOMTest test = new MethodAreaOOMTest();
            for (int i = 0; i < 10000; i++) {
                //创建ClassWriter对象，用于生成类的二进制字节码
                ClassWriter classWriter = new ClassWriter(0);
                //指明版本号，修饰符，类名，包名，父类，接口
                classWriter.visit(Opcodes.V1_6, Opcodes.ACC_PUBLIC, "Class" + i, null, "java/lang/Object", null);
                //返回byte[]
                byte[] code = classWriter.toByteArray();
                //类的加载
                test.defineClass("Class" + i, code, 0, code.length);//Class对象
                j++;
            }
        } finally {
            System.out.println(j);
        }
    }
}
