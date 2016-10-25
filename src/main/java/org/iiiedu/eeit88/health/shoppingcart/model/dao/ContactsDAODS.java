package org.iiiedu.eeit88.health.shoppingcart.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.iiiedu.eeit88.health.global.Global;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.iiiedu.eeit88.health.shoppingcart.model.ContactsBean;
import org.iiiedu.eeit88.health.shoppingcart.model.IContactsDAO;

public class ContactsDAODS implements IContactsDAO {
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
		IContactsDAO dao = new ContactsDAODS();
		ContactsBean bean = new ContactsBean();
//		bean.setId(2);
//		bean.setContactAddress("Tai");
//		bean.setMemId(3);
//		bean.setName("kali");
//		bean.setPhone("0966554897");
//		Boolean b = dao.delete(bean.getId());
		bean = dao.selectOne(4);
		 List<ContactsBean> beans = dao.select(3);
		System.out.println(bean);

	}
	
	//testonly
	public ContactsDAODS() {

	}

	public ContactsDAODS(DataSource ds) {
		this.ds = ds;
	}

	List<ContactsBean> beans = new ArrayList<ContactsBean>();
	private String SELECT_BY_ID = "select * from contacts where memid = ?";
	// 用會員id查詢聯絡人資料
	public List<ContactsBean> select(int memId) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DriverManager.getConnection(Global.DB_URL, Global.DB_USER, Global.DB_PASSWORD);
			pstmt = conn.prepareStatement(SELECT_BY_ID);
			pstmt.setInt(1, memId);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ContactsBean bean = new ContactsBean();
				bean.setId(rs.getInt("id"));
				bean.setContactAddress(rs.getString("contactaddress"));
				bean.setMemId(rs.getInt("memid"));
				bean.setName(rs.getString("name"));
				bean.setPhone(rs.getString("phone"));
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

	// 新增contacts table資料
	private String INSERT = "insert into contacts (contactaddress,phone,name,memid)" + "values (?,?,?,?); ";

	public Boolean insert(ContactsBean bean) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0; // 回傳值預設為0
		try {
			conn = DriverManager.getConnection(Global.DB_URL, Global.DB_USER, Global.DB_PASSWORD);
			pstmt = conn.prepareStatement(INSERT);
			pstmt.setString(1, bean.getContactAddress());
			pstmt.setString(2, bean.getPhone());
			pstmt.setString(3, bean.getName());
			pstmt.setInt(4, bean.getMemId());

			result = pstmt.executeUpdate();

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

		if (result != 0) // result不為0 代表新增成功
			return true;
		else
			return false;

	}

	// 更新聯絡人資料
	private String UPDATE = "update contacts set " + "contactaddress = ?, phone = ?, name = ?, memid =? "
			+ "where id = ?";

	public Boolean update(ContactsBean bean) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0; // 回傳值預設為0
		try {
			conn = DriverManager.getConnection(Global.DB_URL, Global.DB_USER, Global.DB_PASSWORD);
			pstmt = conn.prepareStatement(UPDATE);
			pstmt.setString(1, bean.getContactAddress());
			pstmt.setString(2, bean.getPhone());
			pstmt.setString(3, bean.getName());
			pstmt.setInt(4, bean.getMemId());
			pstmt.setInt(5, bean.getId());

			result = pstmt.executeUpdate();

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

		if (result != 0) // result不為0 代表新增成功
			return true;
		else
			return false;
	}

	private String DELETE = "delete from contacts where id = ? ";

	public Boolean delete(int id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0; // 回傳值預設為0
		try {
			conn = DriverManager.getConnection(Global.DB_URL, Global.DB_USER, Global.DB_PASSWORD);
			pstmt = conn.prepareStatement(DELETE);
			pstmt.setInt(1, id);
			result = pstmt.executeUpdate();

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
		
		if (result != 0) // result不為0 代表新增成功
			return true;
		else
			return false;
	}

	private String SELECT_ONE = "select * from contacts where id = ?";
	@Override
	public ContactsBean selectOne(int id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ContactsBean bean = null;
		try {
			conn = DriverManager.getConnection(Global.DB_URL, Global.DB_USER, Global.DB_PASSWORD);
			pstmt = conn.prepareStatement(SELECT_ONE);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()){
				bean = new ContactsBean();
				bean.setId(rs.getInt("id"));
				bean.setContactAddress(rs.getString("contactaddress"));
				bean.setMemId(rs.getInt("memid"));
				bean.setName(rs.getString("name"));
				bean.setPhone(rs.getString("phone"));
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
}
