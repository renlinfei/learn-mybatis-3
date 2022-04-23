package com.chrisren.learnmybatis3.dynamicsql;


import com.chrisren.learnmybatis3.dynamicsql.mapper.TCarInfoMapper;
import org.mybatis.dynamic.sql.SqlBuilder;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.render.RenderingStrategy;
import org.mybatis.dynamic.sql.select.QueryExpressionDSL;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;

import javax.annotation.Resource;

import static com.chrisren.learnmybatis3.dynamicsql.mapper.TCarInfoDynamicSqlSupport.TCarInfo;
import static com.chrisren.learnmybatis3.dynamicsql.mapper.TCarInfoDynamicSqlSupport.id;
import static org.mybatis.dynamic.sql.SqlBuilder.*;
import static org.mybatis.dynamic.sql.select.SelectDSL.select;

public class Test {

    @Resource
    private TCarInfoMapper carInfoMapper;

    @org.junit.Test
    public void testSelect() {
        SelectStatementProvider select = SqlBuilder.select(TCarInfo.allColumns())
                .from(TCarInfo)
                .where(id, isEqualTo(1L))
                .build()
                .render(RenderingStrategies.MYBATIS3);
        carInfoMapper.selectMany(select);
    }
}
