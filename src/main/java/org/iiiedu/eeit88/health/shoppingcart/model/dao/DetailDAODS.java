package org.iiiedu.eeit88.health.shoppingcart.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.iiiedu.eeit88.health.global.Global;
import org.iiiedu.eeit88.health.shoppingcart.model.ContactsBean;
import org.iiiedu.eeit88.health.shoppingcart.model.DetailBean;
import org.iiiedu.eeit88.health.shoppingcart.model.IDetailDAO;

public class DetailDAODS implements IDetailDAO {
	private static DataSource ds;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup(Global.JNDI);
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		IDetailDAO dao = new DetailDAODS();
		DetailBean bean1 = new DetailBean();
		List<DetailBean> beans = new ArrayList<DetailBean>();
		// dao.select("20161008153148");
		// quantity,total,prodid,ordnum
		bean1.setOrdNum("20161008153148");
		bean1.setProdId(3);
		bean1.setQuantity(4);
		bean1.setTotal(23560);
		System.out.println(bean1);
		beans.add(bean1);
//
//		DetailBean bean2 = new DetailBean();
//		bean1.setOrdNum("20161008153148");
//		bean1.setProdId(6);
//		bean1.setQuantity(2);
//		bean1.setTotal(1980);
//		System.out.println(bean1);
//		beans.add(bean1);
//		Iterator it = beans.iterator();
//		while (it.hasNext()) {
//			bean2 = (DetailBean) it.next();
//			System.out.println(bean2);
//		}
		 Boolean result = dao.delete(bean1);
		 System.out.println(result);
	}

	public DetailDAODS() {
	}

	public DetailDAODS(DataSource ds) {
		this.ds = ds;
	}

	// 選出購物車中各商品細項
	private String SELECT_BY_ID = "select * from detail where ordnum = ?;";
	public List<DetailBean> select(String ordNum) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<DetailBean> beans = new ArrayList<DetailBean>();
		try {
			conn = DriverManager.getConnection(Global.DB_URL, Global.DB_USER, Global.DB_PASSWORD);
			pstmt = conn.prepareStatement(SELECT_BY_ID);
			pstmt.setString(1, ordNum);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				DetailBean bean = new DetailBean();
				bean.setId(rs.getInt("id"));
				bean.setOrdNum(rs.getString("ordnum"));
				bean.setProdId(rs.getInt("prodid"));
				bean.setQuantity(rs.getInt("quantity"));
				bean.setTotal(rs.getInt("total"));
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

	// 新增訂單購物內容(數量、商品項目及單項總價)
	private String INSERT = "insert into detail (quantity,total,prodid,ordnum)" + "values (?,?,?,?); ";

	public Boolean insert(List<DetailBean> beans) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0; // 回傳值預設為0
		try {
			conn = DriverManager.getConnection(Global.DB_URL, Global.DB_USER, Global.DB_PASSWORD);
			pstmt = conn.prepareStatement(INSERT);
			DetailBean bean = null;
			Iterator it = beans.iterator();
			while (it.hasNext()) {
				bean = (DetailBean) it.next();
				pstmt.setInt(1, bean.getQuantity());
				pstmt.setInt(2, bean.getTotal());
				pstmt.setInt(3, bean.getProdId());
				pstmt.setString(4, bean.getOrdNum());
				result = pstmt.executeUpdate();
			}

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
	//更新單一品項數量及價錢
	private String UPDATE = "update detail set " + "quantity = ?, total = ? "
						   + "where prodid = ? and ordnum = ?";

	public Boolean update(DetailBean bean) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0; // 回傳值預設為0
		try {
			conn = DriverManager.getConnection(Global.DB_URL, Global.DB_USER, Global.DB_PASSWORD);
			pstmt = conn.prepareStatement(UPDATE);
			if (bean != null) {
				pstmt.setInt(1, bean.getQuantity());
				pstmt.setInt(2, bean.getTotal());
				pstmt.setInt(3, bean.getProdId());
				pstmt.setString(4, bean.getOrdNum());
				result = pstmt.executeUpdate();
			}

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
	//刪除購物清單中單一品項
	private String DELETE = "delete from detail where prodid = ? and ordnum = ?";
	
	public Boolean delete(DetailBean bean) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0; // 回傳值預設為0
		try {
			conn = DriverManager.getConnection(Global.DB_URL, Global.DB_USER, Global.DB_PASSWORD);
			pstmt = conn.prepareStatement(DELETE);
			if (bean != null) {
				pstmt.setInt(1, bean.getProdId());
				pstmt.setString(2, bean.getOrdNum());
				result = pstmt.executeUpdate();
			}

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
