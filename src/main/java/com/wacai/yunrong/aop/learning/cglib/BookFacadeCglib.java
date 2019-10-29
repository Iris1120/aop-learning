package com.wacai.yunrong.aop.learning.cglib;


import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Author: yunrong@wacai.com
 * @Description:
 * @Date: 2019/9/19
 */
public class BookFacadeCglib implements MethodInterceptor {
    private Object target;

    /*
     * 创建代理对象
     */
    public Object getInstance(Object target){
        this.target = target;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.target.getClass());
        // 回调方法
        enhancer.setCallback(this);
        // 创建代理
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("cglib 代理拦截");

        if (method.getName().equals("addBook")) {
            System.out.println("记录增加图书的日志");
        }


        methodProxy.invokeSuper(o, objects);
        return null;
    }
}
