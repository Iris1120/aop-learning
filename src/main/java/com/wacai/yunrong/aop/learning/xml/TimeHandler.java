package com.wacai.yunrong.aop.learning.xml;

/**
 * @Author: yunrong@wacai.com
 * @Description:
 * @Date: 2019/9/19
 */
public class TimeHandler {

    public void printBeforeTime(){
        System.out.println("Before-CurrentTime = " + System.currentTimeMillis());
    }

    public void printAfterTime(){
        System.out.println("After-CurrentTime = " + System.currentTimeMillis());

    }
}
