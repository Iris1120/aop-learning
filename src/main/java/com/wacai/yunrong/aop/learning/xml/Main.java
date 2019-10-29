package com.wacai.yunrong.aop.learning.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: yunrong@wacai.com
 * @Description:
 * @Date: 2019/9/19
 */
public class Main {

    public static void main(String[] args) {
        ApplicationContext ctx =
                new ClassPathXmlApplicationContext("aop01.xml");
        HelloWorld hw1 = (HelloWorld) ctx.getBean("helloWorldImpl1");
        HelloWorld hw2 = (HelloWorld) ctx.getBean("helloWorldImpl2");

        hw1.printHelloWorld();
        System.out.println();
        hw1.doPrint();

        System.out.println();
        hw2.printHelloWorld();
        System.out.println();
        hw2.doPrint();
    }
}
