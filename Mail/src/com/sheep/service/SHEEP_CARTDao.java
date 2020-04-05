package com.sheep.service;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.sheep.dao.Basedao;
import com.sheep.entity.SHEEP_CART;
import com.sheep.entity.SHEEP_CATEGORY;
import com.sheep.entity.SHEEP_USER;

public class SHEEP_CARTDao {
	/**
	 * 插入数据到购物车
	 * @param cart
	 * @return
	 */
	public static int insert(SHEEP_CART cart) {
		String sql="insert sheep_cart values(null,?,?,?,?,?,?,?,1)";
		
		Object[] params= {
				cart.getCart_p_filename(),
				cart.getCart_p_name(),
				cart.getCart_p_price(),
				cart.getCart_quantify(),
				cart.getCart_p_stock(),
				cart.getCart_p_id(),
				cart.getCart_u_id()
				
		};
		
		return Basedao.executuIUD(sql, params);
	}
	
	/**
	 * 获取购物车商品数量
	 * @param cartuid
	 * @return
	 */
	public static int totalCart(String cartuid) {
		
		int count=0;
		//声明结果集
		ResultSet rs=null;
		//获取连接对象
		Connection conn=Basedao.getconn();
		
		PreparedStatement ps=null;		
		
		try {
			String sql="select count(*) from SHEEP_CART where cart_u_id=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, cartuid);

			rs=ps.executeQuery();
			
			while(rs.next()) {
				count=rs.getInt(1);				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			Basedao.closeall(rs, ps, conn);
		}
		return count;
	}
	
	
	public static ArrayList<SHEEP_CART> getCart(String id){
		
		ArrayList<SHEEP_CART> list=new ArrayList<SHEEP_CART>();
		//声明结果集
		ResultSet rs=null;
		//获取连接对象
		Connection conn=Basedao.getconn();
		
		PreparedStatement ps=null;		
		
		try {	
			String sql="select * from SHEEP_CART where CART_U_ID=? and CART_VALID=1 order by CART_ID desc";
			ps=conn.prepareStatement(sql);
			ps.setString(1, id);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				SHEEP_CART c=new SHEEP_CART(
							rs.getInt("cart_id"),
							rs.getString("cart_p_filename"),
							rs.getString("cart_p_name"),
							rs.getInt("cart_p_price"),
							rs.getInt("cart_quantify"),
							rs.getInt("cart_p_stock"),
							rs.getInt("cart_p_id"),
							rs.getString("cart_u_id"),
							rs.getInt("cart_valid")
						);
				
				list.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			Basedao.closeall(rs, ps, conn);
		}
		return list;
	}
	
	
	public static SHEEP_CART getCartShop(String  uid,String pid) {
		SHEEP_CART es=null;
		//声明结果集
		ResultSet rs=null;
		//获取连接对象
		Connection conn=Basedao.getconn();
		
		PreparedStatement ps=null;		
		
		try {	
			String sql="select * from SHEEP_CART where CART_U_ID=? and CART_P_ID=? and CART_VALID=1 order by CART_ID desc";
			ps=conn.prepareStatement(sql);
			ps.setString(1, uid);
			ps.setInt(2, Integer.parseInt(pid));
			rs=ps.executeQuery();
			
			while(rs.next()) {
				es=new SHEEP_CART(
							rs.getInt("cart_id"),
							rs.getString("cart_p_filename"),
							rs.getString("cart_p_name"),
							rs.getInt("cart_p_price"),
							rs.getInt("cart_quantify"),
							rs.getInt("cart_p_stock"),
							rs.getInt("cart_p_id"),
							rs.getString("cart_u_id"),
							rs.getInt("cart_valid")
						);
	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			Basedao.closeall(rs, ps, conn);
		}
		return es;
	}
	
	public static SHEEP_CART getCartShop(String  id) {
		SHEEP_CART es=null;
		//声明结果集
		ResultSet rs=null;
		//获取连接对象
		Connection conn=Basedao.getconn();
		
		PreparedStatement ps=null;		
		
		try {	
			String sql="select * from SHEEP_CART where CART_ID=?  and CART_VALID=1 order by CART_ID desc";
			ps=conn.prepareStatement(sql);
			ps.setString(1, id);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				es=new SHEEP_CART(
							rs.getInt("cart_id"),
							rs.getString("cart_p_filename"),
							rs.getString("cart_p_name"),
							rs.getInt("cart_p_price"),
							rs.getInt("cart_quantify"),
							rs.getInt("cart_p_stock"),
							rs.getInt("cart_p_id"),
							rs.getString("cart_u_id"),
							rs.getInt("cart_valid")
						);
	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			Basedao.closeall(rs, ps, conn);
		}
		return es;
	}
	
	
	/**
	 * 按产品的id和产品数量更新数量
	 */
	public static int updatenum (int esid,int count) {
		String sql="update sheep_cart set cart_quantify=? where cart_id=?";
		
		Object[] params= {count,esid};
		return Basedao.executuIUD(sql, params);
	}
	
	public static int getDeleteDD(int id) {
		String sql="delete from sheep_cart where cart_id=?";
		Object[] params= {id};
		return Basedao.executuIUD(sql, params);
		
	}

}
