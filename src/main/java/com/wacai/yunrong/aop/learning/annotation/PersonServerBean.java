package com.wacai.yunrong.aop.learning.annotation;

/**
 * @Author: yunrong@wacai.com
 * @Description:
 * @Date: 2019/9/19
 */
public final class PersonServerBean implements PersonServer {

    @Override
    public void save(String name) {
        System.out.println("我是save方法");
    }

    @Override
    public Integer update(String name, Integer id) {
        System.out.println("我是update()方法");
        return 1;
    }

    @Override
    public String getPersonName(Integer id) {
        System.out.println("我是getPersonName()方法");
        return "xxx";
    }
}
