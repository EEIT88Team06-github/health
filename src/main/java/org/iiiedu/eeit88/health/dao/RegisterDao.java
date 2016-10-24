package org.iiiedu.eeit88.health.dao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

import org.iiiedu.eeit88.health.DbUtils.DbConnection;
import org.iiiedu.eeit88.health.bean.MemberBean;
import org.iiiedu.eeit88.health.global.GlobalService;

public class RegisterDao {
	
	public boolean idExists(String account){
		
		boolean result = false;
		//取Connection
		Connection conn = DbConnection.getConn();
		String sql = "SELECT 1 FROM member where account = ? ";
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		try {
			pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, account);
			rs = pStmt.executeQuery();
			while (rs.next()) {
				result = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return result;
		
	}
	
	public int saveMember(MemberBean mb, InputStream is, long size) throws SQLException {
		
		
		PreparedStatement pstmt1 = null;
		Connection conn = DbConnection.getConn();
		int r = 0;
		try {
			String sql1 = "insert into member "
					+ " (lastname,firstname,gender,nickname,birth,"
					+ " phone,account,passwords,height,weights,email,city,county,addr,bonus,picture,pair) "
					+ " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

			pstmt1 = conn.prepareStatement(sql1);
			pstmt1.setString(1, mb.getLastname());
			pstmt1.setString(2, mb.getFirstname());
			pstmt1.setString(3, mb.getGender());
			pstmt1.setString(4, mb.getNickName());
			pstmt1.setDate(5,  mb.getBirth());
			pstmt1.setString(6, mb.getPhone());
			pstmt1.setString(7, mb.getAccount());
//			String encrypedString = GlobalService.encryptString(mb.getPasswords());
//			pstmt1.setString(8, GlobalService.getMD5Endocing(encrypedString));System.out.println("password>>>>>>>>>"+GlobalService.getMD5Endocing(encrypedString));
			pstmt1.setString(8, mb.getPasswords());
			pstmt1.setFloat(9, mb.getHeight());
			System.out.println("sql>>>>>>>"+mb.getWeights());
			pstmt1.setFloat(10, mb.getWeights());
			pstmt1.setString(11, mb.getEmail());
			pstmt1.setString(12, mb.getCity());
			pstmt1.setString(13, mb.getCounty());
			pstmt1.setString(14, mb.getAddr());
			pstmt1.setInt(15, mb.getBonus());
			pstmt1.setBinaryStream(16, is, size);
			pstmt1.setBoolean(17,  mb.isPair());
			// 設定Image欄位
			// pstmt1.setBlob(11, is, size); // 此方法目前未支援
			//pstmt1.setBinaryStream(11, is, size);
			
			r = pstmt1.executeUpdate();
			conn.commit();
			if (r == 1) {
				
			} else {
				throw new SQLException("RegisterServiceDB:新增記錄數 : 0");
			}
			// System.out.println("新增一筆eMember紀錄，是否成功=" + r);
		} finally {
			// 關閉相關的物件
			if (pstmt1 != null) {
				try {
					pstmt1.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					System.err.println("關閉相關物件時發生例外: " + e);
				}
			}
		}
		
		return r;
	}
	

	
}
