package com.wacai.yunrong.aop.learning.xml;

/**
 * @Author: yunrong@wacai.com
 * @Description:
 * @Date: 2019/9/19
 */
public final class HelloWorldImpl2 implements HelloWorld {

    @Override
    public void printHelloWorld() {
        System.out.println("Enter HelloWorldImpl2.printHelloWorld()");
    }

    @Override
    public void doPrint() {
        System.out.println("Enter HelloWorldImpl2.doPrint()");
    }
}
