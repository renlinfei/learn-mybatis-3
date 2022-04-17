package com.chrisren.learnmybatis3.diy.factory;

import com.chrisren.learnmybatis3.diy.configuration.Configuration;
import com.chrisren.learnmybatis3.diy.configuration.MappedStatement;
import com.chrisren.learnmybatis3.diy.factory.SqlSessionFactory;
import com.chrisren.learnmybatis3.diy.sqlsession.DefaultSqlSession;
import com.chrisren.learnmybatis3.diy.sqlsession.SqlSession;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * 1.初始化时就完成了configuration的实例化
 * 2.工厂类，生成sqlSession
 */
public class DefaultSqlSessionFactory implements SqlSessionFactory {

    private final Configuration configuration = new Configuration();
    // xml文件存放的位置
    private static final String MAPPER_CONFIG_LOCATION = "mapper";
    // 数据库信息存放的位置
    private static final String DB_CONFIG_FILE = "my-db.properties";

    public DefaultSqlSessionFactory() {
        loadDBInfo();
        loadMapperInfo();
    }

    private void loadDBInfo() {
        InputStream db = this.getClass().getClassLoader().getResourceAsStream(DB_CONFIG_FILE);
        Properties properties = new Properties();
        try {
            properties.load(db);
            // 将配置信息写入Configuration对象
            configuration.setJdbcDriver(properties.getProperty("jdbc.driver"));
            configuration.setJdbcUrl(properties.getProperty("jdbc.url"));
            configuration.setJdbcUsername(properties.getProperty("jdbc.username"));
            configuration.setJdbcPassword(properties.getProperty("jdbc.password"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadMapperInfo() {
        URL resource = this.getClass().getClassLoader().getResource(MAPPER_CONFIG_LOCATION);
        File mappers = new File(resource.getFile());
        if (mappers.isDirectory()) {
            File[] files = mappers.listFiles();
            for (File file : files) {
                loadMapperInfo(file);
            }
        }
    }

    private void loadMapperInfo(File file) {
        SAXReader reader = new SAXReader();
        Document document = null;
        try {
            document = reader.read(file);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        // 获取根节点元素对象
        Element rootElement = document.getRootElement();
        String namespace = rootElement.attribute("namespace").getData().toString();
        // 获取select，insert，update，delete子节点列表
        List<Element> selects = rootElement.elements("select");
        List<Element> inserts = rootElement.elements("insert");
        List<Element> updates = rootElement.elements("update");
        List<Element> deletes = rootElement.elements("delete");

        List<Element> elements = new ArrayList<>();
        elements.addAll(selects);
        elements.addAll(inserts);
        elements.addAll(updates);
        elements.addAll(deletes);

        for (Element element : elements) {
            MappedStatement mappedStatement = new MappedStatement();
            String id = element.attribute("id").getData().toString();
            String resultType = element.attribute("resultType").getData().toString();
            String sql = element.getData().toString();

            mappedStatement.setId(namespace + "." + id);
            mappedStatement.setResultType(resultType);
            mappedStatement.setSql(sql);
            configuration.getMappedStatement().put(namespace + "." + id, mappedStatement);
        }
    }

    @Override
    public SqlSession openSession() {

        return new DefaultSqlSession(configuration);
    }
}
