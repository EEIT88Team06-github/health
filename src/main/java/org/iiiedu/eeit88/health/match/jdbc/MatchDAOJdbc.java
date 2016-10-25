package org.iiiedu.eeit88.health.match.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.iiiedu.eeit88.health.DbUtils.DbConnection;
import org.iiiedu.eeit88.health.match.bean.MatchBean;
import org.iiiedu.eeit88.health.match.dao.MatchDAO;

public class MatchDAOJdbc implements MatchDAO{
		
	public MatchBean getMemberBirth(String account){
		MatchBean mBean = new MatchBean();
		//取Connection
		Connection conn = DbConnection.getConn();
		String sql = "SELECT * FROM member where account = ?";
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		try {
			pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, account);
			rs = pStmt.executeQuery();
			while (rs.next()) {
				mBean.setAccount(rs.getString("account"));
			    mBean.setBirth(rs.getDate("birth"));
				
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
		MatchDAOJdbc dao = new MatchDAOJdbc();
		MatchBean mbean = dao.getMemberBirth("sumo");
		System.out.println(mbean);
		
		
	}

	@Override
	public List<MatchBean> getMemberBirth() {
		// TODO Auto-generated method stub
		return null;
	}



}
