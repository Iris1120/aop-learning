package com.wacai.yunrong.aop.learning.normal;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author: yunrong@wacai.com
 * @Description: 打印日志的切面
 * @Date: 2019/9/19
 */
public class LogInvocationHandler implements InvocationHandler {

    // 目标对象
    private Object target;

    public LogInvocationHandler(Object target){
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws InvocationTargetException, IllegalAccessException {
        //执行织入的日志，你可以控制哪些方法执行切入逻辑
        if (method.getName().equals("doSomeThing2")){
            System.out.println("记录日志2");
        }

//        if (method.getName().equals("doSomeThing")){
//            System.out.println("记录日志");
//        }

        System.out.println("代理层的执行");
        // 执行原有逻辑
        Object recv = method.invoke(target, args);
        return recv;
    }

}
