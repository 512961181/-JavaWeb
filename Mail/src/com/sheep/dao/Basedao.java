package com.sheep.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Basedao {
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//连接
	public static Connection getconn() {
		//创建一个连接对象
		Connection conn=null;
		
		try {
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/sheepmail?useSSL=false&serverTimezone=UTC","root","root");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
		
	}
	
	//执行
	public static int executuIUD(String sql,Object[] params) {
		int count=0;
		
		Connection conn=Basedao.getconn();
		PreparedStatement ps=null;
		try {
			//准备SQL
			ps=conn.prepareStatement(sql);
			for(int i=0;i<params.length;i++) {
				ps.setObject(i+1, params[i]);
			}
			count=ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			Basedao.closeall(null,ps,conn);
		}
		return count;
	}
	//关闭
	public static void closeall(ResultSet rs,PreparedStatement ps,Connection conn) {
		
		try {
			if(rs!=null)
				rs.close();
			
			if(ps!=null) 
				ps.close();
			
			if(conn!=null) 
				conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
