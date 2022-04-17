package com.chrisren.learnmybatis3.diy.proxy;

import com.chrisren.learnmybatis3.diy.sqlsession.SqlSession;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Collection;

/**
 * 将请求转给sqlSession
 */
public class MapperProxy implements InvocationHandler {
    private SqlSession sqlSession;

    public MapperProxy(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(method.getDeclaringClass().getName() + "." + method.getName());
        // 最终还是将执行方法转给sqlSession，应为sqlSession里封装了Executor
        // 根据调用方法的类名和方法名以及参数，传给sqlSession对应的方法
        if (Collection.class.isAssignableFrom(method.getReturnType())) {
            return sqlSession.selectList(method.getDeclaringClass().getName() + "." + method.getName(), args == null ? null : args[0]);
        } else {
            return sqlSession.selectOne(method.getDeclaringClass().getName() + "." + method.getName(), args == null ? null : args[0]);
        }
    }
}
