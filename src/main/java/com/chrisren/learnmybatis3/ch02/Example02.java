package com.chrisren.learnmybatis3.ch02;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.junit.Test;

import java.sql.*;

public class Example02 {

    @Test
    public void test() {
        try {
            Class.forName("org.hsqldb.jdbcDriver");
            Connection conn = DriverManager.getConnection("jdbc:hsqldb:mem:mybatis", "sa", "");
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from user");
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();
            while (resultSet.next()) {
                for (int i = 0; i < columnCount; i++) {
                    String columnName = metaData.getColumnName(i);
                    String columnVal = resultSet.getString(columnName);
                    System.out.println(columnName + ":" + columnVal);
                }
                System.out.println("---------------------");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
