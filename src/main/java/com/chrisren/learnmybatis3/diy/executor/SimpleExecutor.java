package com.chrisren.learnmybatis3.diy.executor;

import com.chrisren.learnmybatis3.diy.configuration.Configuration;
import com.chrisren.learnmybatis3.diy.configuration.MappedStatement;
import com.chrisren.learnmybatis3.diy.util.ReflectionUtil;
import org.springframework.util.ReflectionUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SimpleExecutor implements Executor {

    private Configuration configuration;

    public SimpleExecutor(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public <E> List<E> query(MappedStatement ms, Object params) {
        System.out.println(ms.getSql().toString());
        List<E> ret = new ArrayList<>();
        try {
            Class.forName(configuration.getJdbcDriver());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = DriverManager.getConnection(configuration.getJdbcUrl(), configuration.getJdbcUsername(), configuration.getJdbcPassword());
            String regex = "#\\{([^}])*\\}";
            String sql = ms.getSql().replaceAll(regex, "?");
            preparedStatement = connection.prepareStatement(sql);
            parametersize(preparedStatement, params);
            resultSet = preparedStatement.executeQuery();
            handlerResultSet(resultSet, ret, ms.getResultType());
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                resultSet.close();
                preparedStatement.close();
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return ret;
    }

    private void parametersize(PreparedStatement preparedStatement, Object parameter) throws SQLException {
        if (parameter instanceof Integer) {
            preparedStatement.setInt(1, (int) parameter);
        } else if (parameter instanceof Long) {
            preparedStatement.setLong(1, (Long) parameter);
        } else if (parameter instanceof String) {
            preparedStatement.setString(1, (String) parameter);
        }

    }

    private <E> void handlerResultSet(ResultSet resultSet,List<E> ret, String className) {
        Class<E> clazz = null;
        try {
            clazz = (Class<E>) Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            while (resultSet.next()) {
                Object entity = clazz.newInstance();
                ReflectionUtil.setPropBeanFromResult(entity, resultSet);
                ret.add((E) entity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
