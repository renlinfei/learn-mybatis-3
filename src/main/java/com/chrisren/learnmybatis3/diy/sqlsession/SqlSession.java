package com.chrisren.learnmybatis3.diy.sqlsession;

import java.util.List;

/**
 * 封装了所有数据库的操作
 * 所有功能都是基于Executor来实现的，Executor封装了JDBC操作
 */
public interface SqlSession {
    /**
     * 根据传入的条件查询单一结果
     * @param statement namespace+id，可以用作key，去configuration里面获取sql语句
     * @param parameter 要传入sql语句中的查询参数
     * @param <T> 返回指定的结果对象
     * @return
     */
    <T> T selectOne(String statement, Object parameter);
    <T> List<T> selectList(String statement, Object parameter);

    /**
     * 获取Mapper实现类
     * @param type
     * @param <T>
     * @return
     */
    <T> T getMapper(Class<T> type);
}
