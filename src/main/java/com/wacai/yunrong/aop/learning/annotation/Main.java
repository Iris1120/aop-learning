package com.wacai.yunrong.aop.learning.annotation;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: yunrong@wacai.com
 * @Description:
 * @Date: 2019/9/19
 */
public class Main {

    private final static Log log = LogFactory.getLog(Main.class);

    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("aopAnnotation.xml");
        PersonServer personServer = (PersonServer) context.getBean("personServer");
        System.out.println();
        personServer.getPersonName(1);
        System.out.println();
        personServer.save("name");
        System.out.println();
        personServer.update("name", 2);
    }
}
