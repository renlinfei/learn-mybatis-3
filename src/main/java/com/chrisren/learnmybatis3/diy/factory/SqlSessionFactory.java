package com.chrisren.learnmybatis3.diy.factory;

import com.chrisren.learnmybatis3.diy.sqlsession.SqlSession;

public interface SqlSessionFactory {
    SqlSession openSession();
}
