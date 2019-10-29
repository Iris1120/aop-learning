package com.wacai.yunrong.aop.learning.cglib;

/**
 * @Author: yunrong@wacai.com
 * @Description:
 * @Date: 2019/9/19
 */
public class TestCglib {
    public static void main(String[] args) {
        BookFacadeCglib cglib = new BookFacadeCglib();

        BookFacadeImpl bookFacade = (BookFacadeImpl) cglib.getInstance(new BookFacadeImpl());

        bookFacade.addBook();
        bookFacade.deleteBook();
    }
}
