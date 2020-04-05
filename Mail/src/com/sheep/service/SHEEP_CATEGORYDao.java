package com.sheep.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.sheep.dao.Basedao;
import com.sheep.entity.SHEEP_CATEGORY;
import com.sheep.entity.SHEEP_USER;

public class SHEEP_CATEGORYDao {
/**
 * 获取所有分类
 * @return
 */
	public static ArrayList<SHEEP_CATEGORY> selectAll(){
		
		ArrayList<SHEEP_CATEGORY> list=new ArrayList<SHEEP_CATEGORY>();
		//声明结果集
		ResultSet rs=null;
		//获取连接对象
		Connection conn=Basedao.getconn();
		
		PreparedStatement ps=null;		
		
		try {
			String sql="select * from SHEEP_CATEGORY";			
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				SHEEP_CATEGORY cate=new SHEEP_CATEGORY(
						     	rs.getInt("CATE_ID"),
							rs.getString("CATE_NAME"),
							rs.getInt("CATE_PARENT_ID")
						);
				
				list.add(cate);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			Basedao.closeall(rs, ps, conn);
		}
		return list;
	}
	
	/**
	 * 添加分类
	 * @param cate
	 * @return
	 */
	public static int insert(SHEEP_CATEGORY cate) {
		String sql="insert into SHEEP_CATEGORY values(null,?,?)";
		
		Object[] params= {
				cate.getCATE_NAME(),
				cate.getCATE_PARENT_ID()};
		return Basedao.executuIUD(sql, params);
		
	}
	
	
	public static SHEEP_CATEGORY selectById(int id){
		
		SHEEP_CATEGORY cate=null;
		//声明结果集
		ResultSet rs=null;
		//获取连接对象
		Connection conn=Basedao.getconn();
		
		PreparedStatement ps=null;		
		
		try {
			String sql="select * from SHEEP_CATEGORY where CATE_ID=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);

			rs=ps.executeQuery();
			
			while(rs.next()) {
				cate=new SHEEP_CATEGORY(
							rs.getInt("CATE_ID"),
							rs.getString("CATE_NAME"),
							rs.getInt("CATE_PARENT_ID")
						);
	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			Basedao.closeall(rs, ps, conn);
		}
		return cate;
	}
	
	/**
	 * 修改分类
	 * @param cate
	 * @return
	 */
	public static int update(SHEEP_CATEGORY cate) {
		String sql="update SHEEP_CATEGORY set CATE_NAME=?,CATE_PARENT_ID=? where CATE_ID=?";
		
		
		Object[] params= {
				cate.getCATE_NAME(),
				cate.getCATE_PARENT_ID(),
				cate.getCATE_ID(),
				};
		return Basedao.executuIUD(sql, params);
		
	}
	
	
	public static int del(int id) {
		String sql="delete from SHEEP_CATEGORY where CATE_ID=?";
		
		Object[] params= {id};
		return Basedao.executuIUD(sql, params);
	}
	
	
	/**
	 * 查询子分类和父级分类
	 * flag：falg="father" flag="child"
	 * @return
	 */
	public static ArrayList<SHEEP_CATEGORY> selectCat(String flag){
		
		ArrayList<SHEEP_CATEGORY> list=new ArrayList<SHEEP_CATEGORY>();
		//声明结果集
		ResultSet rs=null;
		//获取连接对象
		Connection conn=Basedao.getconn();
		
		PreparedStatement ps=null;		
		
		try {
			String sql=null;
			
			if(flag!=null && flag.equals("father")){
				sql="select * from SHEEP_CATEGORY where CATE_PARENT_ID=0";			
			}else{
				sql="select * from SHEEP_CATEGORY where CATE_PARENT_ID !=0";			
			}
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				SHEEP_CATEGORY cate=new SHEEP_CATEGORY(
						     	rs.getInt("CATE_ID"),
							rs.getString("CATE_NAME"),
							rs.getInt("CATE_PARENT_ID")
						);
				
				list.add(cate);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			Basedao.closeall(rs, ps, conn);
		}
		return list;
	}
}
