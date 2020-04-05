package com.sheep.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.sheep.dao.Basedao;
import com.sheep.entity.SHEEP_CATEGORY;
import com.sheep.entity.SHEEP_PRODUCT;


public class SHEEP_PRODUCTDao {
	
	/**
	 * 添加产品
	 * @param p
	 * @return
	 */
	public static int insert(SHEEP_PRODUCT p) {
		String sql="insert into SHEEP_PRODUCT values(null,?,?,?,?,?,?,?)";
		
		Object[] params= {
				p.getPRODUCT_NAME(),
				p.getPRODUCT_DESCRIPTION(),
				p.getPRODUCT_PRICE(),
				p.getPRODUCT_STOCK(),
				p.getPRODUCT_FID(),
				p.getPRODUCT_CID(),
				p.getPRODUCT_FILENAME()};
		return Basedao.executuIUD(sql, params);
		
	}
	
	
	/**
	 * 查询所有产品
	 * @return
	 */
	public static ArrayList<SHEEP_PRODUCT> selectAll(){
		
		ArrayList<SHEEP_PRODUCT> list=new ArrayList<SHEEP_PRODUCT>();
		//声明结果集
		ResultSet rs=null;
		//获取连接对象
		Connection conn=Basedao.getconn();
		
		PreparedStatement ps=null;		
		
		try {
			String sql="select * from SHEEP_PRODUCT";			
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				SHEEP_PRODUCT p=new SHEEP_PRODUCT(
							rs.getInt("PRODUCT_ID"),
							rs.getString("PRODUCT_NAME"),
							rs.getString("PRODUCT_DESCRIPTION"),
							rs.getInt("PRODUCT_PRICE"),
							rs.getInt("PRODUCT_STOCK"),
							rs.getInt("PRODUCT_FID"),
							rs.getInt("PRODUCT_CID"),
							rs.getString("PRODUCT_FILENAME")
						);
				
				list.add(p);
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
	 * 通过父id查找
	 * @param fid
	 * @return
	 */
	public static ArrayList<SHEEP_PRODUCT> selectAllByFid(int fid){
		
		ArrayList<SHEEP_PRODUCT> list=new ArrayList<SHEEP_PRODUCT>();
		//声明结果集
		ResultSet rs=null;
		//获取连接对象
		Connection conn=Basedao.getconn();
		
		PreparedStatement ps=null;		
		
		try {
			String sql="select * from SHEEP_PRODUCT where PRODUCT_FID=?";			
			ps=conn.prepareStatement(sql);
			ps.setInt(1, fid);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				SHEEP_PRODUCT p=new SHEEP_PRODUCT(
							rs.getInt("PRODUCT_ID"),
							rs.getString("PRODUCT_NAME"),
							rs.getString("PRODUCT_DESCRIPTION"),
							rs.getInt("PRODUCT_PRICE"),
							rs.getInt("PRODUCT_STOCK"),
							rs.getInt("PRODUCT_FID"),
							rs.getInt("PRODUCT_CID"),
							rs.getString("PRODUCT_FILENAME")
						);
				
				list.add(p);
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
	 * 通过子id查找
	 * @param fid
	 * @return
	 */
	public static ArrayList<SHEEP_PRODUCT> selectAllByCid(int cid){
		
		ArrayList<SHEEP_PRODUCT> list=new ArrayList<SHEEP_PRODUCT>();
		//声明结果集
		ResultSet rs=null;
		//获取连接对象
		Connection conn=Basedao.getconn();
		
		PreparedStatement ps=null;		
		
		try {
			String sql="select * from SHEEP_PRODUCT where PRODUCT_CID=?";			
			ps=conn.prepareStatement(sql);
			ps.setInt(1, cid);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				SHEEP_PRODUCT p=new SHEEP_PRODUCT(
							rs.getInt("PRODUCT_ID"),
							rs.getString("PRODUCT_NAME"),
							rs.getString("PRODUCT_DESCRIPTION"),
							rs.getInt("PRODUCT_PRICE"),
							rs.getInt("PRODUCT_STOCK"),
							rs.getInt("PRODUCT_FID"),
							rs.getInt("PRODUCT_CID"),
							rs.getString("PRODUCT_FILENAME")
						);
				
				list.add(p);
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
	 * 通过id找对象
	 * @param id
	 * @return
	 */
	public static SHEEP_PRODUCT selectById(int id){
		
		SHEEP_PRODUCT p=null;
		//声明结果集
		ResultSet rs=null;
		//获取连接对象
		Connection conn=Basedao.getconn();
		
		PreparedStatement ps=null;		
		
		try {
			String sql="select * from SHEEP_PRODUCT where PRODUCT_ID=?";			
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				p=new SHEEP_PRODUCT(
							rs.getInt("PRODUCT_ID"),
							rs.getString("PRODUCT_NAME"),
							rs.getString("PRODUCT_DESCRIPTION"),
							rs.getInt("PRODUCT_PRICE"),
							rs.getInt("PRODUCT_STOCK"),
							rs.getInt("PRODUCT_FID"),
							rs.getInt("PRODUCT_CID"),
							rs.getString("PRODUCT_FILENAME")
						);
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			Basedao.closeall(rs, ps, conn);
		}
		return p;
	}
	
	public static ArrayList<SHEEP_PRODUCT> selectAllById(ArrayList<Integer> ids){
		
		ArrayList<SHEEP_PRODUCT> lastlylist=new ArrayList<SHEEP_PRODUCT>();
		
		SHEEP_PRODUCT p=null;
		//声明结果集
		ResultSet rs=null;
		//获取连接对象
		Connection conn=Basedao.getconn();
		
		PreparedStatement ps=null;		
		
		try {
			
			for(int i=0;i<ids.size();i++) {
				String sql="select * from SHEEP_PRODUCT where PRODUCT_ID=?";			
				ps=conn.prepareStatement(sql);
				ps.setInt(1, ids.get(i));
				rs=ps.executeQuery();
				
				while(rs.next()) {
					p=new SHEEP_PRODUCT(
								rs.getInt("PRODUCT_ID"),
								rs.getString("PRODUCT_NAME"),
								rs.getString("PRODUCT_DESCRIPTION"),
								rs.getInt("PRODUCT_PRICE"),
								rs.getInt("PRODUCT_STOCK"),
								rs.getInt("PRODUCT_FID"),
								rs.getInt("PRODUCT_CID"),
								rs.getString("PRODUCT_FILENAME")
							);
					
					lastlylist.add(p);
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			Basedao.closeall(rs, ps, conn);
		}
		return lastlylist;
	}
	
}
