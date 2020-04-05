package com.sheep.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.sheep.dao.Basedao;
import com.sheep.entity.SHEEP_USER;

public class SHEEP_USERDao {
	
	/**
	 * ���ݼ��뵽���ݿ���
	 * @param u
	 * @return
	 */
	public static int insert(SHEEP_USER u) {
		String sql="insert into SHEEP_USER values(?,?,?,?,?,?,?,?,?,?)";
		
		Object[] params= {
				u.getUSER_ID(),
				u.getUSER_NAME(),
				u.getUSER_PASSWORD(),
				u.getUSER_SEX(),
				u.getUSER_BIRTHDAY(),
				u.getUSER_IDENITY_CODE(),
				u.getUSER_EMAIL(),
				u.getUSER_MOBILE(),
				u.getUSER_ADDRESS(),
				u.getUSER_STATUS()};
		return Basedao.executuIUD(sql, params);
		
	}
	
	/**
	 * �����ݿ�ɾ��һ���û�
	 * @param id
	 * @return
	 */
	public static int del(String id) {
		String sql="delete from SHEEP_USER where USER_ID=? and USER_STATUS!=2";
		Object[] params= {id};
		return Basedao.executuIUD(sql, params);
	}
	
	/**
	 * �����޸ĵ����ݿ���
	 * @param u
	 * @return
	 */
	public static int update(SHEEP_USER u) {
		String sql="update SHEEP_USER set USER_NAME=?,USER_PASSWORD=?,USER_SEX=?,USER_BIRTHDAY=DATE_FORMAT(?,'%Y-%m-%d'),USER_IDENITY_CODE=?,USER_EMAIL=?,USER_MOBILE=?,USER_ADDRESS=?,USER_STATUS=? where USER_ID=?";
		
		
		Object[] params= {
				u.getUSER_NAME(),
				u.getUSER_PASSWORD(),
				u.getUSER_SEX(),
				u.getUSER_BIRTHDAY(),
				u.getUSER_IDENITY_CODE(),
				u.getUSER_EMAIL(),
				u.getUSER_MOBILE(),
				u.getUSER_ADDRESS(),
				u.getUSER_STATUS(),
				u.getUSER_ID()};
		return Basedao.executuIUD(sql, params);
		
	}
	
