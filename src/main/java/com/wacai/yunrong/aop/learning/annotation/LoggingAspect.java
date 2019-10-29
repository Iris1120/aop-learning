package com.wacai.yunrong.aop.learning.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: yunrong@wacai.com
 * @Description:
 * @Date: 2019/9/19
 */
//指定切面的优先级，当有多个切面时，数值越小优先级越高
@Order(1)
//把这个类声明为一个切面：需要把该类放入到IOC容器中。再声明为一个切面.
@Aspect
@Component
public class LoggingAspect {
    /**
     * 声明切入点表达式，一般在该方法中不再添加其他代码。
     * 使用@Pointcut来声明切入点表达式。
     * 后面的通知直接使用方法名来引用当前的切入点表达式。
     */
    @Pointcut("execution(* com.wacai.yunrong.aop.learning.annotation.PersonServerBean.*(..))")
    public void declareJoinPointExpression(){}

    /**
     *前置通知，在目标方法开始之前执行。
     *@Before("execution(public String com.wacai.yunrong.aop.learning.annotation.PersonServerBean.getPersonName(Integer))")这样写可以指定特定的方法。
     * @param joinPoint
     */
    @Before("declareJoinPointExpression()")
    //这里使用切入点表达式即可。后面的可以都改成切入点表达式。如果这个切入点表达式在别的包中，在前面加上包名和类名即可。
    public void beforeMethod(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        List<Object> args = Arrays.asList(joinPoint.getArgs());
        System.out.println("beforeMethod-前置通知：The method "+ methodName +" begins with " + args);
    }

    @After("execution(* com.wacai.yunrong.aop.learning.annotation.PersonServerBean.*(Integer))")
    public void afterMethod(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("afterMethod-后置通知：The method "+ methodName +" end ");
    }

    /**
     *返回通知，在方法正常结束之后执行。
     *可以访问到方法的返回值。
     * @param joinpoint
     * @param result 目标方法的返回值
     */
    @AfterReturning(value="execution(public Integer com.wacai.yunrong.aop.learning.annotation.PersonServerBean.*(..))", returning="result")
    public void afterReturning(JoinPoint joinpoint, Object result) {
        String methodName = joinpoint.getSignature().getName();
        System.out.println("afterReturning-返回通知：The method "+ methodName +" ends with " + result);
    }

    /**
     *异常通知。目标方法出现异常的时候执行，可以访问到异常对象，可以指定在出现特定异常时才执行。
     *假如把参数写成NullPointerException则只在出现空指针异常的时候执行。
     * @param joinpoint
     * @param e
     */
    @AfterThrowing(value="execution(public String com.wacai.yunrong.aop.learning.annotation.PersonServerBean.*(..))", throwing="e")
    public void afterThrowing(JoinPoint joinpoint, Exception e) {
        String methodName = joinpoint.getSignature().getName();
        System.out.println("afterThrowing-异常通知：The method "+ methodName +" occurs exception " + e);
    }

    /**
     * 环绕通知类似于动态代理的全过程，ProceedingJoinPoint类型的参数可以决定是否执行目标方法。
     * @param point 环绕通知需要携带ProceedingJoinPoint类型的参数。
     * @return 目标方法的返回值。必须有返回值。
     */
    @Around("execution(* com.wacai.yunrong.aop.learning.annotation.PersonServerBean.*(..))")
    public Object aroundMethod(ProceedingJoinPoint point){
        Object result = null;
        String methodName = point.getSignature().getName();
        try{
            //前置通知
            System.out.println("aroundMethod-The method "+ methodName +" begins with " + Arrays.asList(point.getArgs()));
            // 执行目标方法
            result = point.proceed();
            // 翻译通知
            System.out.println("aroundMethod-The method "+ methodName +" ends with " + result);
        }catch (Throwable e){
            System.out.println("aroundMethod-The method "+ methodName +" occurs exception " + e);
            throw new RuntimeException(e);
        }
        //后置通知
        System.out.println("aroundMethod-The method "+ methodName +" ends");
        return result;
    }




}
