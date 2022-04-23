package com.chrisren.learnmybatis3.dynamicsql.mapper;

import java.sql.JDBCType;
import java.util.Date;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

public final class TCarInfoDynamicSqlSupport {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final TCarInfo TCarInfo = new TCarInfo();

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> id = TCarInfo.id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> carNo = TCarInfo.carNo;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> carName = TCarInfo.carName;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> createdBy = TCarInfo.createdBy;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Date> createdDate = TCarInfo.createdDate;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> updatedBy = TCarInfo.updatedBy;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Date> updatedDate = TCarInfo.updatedDate;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final class TCarInfo extends AliasableSqlTable<TCarInfo> {
        public final SqlColumn<Long> id = column("id", JDBCType.BIGINT);

        public final SqlColumn<String> carNo = column("car_no", JDBCType.VARCHAR);

        public final SqlColumn<String> carName = column("car_name", JDBCType.VARCHAR);

        public final SqlColumn<String> createdBy = column("created_by", JDBCType.VARCHAR);

        public final SqlColumn<Date> createdDate = column("created_date", JDBCType.TIMESTAMP);

        public final SqlColumn<String> updatedBy = column("updated_by", JDBCType.VARCHAR);

        public final SqlColumn<Date> updatedDate = column("updated_date", JDBCType.TIMESTAMP);

        public TCarInfo() {
            super("t_car_info", TCarInfo::new);
        }
    }
}