	/**
	 * ��ȡ�ܼ�¼������ҳ��
	 * @param count
	 * @return
	 */
	public static int[] totalPage(int count,String keyword) {
		int arr[]= {0,1};//0���ܼ�¼����1����ҳ��
		Connection conn=Basedao.getconn();
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		
		try {
			String sql="";
			if(keyword!=null) {
				sql="select count(*) from SHEEP_USER where USER_NAME like ?";
				ps=conn.prepareStatement(sql);
				ps.setString(1, "%"+keyword+"%");
			}else {
				sql="select count(*) from SHEEP_USER";
				ps=conn.prepareStatement(sql);
			}
			
			rs=ps.executeQuery();
			while(rs.next()) {
				arr[0]=rs.getInt(1);
				if(arr[0]%count==0) {
					arr[1]=arr[0]/count;
				}else {
					arr[1]=arr[0]/count+1;
				}
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			Basedao.closeall(rs, ps, conn);
		}
		return arr;
	}
	
	/**
	 * ��ID�������ݿ����Ƿ���ڸ��û�
	 * @param count
	 * @return
	 */
	public static int selectByName(String id) {
		int count= 0;//���ҽ����1Ϊ�ҵ�������Ϊû�ҵ�
		Connection conn=Basedao.getconn();
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		
		try {
			String sql="select count(*) from SHEEP_USER where USER_ID=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, id);
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
	
	/**
	 * ���ؼ��ֲ������м�¼����ҳ
	 * @param cpage
	 * @param count
	 * @param keyword
	 * @return
	 */
	public static ArrayList<SHEEP_USER> selectAll(int cpage,int count,String keyword){
		
		ArrayList<SHEEP_USER> list=new ArrayList<SHEEP_USER>();
		//���������
		ResultSet rs=null;
		//��ȡ���Ӷ���
		Connection conn=Basedao.getconn();
		
		PreparedStatement ps=null;		
		
		try {
			String sql="";
			if(keyword !=null) {
				sql="select * from SHEEP_USER where USER_NAME like ? order by USER_BIRTHDAY desc limit ? ,?";
				ps=conn.prepareStatement(sql);
				ps.setString(1, "%"+keyword+"%");
				ps.setInt(2, (cpage-1)*count);
				ps.setInt(3, count);
			}else {
				sql="select * from SHEEP_USER order by USER_BIRTHDAY desc limit ? ,?";
				ps=conn.prepareStatement(sql);
				ps.setInt(1, (cpage-1)*count);
				ps.setInt(2, count);
			}
			
	
			rs=ps.executeQuery();
			
			while(rs.next()) {
				SHEEP_USER u=new SHEEP_USER(
							rs.getString("USER_ID"),
							rs.getString("USER_NAME"),
							rs.getString("USER_PASSWORD"),
							rs.getString("USER_SEX"),
							rs.getString("USER_BIRTHDAY"),
							rs.getString("USER_IDENITY_CODE"),
							rs.getString("USER_EMAIL"),
							rs.getString("USER_MOBILE"),
							rs.getString("USER_ADDRESS"),
							rs.getInt("USER_STATUS")
						);
				
				list.add(u);
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
	 * ͨ��ID�����û�
	 */
	public static SHEEP_USER selectById(String id){
		
		SHEEP_USER u=null;
		//���������
		ResultSet rs=null;
		//��ȡ���Ӷ���
		Connection conn=Basedao.getconn();
		
		PreparedStatement ps=null;		
		
		try {
			String sql="select m.*, DATE_FORMAT(m.user_birthday,'%Y-%m-%d') birthday from SHEEP_USER m where USER_ID= ?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, id);

			rs=ps.executeQuery();
			
			while(rs.next()) {
				u=new SHEEP_USER(
							rs.getString("USER_ID"),
							rs.getString("USER_NAME"),
							rs.getString("USER_PASSWORD"),
							rs.getString("USER_SEX"),
							rs.getString("birthday"),
							rs.getString("USER_IDENITY_CODE"),
							rs.getString("USER_EMAIL"),
							rs.getString("USER_MOBILE"),
							rs.getString("USER_ADDRESS"),
							rs.getInt("USER_STATUS")
						);
	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			Basedao.closeall(rs, ps, conn);
		}
		return u;
	}
	/**
	 * ��¼��֤
	 * @param name
	 * @param pwd
	 * @return
	 */
	public static int selectByNM(String name,String pwd) {
		int count= 0;//���ҽ����1Ϊ�ҵ�������Ϊû�ҵ�
		Connection conn=Basedao.getconn();
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		
		try {
			String sql="select count(*) from SHEEP_USER where USER_ID=? and USER_PASSWORD=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, pwd);
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
	
	/**
	 * ͨ���û����������ѯ�û���Ϣ
	 * @param name
	 * @param pwd
	 * @return
	 */
	public static SHEEP_USER selsectAdmin(String name,String pwd) {
		SHEEP_USER u=null;
		//���������
		ResultSet rs=null;
		//��ȡ���Ӷ���
		Connection conn=Basedao.getconn();
		
		PreparedStatement ps=null;		
		
		try {
			String sql="select m.*, DATE_FORMAT(m.user_birthday,'%Y-%m-%d') birthday from SHEEP_USER m where USER_ID= ? and USER_PASSWORD=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, pwd);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				u=new SHEEP_USER(
							rs.getString("USER_ID"),
							rs.getString("USER_NAME"),
							rs.getString("USER_PASSWORD"),
							rs.getString("USER_SEX"),
							rs.getString("birthday"),
							rs.getString("USER_IDENITY_CODE"),
							rs.getString("USER_EMAIL"),
							rs.getString("USER_MOBILE"),
							rs.getString("USER_ADDRESS"),
							rs.getInt("USER_STATUS")
						);
	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			Basedao.closeall(rs, ps, conn);
		}
		return u;
	}
	

}
