package com.njit.TypeHandler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class DateTypeHandler extends BaseTypeHandler<Date> {
    //将java类型转换成数据库需要的类型
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, Date date, JdbcType jdbcType) throws SQLException {
        //i是位置，date.getTime()将日期转换成毫秒值
        preparedStatement.setLong(i,date.getTime());
    }

    //将数据库中类型转换成java类型
    //String参数 要转换的字段名称
    //ResultSet 查询出的结果集
    @Override
    public Date getNullableResult(ResultSet resultSet, String s) throws SQLException {
        //获取结果集中需要的数据
        long aLong = resultSet.getLong(s);
        Date date=new Date(aLong);
        return date;
    }
    //将数据库中类型转换成java类型
    @Override
    public Date getNullableResult(ResultSet resultSet, int i) throws SQLException {
        //获取结果集中需要的数据
        long aLong = resultSet.getLong(i);
        Date date=new Date(aLong);
        return date;
    }
    //将数据库中类型转换成java类型
    @Override
    public Date getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        long aLong = callableStatement.getLong(i);
        Date date=new Date(aLong);
        return date;
    }
}
