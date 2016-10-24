package org.iiiedu.eeit88.health.shoppingcart.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.iiiedu.eeit88.health.global.Global;
import org.iiiedu.eeit88.health.shoppingcart.model.ContactsBean;
import org.iiiedu.eeit88.health.shoppingcart.model.DiscountBean;
import org.iiiedu.eeit88.health.shoppingcart.model.FollowBean;
import org.iiiedu.eeit88.health.shoppingcart.model.IFollowDAO;

public class FollowDAODS implements IFollowDAO {
	private DataSource ds;

	public static void main(String[] args) {
		IFollowDAO dao = new FollowDAODS();
		List<FollowBean> beans = new ArrayList<FollowBean>();
		FollowBean bean = new FollowBean();
		bean.setMemId(3);
		bean.setProdId(4);
		dao.delete(bean);
//		bean.setMemId(3);
//		bean.setProdId(5);
//		dao.delete(bean);
//		bean.setMemId(2);
//		bean.setProdId(8);
//		dao.insert(bean);
//		beans = dao.select(2);
//		System.out.println(beans);
//		beans = dao.select(3);
//		System.out.println(beans);
	}
	public FollowDAODS() {
	}
	public FollowDAODS(DataSource ds) {
		this.ds = ds;
	}
	
	private String SELECT_BY_ID = "select * from follow where memid = ?";
	public List<FollowBean> select(int memId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<FollowBean> beans = new ArrayList<FollowBean>();
		try {
			conn = DriverManager.getConnection(Global.DB_URL, Global.DB_USER, Global.DB_PASSWORD);
			pstmt = conn.prepareStatement(SELECT_BY_ID);
			pstmt.setInt(1, memId);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				FollowBean bean = new FollowBean();
				bean.setId(rs.getInt("id"));
				bean.setMemId(rs.getInt("memid"));
				bean.setProdId(rs.getInt("prodid"));
				beans.add(bean);
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
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}

		return beans;
	}
	private String INSERT = "insert into follow (memid,prodid) " + "values (?,?); ";
	public Boolean insert(FollowBean bean) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0; // 回傳值預設為0
		try {
			conn = DriverManager.getConnection(Global.DB_URL, Global.DB_USER, Global.DB_PASSWORD);
			pstmt = conn.prepareStatement(INSERT);
			pstmt.setInt(1, bean.getMemId());
			pstmt.setInt(2, bean.getProdId());
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}

		if (result != 0) // result不為0 代表新增成功
			return true;
		else
			return false;
	}

//	public FollowBean update(FollowBean bean) {
//		return null;
//	}

	private String DELETE = "delete from follow" 
							+ " where memid = ? and prodid = ?;";
	public Boolean delete(FollowBean bean) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0; // 回傳值預設為0
		try {
			System.out.println(bean.getMemId());
			System.out.println(bean.getProdId());
			conn = DriverManager.getConnection(Global.DB_URL, Global.DB_USER, Global.DB_PASSWORD);
			pstmt = conn.prepareStatement(DELETE);
			pstmt.setInt(1, bean.getMemId());
			pstmt.setInt(2, bean.getProdId());
			System.out.println(DELETE);
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}

		if (result != 0) // result不為0 代表新增成功
			return true;
		else
			return false;
	}

}
