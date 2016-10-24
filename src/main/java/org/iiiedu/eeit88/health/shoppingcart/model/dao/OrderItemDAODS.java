package org.iiiedu.eeit88.health.shoppingcart.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.iiiedu.eeit88.health.global.Global;
import org.iiiedu.eeit88.health.shoppingcart.model.DiscountBean;
import org.iiiedu.eeit88.health.shoppingcart.model.IOrderItemDAO;
import org.iiiedu.eeit88.health.shoppingcart.model.OrderItemBean;

public class OrderItemDAODS implements IOrderItemDAO {
	private DataSource ds;
	
	public static void main(String[] args) {
		IOrderItemDAO dao = new OrderItemDAODS();
		OrderItemBean bean = new OrderItemBean();
		List<OrderItemBean> beans = new ArrayList<OrderItemBean>();
		
//		bean.setArrival("新店重安店");
//		bean.setBonus(30);
		bean.setMemId(3);
//		bean.setOrderItemAddress("台北市復興南路二段86號十樓");
		bean.setOrdNum("20161008153136");
//		bean.setOrdTime(Timestamp.valueOf("2016-10-08 18:00:00"));
//		bean.setPhone("0987745662");
//		bean.setShipTime(Timestamp.valueOf("2016-10-13 15:00:00"));
		
		beans = dao.select(4);
		System.out.println(beans);
		dao.delete(bean);
		beans = dao.select();
		System.out.println(beans);
		
	}
	
	public OrderItemDAODS() {
	}
	public OrderItemDAODS(DataSource ds) {
		this.ds = ds;
	}

	private String SELECT = "select * from orderitem where memid = ?;";
	public List<OrderItemBean> select(int memId) {
		List<OrderItemBean> beans = new ArrayList<OrderItemBean>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DriverManager.getConnection(Global.DB_URL, Global.DB_USER, Global.DB_PASSWORD);
			pstmt = conn.prepareStatement(SELECT);
			pstmt.setInt(1, memId);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				OrderItemBean bean = new OrderItemBean();
				bean.setId(rs.getInt("id"));
				bean.setArrival(rs.getString("arrival"));
				bean.setBonus(rs.getInt("bonus"));
				bean.setMemId(rs.getInt("memid"));
				bean.setOrderItemAddress(rs.getString("orderitemaddress"));
				bean.setOrdNum(rs.getString("ordnum"));
				bean.setOrdTime(rs.getTimestamp("ordtime"));
				bean.setPhone(rs.getString("phone"));
				bean.setShipTime(rs.getTimestamp("shiptime"));
				bean.setName(rs.getString("name"));
				bean.setShipStatus(rs.getInt("shipstatus"));
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

	private String SELECT_ALL = "select * from orderitem;";
	public List<OrderItemBean> select() {
		List<OrderItemBean> beans = new ArrayList<OrderItemBean>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DriverManager.getConnection(Global.DB_URL, Global.DB_USER, Global.DB_PASSWORD);
			pstmt = conn.prepareStatement(SELECT_ALL);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				OrderItemBean bean = new OrderItemBean();
				bean.setId(rs.getInt("id"));
				bean.setArrival(rs.getString("arrival"));
				bean.setBonus(rs.getInt("bonus"));
				bean.setMemId(rs.getInt("memid"));
				bean.setOrderItemAddress(rs.getString("orderitemaddress"));
				bean.setOrdNum(rs.getString("ordnum"));
				bean.setOrdTime(rs.getTimestamp("ordtime"));
				bean.setPhone(rs.getString("phone"));
				bean.setShipTime(rs.getTimestamp("shiptime"));
				bean.setName(rs.getString("name"));
				bean.setShipStatus(rs.getInt("shipstatus"));
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
	private String INSERT = "insert into orderitem (arrival, bonus, memid,"
						    + " orderitemaddress, ordnum, ordtime, phone, shiptime, name, shipstatus)" 
						    + "values (?,?,?,?,?,?,?,?,?,?); ";
	public Boolean insert(OrderItemBean bean) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;//預設回傳值為0
		try {
			conn = DriverManager.getConnection(Global.DB_URL, Global.DB_USER, Global.DB_PASSWORD);
			pstmt = conn.prepareStatement(INSERT);
			pstmt.setString(1, bean.getArrival());
			pstmt.setInt(2, bean.getBonus());
			pstmt.setInt(3, bean.getMemId());
			pstmt.setString(4, bean.getOrderItemAddress());
			pstmt.setString(5, bean.getOrdNum());
			pstmt.setTimestamp(6, bean.getOrdTime());
			pstmt.setString(7, bean.getPhone());
			pstmt.setTimestamp(8, bean.getShipTime());
			pstmt.setString(9, bean.getName());
			pstmt.setInt(10, bean.getShipStatus());
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

		if(result == 0) //新增失敗
			return false;
		else
			return true;
	}
	
	private String UPDATE = "update orderitem set " 
							+ "arrival = ?, bonus = ?, orderitemaddress = ?, "
							+ "ordtime = ?, phone = ?, shiptime =?, name=?, shipstatus=? "
							+ "where memid = ? and ordnum = ?";
	
	public Boolean update(OrderItemBean bean) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;//預設回傳值為0
		try {
			conn = DriverManager.getConnection(Global.DB_URL, Global.DB_USER, Global.DB_PASSWORD);
			pstmt = conn.prepareStatement(UPDATE);
			pstmt.setString(1, bean.getArrival());
			pstmt.setInt(2, bean.getBonus());
			pstmt.setString(3, bean.getOrderItemAddress());
			pstmt.setTimestamp(4, bean.getOrdTime());
			pstmt.setString(5, bean.getPhone());
			pstmt.setTimestamp(6, bean.getShipTime());
			pstmt.setString(7, bean.getName());
			pstmt.setInt(8, bean.getShipStatus());
			pstmt.setInt(9, bean.getMemId());
			pstmt.setString(10, bean.getOrdNum());
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

		if(result == 0) //新增失敗
			return false;
		else
			return true;
	}

	private String DELETE = "delete from orderitem where memid = ? and ordnum = ?";
	public Boolean delete(OrderItemBean bean) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;//預設回傳值為0
		try {
			conn = DriverManager.getConnection(Global.DB_URL, Global.DB_USER, Global.DB_PASSWORD);
			pstmt = conn.prepareStatement(DELETE);
			pstmt.setInt(1, bean.getMemId());
			pstmt.setString(2, bean.getOrdNum());
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

		if(result == 0) //新增失敗
			return false;
		else
			return true;
	}

}
