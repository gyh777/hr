package com.hr.web.interceptor;


import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.apache.ibatis.executor.resultset.ResultSetHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;

import com.hr.pojo.Common;

@Intercepts({
    @Signature(type = StatementHandler.class, method = "prepare", args = {Connection.class,Integer.class}),  
})
public class MypageInterceptor implements Interceptor {
	
	

	@Override
	public Object intercept(Invocation invocation) throws InvocationTargetException, IllegalAccessException{
		StatementHandler statementHandler = (StatementHandler) invocation.getTarget();  
		 MetaObject metaStatementHandler = SystemMetaObject.forObject(statementHandler);  
		 MappedStatement mappedStatement=(MappedStatement) metaStatementHandler.getValue("delegate.mappedStatement");
		 String selectId=mappedStatement.getId();
		 BoundSql boundSql = (BoundSql) metaStatementHandler.getValue("delegate.boundSql"); // 分页参数作为参数对象parameterObject的一个属性  String sql = boundSql.getSql();
		 String sql = boundSql.getSql();
		 Common co=(Common)(boundSql.getParameterObject());
		 String countSql=concatCountSql(sql);
		 String pageSql=concatPageSql(sql,co);
		 Connection connection = (Connection) invocation.getArgs()[0];  
         
         PreparedStatement countStmt = null;  
         ResultSet rs = null; 
         int totalCount = 0;
         try { 
             countStmt = connection.prepareStatement(countSql);  
             rs = countStmt.executeQuery();
             if (rs.next()) {  
                 totalCount = rs.getInt(1);  
             } 
         } catch (SQLException e) {  
             System.out.println("Ignore this exception"+e);  
         } finally { try {  
                 rs.close();  
                 countStmt.close();  
             } catch (SQLException e) {  
                 System.out.println("Ignore this exception"+ e);  
             }  
         } //绑定count 
         co.setCount(totalCount);
         metaStatementHandler.setValue("delegate.boundSql.sql", pageSql);
	    return invocation.proceed();
	}

	@Override
	public Object plugin(Object target) {
		 if (target instanceof StatementHandler) {  
	            return Plugin.wrap(target, this);  
	        } else {  
	            return target;  
	        } 
	}

	@Override
	public void setProperties(Properties properties) {
	}
	
	public String concatCountSql(String sql){
        StringBuffer sb=new StringBuffer("select count(*) from ");
        sql=sql.toLowerCase(); if(sql.lastIndexOf("order")>sql.lastIndexOf(")")){
            sb.append(sql.substring(sql.indexOf("from")+4, sql.lastIndexOf("order")));
        }else{
            sb.append(sql.substring(sql.indexOf("from")+4));
        } 
        return sb.toString();
    } public String concatPageSql(String sql,Common co){
        StringBuffer sb=new StringBuffer();
        sb.append(sql);
        sb.append(" limit ").append(co.getagebegin()).append(" , ").append(co.getPagesize()); return sb.toString();
    }

}
