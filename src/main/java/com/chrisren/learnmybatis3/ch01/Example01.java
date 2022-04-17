package com.chrisren.learnmybatis3.ch01;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.jdbc.ScriptRunner;
import org.apache.ibatis.jdbc.SqlRunner;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class Example01 {
    private Connection connection = null;

    @Before
    public void initData() {
        try {
            Class.forName("org.hsqldb.jdbcDriver");
            connection = DriverManager.getConnection("jdbc:hsqldb:mem:mybatis", "sa", "");
            ScriptRunner scriptRunner = new ScriptRunner(connection);
            scriptRunner.setLogWriter(null);
            scriptRunner.runScript(Resources.getResourceAsReader("create-table.sql"));
            scriptRunner.runScript(Resources.getResourceAsReader("init-data.sql"));
        } catch (ClassNotFoundException | SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testHsqldbQuery() {
        SqlRunner sqlRunner = new SqlRunner(connection);
        try {
            List<Map<String, Object>> results = sqlRunner.selectAll("select * from user");
            results.forEach(System.out::println);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
