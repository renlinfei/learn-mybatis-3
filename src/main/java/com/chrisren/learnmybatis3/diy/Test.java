package com.chrisren.learnmybatis3.diy;

import com.chrisren.learnmybatis3.diy.entity.User;
import com.chrisren.learnmybatis3.diy.mapper.UserMapper;
import com.chrisren.learnmybatis3.diy.factory.DefaultSqlSessionFactory;
import com.chrisren.learnmybatis3.diy.sqlsession.SqlSession;
import com.chrisren.learnmybatis3.diy.factory.SqlSessionFactory;

public class Test {

    @org.junit.Test
    public void testMybatisDIY() {
        SqlSessionFactory sqlSessionFactory = new DefaultSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.selectByPrimaryKey(1L);
        System.out.println(user.toString());
    }
}
