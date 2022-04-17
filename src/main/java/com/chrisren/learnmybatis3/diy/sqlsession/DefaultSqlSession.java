package com.chrisren.learnmybatis3.diy.sqlsession;

import com.chrisren.learnmybatis3.diy.configuration.Configuration;
import com.chrisren.learnmybatis3.diy.configuration.MappedStatement;
import com.chrisren.learnmybatis3.diy.executor.Executor;
import com.chrisren.learnmybatis3.diy.executor.SimpleExecutor;
import com.chrisren.learnmybatis3.diy.proxy.MapperProxy;

import java.lang.reflect.Proxy;
import java.util.List;

public class DefaultSqlSession implements SqlSession {
    private Configuration configuration;
    private Executor executor;

    public DefaultSqlSession(Configuration configuration) {
        super();
        this.configuration = configuration;
        executor = new SimpleExecutor(configuration);
    }

    @Override
    public <T> T selectOne(String statement, Object parameter) {
        List<T> selectList = this.selectList(statement, parameter);
        if (null == selectList || selectList.size() == 0) {
            return null;
        }
        if (selectList.size() == 1) {
            return (T) selectList.get(0);
        } else {
            throw new RuntimeException("too many results");
        }
    }

    @Override
    public <T> List<T> selectList(String statement, Object parameter) {
        MappedStatement ms = configuration.getMappedStatement().get(statement);
        return executor.query(ms, parameter);
    }

    @Override
    public <T> T getMapper(Class<T> type) {
        //通过动态代理生成了一个实现类，我们重点关注，动态代理的实现，它是一个 InvocationHandler，传入参数是 this，就是 sqlSession 的一个实例
        MapperProxy mapperProxy = new MapperProxy(this);
        return (T) Proxy.newProxyInstance(type.getClassLoader(), new Class[] {type}, mapperProxy);
    }
}
