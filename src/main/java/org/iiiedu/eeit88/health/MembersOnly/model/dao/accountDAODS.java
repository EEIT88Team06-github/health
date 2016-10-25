package org.iiiedu.eeit88.health.MembersOnly.model.dao;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.iiiedu.eeit88.health.MembersOnly.model.accountBean;
import org.iiiedu.eeit88.health.MembersOnly.model.accountDAO;

public class accountDAODS implements accountDAO{
	
//	public static final String DB_URL = "jdbc:sqlserver://localhost:1433;database=health";
//	public static final String DB_USER = "sa";
//	public static final String DB_PASSWORD = "passw0rd";
	
	private DataSource dataSource;
	public accountDAODS(){
	try {
		Context ctx = new InitialContext();
		dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/health");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
//-----------------------------------------------------------------------

	private static final String SELECT_BY_ID = "select * from member where id =?";
	@Override
	public accountBean select(int id) {
		 accountBean result = null;
		 ResultSet rs = null;
		
		 try {	
//		 		Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			 	Connection conn = dataSource.getConnection();
			 	PreparedStatement ract = conn.prepareStatement(SELECT_BY_ID);
				ract.setInt(1,id);
				rs = ract.executeQuery();
			 
			 if(rs.next()) {
				result = new accountBean();
				result.setId(rs.getInt("id"));
//				result.setPasswords(rs.getBytes("passwords"));
				result.setEmail(rs.getString("email"));
				result.setBirth(rs.getDate("birth"));
				result.setLastname(rs.getString("lastname"));
				result.setFirstname(rs.getString("firstname"));
				result.setGender(rs.getString("gender"));
				result.setNickname(rs.getString("nickname"));
				result.setPhone(rs.getString("phone"));
				result.setAccount(rs.getString("account"));
				result.setCity(rs.getString("city"));
				result.setConunty(rs.getString("conunty"));
				result.setAddr(rs.getString("addr"));
				result.setBonus(rs.getInt("bonus"));
				result.setPair(rs.getString("pair"));
				result.setHeight(rs.getFloat("height"));
				result.setWeights(rs.getFloat("weights"));
				
				Blob b = rs.getBlob("picture");
//				byte[] picture = b.getBytes(1, (int)b.length());
//				result.setPicture(picture);
				
////			result.setPicture(rs.getBlob("picture"));
//				Blob picture = rs.getBlob("picture");
//				result.setPicture(picture);				
				
				} 
			} catch (SQLException e) {
				e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}
	

//	private static final String UPDATE = "update member set lastname=?,"
//			+ "firstname=?,nickname=?,phone=?,pair=?,city=?,conunty=?,addr=?,passwords=?,picture=? where id=?";
	private static final String UPDATE = "update member set lastname=?," + "firstname=?,nickname=?,phone=?,pair=?,city=?,conunty=?,addr=? where id=?";
	
	@Override
	public accountBean update(
			String lastname, 
			String firstname,
			String nickname,
			String phone,
			String pair, 
			String city, 
			String conunty,
			String addr,
//			byte[] passwords, 
//			byte[] picture,
			Integer id
			) {
		
		 accountBean result = null;
		 PreparedStatement ract = null;
		 ResultSet rs = null;
		 
		try {
//			Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			Connection conn = dataSource.getConnection();
			ract = conn.prepareStatement(UPDATE);
			
//			
			ract.setString(1, lastname);
			ract.setString(2, firstname);
			ract.setString(3, nickname);
			ract.setString(4, phone);
			ract.setString(5, pair);
			ract.setString(6, city);
			ract.setString(7, conunty);
			ract.setString(8, addr);
//			ract.setBytes(10, picture);
//			ract.setBytes(1, passwords);
			ract.setInt(9, id);
			
			int i = ract.executeUpdate();
			if(i==1) {
				result = this.select(id);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	@Override
	public accountBean select(String account) {
		// TODO Auto-generated method stub
		return null;
	}

//	public static void main(String[] args)throws SQLException {
//		accountDAODS dao = new accountDAODS();
//		dao.update("aa".getBytes(),"cc", "cc", "dd", "0953","1", "ee", "ff", "str", "picture".getBytes(),8);
//		int x = 8;
//		accountBean bean = dao.select(x);
//		System.out.println(bean);
//	}
}
