package com.wacai.yunrong.aop.learning.annotation;

/**
 * @Author: yunrong@wacai.com
 * @Description:
 * @Date: 2019/9/19
 */
public interface PersonServer {
    void save(String name);
    Integer update(String name, Integer id);
    String getPersonName(Integer id);
}
