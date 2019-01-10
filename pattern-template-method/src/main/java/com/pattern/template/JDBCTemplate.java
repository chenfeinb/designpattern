package com.pattern.template;

import com.pattern.util.RowMapper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/11/27 0027.
 */
public  class JDBCTemplate {

    //连接MySql数据库，用户名和密码都是root
    String url = "jdbc:mysql://localhost:3306/test" ;
    String username = "root" ;
    String password = "root" ;


    private Connection getConnection() throws Exception{
        Class.forName("com.mysql.jdbc.Driver") ;
        Connection con =  DriverManager.getConnection(url , username , password ) ;

        return con;
    }

    private PreparedStatement createPrepareStatement(Connection conn,String sql) throws Exception{
        return conn.prepareStatement(sql);
    }

    private void closeStatement(Statement s) throws SQLException {
        s.close();
    }

    private void closeResult(ResultSet s) throws SQLException {
        s.close();
    }

    private void closeConn(Connection c) throws SQLException {
        c.close();
    }

    private ResultSet executeQuest(PreparedStatement ps ,Object[] values) throws SQLException {
        for(int i = 0; i < values.length ; i ++){
            ps.setObject(i,values[i]);
        }
        return  ps.executeQuery();
    }


    private List<Object> parseResultSet(ResultSet rs, RowMapper rowMapper ) throws Exception {
        List<Object> result = new ArrayList<Object>();
        int rowNum = 1;
        while (rs.next()){
            Object obj = rowMapper.mapRow(rs,rowNum++ );
            result.add(obj);
        }
        return result;
    }

    public List<Object> executeQuery(String sql, RowMapper<?> rowMapper, Object[] values) throws Exception {

        // 1.获取连接
        try {
        Connection conn = this.getConnection();
        // 2.创建语句
        PreparedStatement ps = createPrepareStatement(conn, sql);
        // 3.执行sql语句，并且获得结果集
        ResultSet rs = executeQuest(ps,values);
        // 4.解析语句集
        List<Object> result = this.parseResultSet(rs, rowMapper);
        // 5.关闭结果集
        this.closeResult(rs);
        // 6.关闭语句集
        this.closeStatement(ps);
        // 7.关闭连接
        this.closeConn(conn);

        return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

//    public abstract Object processResult(ResultSet resultSet, int i) throws SQLException;

}
