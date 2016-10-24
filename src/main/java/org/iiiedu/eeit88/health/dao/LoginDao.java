package org.iiiedu.eeit88.health.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.iiiedu.eeit88.health.DbUtils.DbConnection;
import org.iiiedu.eeit88.health.bean.MemberBean;

public class LoginDao {
	
	public MemberBean getMemberByAccount(String account){
		MemberBean mBean = new MemberBean();
		//取Connection
		Connection conn = DbConnection.getConn();
		String sql = "SELECT * FROM member where account = ? ";
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		try {
			pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, account);
			rs = pStmt.executeQuery();
			while (rs.next()) {
				mBean.setId(rs.getInt("id"));
				mBean.setLastname(rs.getString("lastname").trim());
				mBean.setFirstname(rs.getString("firstname").trim());
				mBean.setGender(rs.getString("gender").trim());
				mBean.setBirth(rs.getDate("birth"));
				mBean.setAddr(rs.getString("addr").trim());
				mBean.setBonus(rs.getInt("bonus"));
				mBean.setPhone(rs.getString("phone").trim());
				mBean.setHeight(rs.getFloat("height"));
				mBean.setWeights(rs.getFloat("weights"));
				mBean.setEmail(rs.getString("email").trim());
				mBean.setCity(rs.getString("city").trim());
				mBean.setCounty(rs.getString("county").trim() );
				mBean.setPair(rs.getBoolean("pair"));
				mBean.setAccount(rs.getString("account").trim());
				mBean.setPasswords(rs.getString("passwords").trim());
				mBean.setNickName(rs.getString("nickname").trim());
				
				
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
		
		return mBean;
		
	}

}
