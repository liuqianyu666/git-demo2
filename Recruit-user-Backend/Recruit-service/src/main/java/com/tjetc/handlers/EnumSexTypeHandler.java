package com.tjetc.handlers;

import com.tjetc.enums.EnumCompanyState;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 自定义枚举类型处理器
 */
public class EnumSexTypeHandler implements TypeHandler<EnumCompanyState> {
    /**
     * JDBC操作设置参数，会调用此方法,一般用在insert和update
     * @param ps  JDBC中的ps
     * @param i   参数索引
     * @param parameter Java类型参数
     * @param jdbcType
     * @throws SQLException
     */
    @Override
    public void setParameter(PreparedStatement ps, int i, EnumCompanyState parameter, JdbcType jdbcType) throws SQLException {
//设置参数
        ps.setObject(i,parameter.getCode());
    }

    /**
     * 获取数据结果集转化实体类对象调用此方法，一般用在SELECT,jdbc转化为Java类型
     * @param rs
     * @param columnName
     * @return
     * @throws SQLException
     */
    @Override
    public EnumCompanyState getResult(ResultSet rs, String columnName) throws SQLException {
        //获取结果集，set字段对应的
        Object sexObj = rs.getObject(columnName);
        int sexInt = Integer.parseInt(sexObj.toString());
        EnumCompanyState sex = EnumCompanyState.getByCode(sexInt);
        return sex;
    }

    @Override
    public EnumCompanyState getResult(ResultSet rs, int columnIndex) throws SQLException {
        //获取结果集，set字段对应的
        Object sexObj = rs.getObject(columnIndex);
        int sexInt = Integer.parseInt(sexObj.toString());
        EnumCompanyState sex = EnumCompanyState.getByCode(sexInt);
        return sex;
    }

    /**
     * @param cs
     * @param columnIndex
     * @return
     * @throws SQLException
     */
    @Override
    public EnumCompanyState getResult(CallableStatement cs, int columnIndex) throws SQLException {
        //获取结果集，set字段对应的
        Object sexObj = cs.getObject(columnIndex);
        int sexInt = Integer.parseInt(sexObj.toString());
        EnumCompanyState sex = EnumCompanyState.getByCode(sexInt);
        return sex;
    }
}
