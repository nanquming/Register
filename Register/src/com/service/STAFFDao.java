package com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.dao.Basedao;
import com.entity.STAFF;


public class STAFFDao {
	/**
	 * 加入数据库
	 * @param u
	 * @return
	 */
	public static int insert(STAFF u) {
		String sql="INSERT INTO STAFF(NUMBER,PASSWORD,DESK,SEX,MOBILE) VALUES(?,?,?,?,?)";
			
			Object[] params = {
						u.getNUMBER(), 
						u.getPASSWORD(), 
						u.getDESK(),
						u.getSEX(),
						u.getMOBILE()};
			return Basedao.exectuIUD(sql, params);
	}
	
//通过工号查找
	public static int selectByNumber(String number) {
		int count = 0;
		Connection conn = Basedao.getconn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String sql = "select count(*) from STAFF where NUMBER=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, number);
		    rs = ps.executeQuery();
			 while(rs.next()) {
				 count = rs.getInt(1);
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			Basedao.closeall(rs, ps, conn);
		}
		return count;
	}

	public static ArrayList<STAFF> selectAll(int cpage, int count,String keyword) {
		ArrayList<STAFF> list = new ArrayList<STAFF>();
		//声明结果集
		ResultSet rs = null;
		//获取连接对象
		Connection conn = Basedao.getconn();
		
		PreparedStatement ps = null;
		try {
			String sql = "";
			
			if(keyword!=null) {
				sql = "select * from STAFF where NUMBER like ? order by DESK desc limit ?, ?";
				 ps = conn.prepareStatement(sql);
				 ps.setString(1, "%"+keyword+"%");
				 ps.setInt(2, (cpage-1)*count);
				 ps.setInt(3, count);
			}else{
				sql = "select * from STAFF order by DESK desc limit ?, ?";
				 ps = conn.prepareStatement(sql);
				 ps.setInt(1, (cpage-1)*count);
				 ps.setInt(2, count);
			}
			 rs = ps.executeQuery();
			 
			 while(rs.next()) {
				 STAFF u = new STAFF(
						 	rs.getString("NUMBER"),
						 	rs.getString("PASSWORD"),
						 	rs.getString("DESK"),
						 	rs.getString("SEX"),
						 	rs.getString("MOBILE") );
				 list.add(u);
			 } 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Basedao.closeall(rs, ps, conn);
		}
		return list;
	}
}
