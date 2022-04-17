package com.chrisren.learnmybatis3.diy.executor;

import com.chrisren.learnmybatis3.diy.configuration.MappedStatement;

import java.util.List;

/**
 * mybatis核心接口之一，定义了数据库操作的基本方法；JDBC，sqlSession的所有功能都是基于它来实现的
 */
public interface Executor {
    /**
     * 查询接口
     * @param ms 封装slq语句的mappedStatement对象，里面包含sql语句，resultType等
     * @param params parameter传入sql参数
     * @param <E> 将数据对象转换为指定对象结果集返回
     * @return
     */
    <E> List<E> query(MappedStatement ms, Object params);
}
