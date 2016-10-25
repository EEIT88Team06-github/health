package org.iiiedu.eeit88.health.shoppingcart.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.iiiedu.eeit88.health.global.Global;
import org.iiiedu.eeit88.health.shoppingcart.model.ContactsBean;
import org.iiiedu.eeit88.health.shoppingcart.model.DiscountBean;
import org.iiiedu.eeit88.health.shoppingcart.model.IDiscountDAO;

public class DiscountDAODS implements IDiscountDAO {
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

		IDiscountDAO dao = new DiscountDAODS();
		DiscountBean bean = new DiscountBean();
		List<DiscountBean> beans = new ArrayList<DiscountBean>();
		String tsStr = "2016-10-06 13:00:00";
		String tsStr2 = "2016-10-16 10:00:00";

		Timestamp ts = Timestamp.valueOf(tsStr);
		Timestamp ts2 = new Timestamp(System.currentTimeMillis());
		beans = dao.selectFront(ts2);

		// bean.setDiscount((float)0.6);
		// bean.setStartDate(ts);
		// bean.setEndDate(Timestamp.valueOf(tsStr2));
		// bean.setProdType(1);
		// Boolean b = dao.update(bean);
		// bean = dao.select(5);
		// List<DiscountBean> beans = dao.select();
		System.out.println(beans);

	}

	public DiscountDAODS() {

	}

	public DiscountDAODS(DataSource ds) {
		this.ds = ds;
	}

	// private String SELECT_ALL = "select * from discount;";
	// @Override
	// public List<DiscountBean> select_manage() {
	// List<DiscountBean> beans = new ArrayList<DiscountBean>();
	// Connection conn = null;
	// PreparedStatement pstmt = null;
	// ResultSet rs = null;
	// try {
	// conn = DriverManager.getConnection(Global.DB_URL, Global.DB_USER,
	// Global.DB_PASSWORD);
	// pstmt = conn.prepareStatement(SELECT_ALL);
	// rs = pstmt.executeQuery();
	// while (rs.next()) {
	// DiscountBean bean = new DiscountBean();
	// bean.setId(rs.getInt("id"));
	// bean.setDiscount(rs.getFloat("discount"));
	// bean.setEndDate(rs.getTimestamp("enddate"));
	// bean.setProdType(rs.getInt("prodtype"));
	// bean.setStartDate(rs.getTimestamp("startdate"));
	// beans.add(bean);
	// }
	// } catch (SQLException e) {
	// e.printStackTrace();
	// } finally {
	// if (rs != null) {
	// try {
	// rs.close();
	// } catch (SQLException e) {
	// e.printStackTrace();
	// }
	// }
	// if (pstmt != null) {
	// try {
	// pstmt.close();
	// } catch (SQLException e) {
	// e.printStackTrace();
	// }
	// }
	// if (conn != null) {
	// try {
	// conn.close();
	// } catch (SQLException e) {
	// e.printStackTrace();
	// }
	// }
	//
	// }
	//
	// return beans;
	// }

	private String SELECT_BY_TYPE = "select * from discount where prodtype = ?;";

	public DiscountBean select(Integer prodType) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		DiscountBean bean = null;
		try {
			conn = DriverManager.getConnection(Global.DB_URL, Global.DB_USER, Global.DB_PASSWORD);
			pstmt = conn.prepareStatement(SELECT_BY_TYPE);
			pstmt.setInt(1, prodType);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				bean = new DiscountBean();
				bean.setId(rs.getInt("id"));
				bean.setDiscount(rs.getFloat("discount"));
				bean.setEndDate(rs.getTimestamp("enddate"));
				bean.setProdType(rs.getInt("prodtype"));
				bean.setStartDate(rs.getTimestamp("startdate"));
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

	private String INSERT = "insert into discount (startdate, enddate, discount, prodtype)" + "values (?,?,?,?); ";

	public Boolean insert(DiscountBean bean) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		try {
			conn = DriverManager.getConnection(Global.DB_URL, Global.DB_USER, Global.DB_PASSWORD);
			// 確認該product資料是否已經存在資料庫中
			pstmt = conn.prepareStatement(SELECT_BY_TYPE);
			pstmt.setInt(1, bean.getProdType());
			rs = pstmt.executeQuery();
			if (rs.next())
				return false; // 若rs有資料回傳false,請使用update方式修改
			// 若rs無資料則將bean內容新增至資料庫
			pstmt = conn.prepareStatement(INSERT);
			pstmt.setDate(1, new java.sql.Date(bean.getStartDate().getTime()));
			pstmt.setDate(2, new java.sql.Date(bean.getEndDate().getTime()));
			pstmt.setFloat(3, bean.getDiscount());
			pstmt.setInt(4, bean.getProdType());
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
		if (result == 0) // 新增失敗
			return false;
		else
			return true;
	}

	private String UPDATE = "update discount set " + "startdate = ?, enddate = ?, discount = ? "
			+ "where prodtype = ?;";

	public Boolean update(DiscountBean bean) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		try {
			conn = DriverManager.getConnection(Global.DB_URL, Global.DB_USER, Global.DB_PASSWORD);
			// 確認該product資料是否已經存在資料庫中
			pstmt = conn.prepareStatement(SELECT_BY_TYPE);
			pstmt.setInt(1, bean.getProdType());
			rs = pstmt.executeQuery();
			if (!rs.next())
				return false; // 若rs無資料回傳false,請使用insert方式新增
			// 若rs有資料則將bean內容更新至資料庫
			pstmt = conn.prepareStatement(UPDATE);
			pstmt.setDate(1, new java.sql.Date(bean.getStartDate().getTime()));
			pstmt.setDate(2, new java.sql.Date(bean.getEndDate().getTime()));
			pstmt.setFloat(3, bean.getDiscount());
			pstmt.setInt(4, bean.getProdType());
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
		if (result == 0) // 更新失敗
			return false;
		else
			return true;
	}

	public Boolean delete(DiscountBean bean) {
		return null;
	}

	private String SELECT_ONE = "select * from discount where startdate <= ? and enddate >= ? and prodtype = ?;";

	@Override
	public DiscountBean selectOne(Integer prodType, Timestamp ts) {
		DiscountBean bean = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DriverManager.getConnection(Global.DB_URL, Global.DB_USER, Global.DB_PASSWORD);
			pstmt = conn.prepareStatement(SELECT_ONE);
			pstmt.setTimestamp(1, ts);
			pstmt.setTimestamp(2, ts);
			pstmt.setInt(3, prodType);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				bean = new DiscountBean();
				bean.setId(rs.getInt("id"));
				bean.setDiscount(rs.getFloat("discount"));
				bean.setEndDate(rs.getTimestamp("enddate"));
				bean.setProdType(rs.getInt("prodtype"));
				bean.setStartDate(rs.getTimestamp("startdate"));
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

	private String SELECT_MANAGE = "select * from discount;";

	@Override
	public List<DiscountBean> selectManage() {
		List<DiscountBean> beans = new ArrayList<DiscountBean>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DriverManager.getConnection(Global.DB_URL, Global.DB_USER, Global.DB_PASSWORD);
			pstmt = conn.prepareStatement(SELECT_MANAGE);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				DiscountBean bean = new DiscountBean();
				bean.setId(rs.getInt("id"));
				bean.setDiscount(rs.getFloat("discount"));
				bean.setEndDate(rs.getTimestamp("enddate"));
				bean.setProdType(rs.getInt("prodtype"));
				bean.setStartDate(rs.getTimestamp("startdate"));
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

	private String SELECT_FRONT = "select * from discount where startdate <= ? and enddate >= ?;";

	@Override
	public List<DiscountBean> selectFront(Timestamp ts) {
		List<DiscountBean> beans = new ArrayList<DiscountBean>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DriverManager.getConnection(Global.DB_URL, Global.DB_USER, Global.DB_PASSWORD);
			pstmt = conn.prepareStatement(SELECT_FRONT);
			pstmt.setTimestamp(1, ts);
			pstmt.setTimestamp(2, ts);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				DiscountBean bean = new DiscountBean();
				bean.setId(rs.getInt("id"));
				bean.setDiscount(rs.getFloat("discount"));
				bean.setEndDate(rs.getTimestamp("enddate"));
				bean.setProdType(rs.getInt("prodtype"));
				bean.setStartDate(rs.getTimestamp("startdate"));
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

}
