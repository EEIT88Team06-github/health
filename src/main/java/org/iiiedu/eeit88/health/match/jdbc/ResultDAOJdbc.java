package org.iiiedu.eeit88.health.match.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.iiiedu.eeit88.health.DbUtils.DbConnection;
import org.iiiedu.eeit88.health.match.bean.MatchBean;
import org.iiiedu.eeit88.health.match.dao.ResultDAO;

public class ResultDAOJdbc implements ResultDAO{
	public MatchBean getCouple(String gender){
		MatchBean mBean = new MatchBean();
		//取Connection
		Connection conn = DbConnection.getConn();
		String sql = "SELECT * FROM member where gender= ?";
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		try {
			pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, gender);
			rs = pStmt.executeQuery();
			while (rs.next()) {
				mBean.setGender(rs.getString("gender").trim());
				mBean.setCity(rs.getString("city").trim());
				mBean.setCountry(rs.getString("country").trim());
				
				//System.out.println("country="+country);
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
	
	public static void main(String[] args) {	
		ResultDAOJdbc dao = new ResultDAOJdbc();
		MatchBean mbean = dao.getCouple("男");
		System.out.println("mbean==="+mbean);

	}
}
