package org.iiiedu.eeit88.health.shoppingcart.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.sql.DataSource;

import org.iiiedu.eeit88.health.global.Global;
import org.iiiedu.eeit88.health.shoppingcart.model.DetailBean;
import org.iiiedu.eeit88.health.shoppingcart.model.IVendorDAO;
import org.iiiedu.eeit88.health.shoppingcart.model.ProductBean;
import org.iiiedu.eeit88.health.shoppingcart.model.VendorBean;

public class VendorDAODS implements IVendorDAO {
	private DataSource ds;
	
	public static void main(String[] args) {
		IVendorDAO dao = new VendorDAODS();
		VendorBean bean = new VendorBean();
		List<VendorBean> beans = new ArrayList<VendorBean>();
		
		beans = dao.select();
		System.out.println(beans);
		bean = dao.select(5);
		System.out.println(bean);
//		bean.setBankAccount("222555987596");
//		bean.setBankNo("700");
//		bean.setMail("support@yauho.com");
//		bean.setName("耀宏兄弟");
//		bean.setPhone("0976025681");
//		bean.setVendorAddress("台北市倫等街");
//		dao.insert(bean);
		beans = dao.select();
		System.out.println(beans);
		bean.setBankAccount("258962236541");
		bean.setBankNo("125");
		bean.setId(6);
		bean.setMail("support@pure.com");
		bean.setName("純真");
		bean.setPhone("0988695684");
		bean.setVendorAddress("台北市松江路45號");
		dao.update(bean);
		beans = dao.select();
		System.out.println(beans);
		
	}
	
	public VendorDAODS() {
	}
	public VendorDAODS(DataSource ds) {
		this.ds = ds;
	}

	private String SELECT_BY_ID = "select * from vendor where id = ?;";
	public VendorBean select(int id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		VendorBean bean = new VendorBean();
		try {
			conn = DriverManager.getConnection(Global.DB_URL, Global.DB_USER, Global.DB_PASSWORD);
			pstmt = conn.prepareStatement(SELECT_BY_ID);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				bean = new VendorBean();
				bean.setId(rs.getInt("id"));
				bean.setBankAccount(rs.getString("bankaccount"));
				bean.setBankNo(rs.getString("bankno"));
				bean.setMail(rs.getString("mail"));
				bean.setName(rs.getString("name"));
				bean.setPhone(rs.getString("phone"));
				bean.setVendorAddress(rs.getString("vendoraddress"));
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

		return bean;
	}

	private String SELECT_ALL = "select * from vendor;";
	public List<VendorBean> select() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<VendorBean> beans = new ArrayList<VendorBean>();
		try {
			conn = DriverManager.getConnection(Global.DB_URL, Global.DB_USER, Global.DB_PASSWORD);
			pstmt = conn.prepareStatement(SELECT_ALL);
			rs = pstmt.executeQuery();
			VendorBean bean = null;
			while (rs.next()) {
				bean = new VendorBean();
				bean.setId(rs.getInt("id"));
				bean.setBankAccount(rs.getString("bankaccount"));
				bean.setBankNo(rs.getString("bankno"));
				bean.setMail(rs.getString("mail"));
				bean.setName(rs.getString("name"));
				bean.setPhone(rs.getString("phone"));
				bean.setVendorAddress(rs.getString("vendoraddress"));
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

	private String INSERT = "insert into vendor (bankaccount, bankno, mail, name, "
			               + " phone, vendoraddress )" + " values (?,?,?,?,?,?); ";
	public Boolean insert(VendorBean bean) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0; // 回傳值預設為0
		try {
			conn = DriverManager.getConnection(Global.DB_URL, Global.DB_USER, Global.DB_PASSWORD);
			pstmt = conn.prepareStatement(INSERT);
			if (bean != null) {
				pstmt.setString(1, bean.getBankAccount());
				pstmt.setString(2, bean.getBankNo());
				pstmt.setString(3, bean.getMail());
				pstmt.setString(4, bean.getName());
				pstmt.setString(5, bean.getPhone());
				pstmt.setString(6, bean.getVendorAddress());
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

	private String UPDATE = "update vendor set " + "bankaccount = ?, bankno = ?, "
				+ "mail = ?, name = ?, phone = ?, vendoraddress = ? "
			    + " where id = ? ";
	public Boolean update(VendorBean bean) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0; // 回傳值預設為0
		try {
			conn = DriverManager.getConnection(Global.DB_URL, Global.DB_USER, Global.DB_PASSWORD);
			pstmt = conn.prepareStatement(UPDATE);
			if (bean != null) {
				pstmt.setString(1, bean.getBankAccount());
				pstmt.setString(2, bean.getBankNo());
				pstmt.setString(3, bean.getMail());
				pstmt.setString(4, bean.getName());
				pstmt.setString(5, bean.getPhone());
				pstmt.setString(6, bean.getVendorAddress());
				pstmt.setInt(7, bean.getId());
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
