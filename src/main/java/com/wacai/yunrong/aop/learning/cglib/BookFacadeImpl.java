package com.wacai.yunrong.aop.learning.cglib;

/**
 * @Author: yunrong@wacai.com
 * @Description: 没有实现接口的实现类
 * @Date: 2019/9/19
 */
public class BookFacadeImpl {
    public void addBook(){
        System.out.println("增加图书的普通方法。。。");
    }

    public void deleteBook(){
        System.out.println("删除图书的普通方法。。。");
    }

}
