package com.chrisren.learnmybatis3.dynamicsql.mapper;

import static com.chrisren.learnmybatis3.dynamicsql.mapper.TCarInfoDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

import com.chrisren.learnmybatis3.dynamicsql.entity.TCarInfo;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import javax.annotation.Generated;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.dynamic.sql.BasicColumn;
import org.mybatis.dynamic.sql.delete.DeleteDSLCompleter;
import org.mybatis.dynamic.sql.select.CountDSLCompleter;
import org.mybatis.dynamic.sql.select.SelectDSLCompleter;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.update.UpdateDSL;
import org.mybatis.dynamic.sql.update.UpdateDSLCompleter;
import org.mybatis.dynamic.sql.update.UpdateModel;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;
import org.mybatis.dynamic.sql.util.mybatis3.CommonCountMapper;
import org.mybatis.dynamic.sql.util.mybatis3.CommonDeleteMapper;
import org.mybatis.dynamic.sql.util.mybatis3.CommonInsertMapper;
import org.mybatis.dynamic.sql.util.mybatis3.CommonUpdateMapper;
import org.mybatis.dynamic.sql.util.mybatis3.MyBatis3Utils;

@Mapper
public interface TCarInfoMapper extends CommonCountMapper, CommonDeleteMapper, CommonInsertMapper<TCarInfo>, CommonUpdateMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(id, carNo, carName, createdBy, createdDate, updatedBy, updatedDate);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="TCarInfoResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="car_no", property="carNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="car_name", property="carName", jdbcType=JdbcType.VARCHAR),
        @Result(column="created_by", property="createdBy", jdbcType=JdbcType.VARCHAR),
        @Result(column="created_date", property="createdDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updated_by", property="updatedBy", jdbcType=JdbcType.VARCHAR),
        @Result(column="updated_date", property="updatedDate", jdbcType=JdbcType.TIMESTAMP)
    })
    List<TCarInfo> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("TCarInfoResult")
    Optional<TCarInfo> selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, TCarInfo, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, TCarInfo, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Long id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(TCarInfo row) {
        return MyBatis3Utils.insert(this::insert, row, TCarInfo, c ->
            c.map(id).toProperty("id")
            .map(carNo).toProperty("carNo")
            .map(carName).toProperty("carName")
            .map(createdBy).toProperty("createdBy")
            .map(createdDate).toProperty("createdDate")
            .map(updatedBy).toProperty("updatedBy")
            .map(updatedDate).toProperty("updatedDate")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertMultiple(Collection<TCarInfo> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, TCarInfo, c ->
            c.map(id).toProperty("id")
            .map(carNo).toProperty("carNo")
            .map(carName).toProperty("carName")
            .map(createdBy).toProperty("createdBy")
            .map(createdDate).toProperty("createdDate")
            .map(updatedBy).toProperty("updatedBy")
            .map(updatedDate).toProperty("updatedDate")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(TCarInfo row) {
        return MyBatis3Utils.insert(this::insert, row, TCarInfo, c ->
            c.map(id).toPropertyWhenPresent("id", row::getId)
            .map(carNo).toPropertyWhenPresent("carNo", row::getCarNo)
            .map(carName).toPropertyWhenPresent("carName", row::getCarName)
            .map(createdBy).toPropertyWhenPresent("createdBy", row::getCreatedBy)
            .map(createdDate).toPropertyWhenPresent("createdDate", row::getCreatedDate)
            .map(updatedBy).toPropertyWhenPresent("updatedBy", row::getUpdatedBy)
            .map(updatedDate).toPropertyWhenPresent("updatedDate", row::getUpdatedDate)
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<TCarInfo> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, TCarInfo, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<TCarInfo> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, TCarInfo, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<TCarInfo> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, TCarInfo, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<TCarInfo> selectByPrimaryKey(Long id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, TCarInfo, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(TCarInfo row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(row::getId)
                .set(carNo).equalTo(row::getCarNo)
                .set(carName).equalTo(row::getCarName)
                .set(createdBy).equalTo(row::getCreatedBy)
                .set(createdDate).equalTo(row::getCreatedDate)
                .set(updatedBy).equalTo(row::getUpdatedBy)
                .set(updatedDate).equalTo(row::getUpdatedDate);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(TCarInfo row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(row::getId)
                .set(carNo).equalToWhenPresent(row::getCarNo)
                .set(carName).equalToWhenPresent(row::getCarName)
                .set(createdBy).equalToWhenPresent(row::getCreatedBy)
                .set(createdDate).equalToWhenPresent(row::getCreatedDate)
                .set(updatedBy).equalToWhenPresent(row::getUpdatedBy)
                .set(updatedDate).equalToWhenPresent(row::getUpdatedDate);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(TCarInfo row) {
        return update(c ->
            c.set(carNo).equalTo(row::getCarNo)
            .set(carName).equalTo(row::getCarName)
            .set(createdBy).equalTo(row::getCreatedBy)
            .set(createdDate).equalTo(row::getCreatedDate)
            .set(updatedBy).equalTo(row::getUpdatedBy)
            .set(updatedDate).equalTo(row::getUpdatedDate)
            .where(id, isEqualTo(row::getId))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(TCarInfo row) {
        return update(c ->
            c.set(carNo).equalToWhenPresent(row::getCarNo)
            .set(carName).equalToWhenPresent(row::getCarName)
            .set(createdBy).equalToWhenPresent(row::getCreatedBy)
            .set(createdDate).equalToWhenPresent(row::getCreatedDate)
            .set(updatedBy).equalToWhenPresent(row::getUpdatedBy)
            .set(updatedDate).equalToWhenPresent(row::getUpdatedDate)
            .where(id, isEqualTo(row::getId))
        );
    }
}