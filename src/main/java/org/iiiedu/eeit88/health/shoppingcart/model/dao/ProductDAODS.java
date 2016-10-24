package org.iiiedu.eeit88.health.shoppingcart.model.dao;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.iiiedu.eeit88.health.global.Global;
import org.iiiedu.eeit88.health.shoppingcart.model.IProductDAO;
import org.iiiedu.eeit88.health.shoppingcart.model.ProductBean;

public class ProductDAODS implements IProductDAO {
	private static DataSource ds;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup(Global.JNDI);
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws IOException {
		IProductDAO dao = new ProductDAODS();
		ProductBean bean = new ProductBean();
		
		Path path = Paths.get("c:/images/純煉低雞精.jpg");
		byte[] data = Files.readAllBytes(path);
//		bean.setContent("ooo");
//		bean.setName("不健康");
		bean.setPic(Files.readAllBytes(path));
//		bean.setPrice(68);
//		bean.setProductStatus(false);
//		bean.setProductType(3);
//		bean.setQuantity(32);
//		bean.setTotal(25);
//		bean.setVendorId(3);
		bean.setId(8);
		Boolean result = dao.update(bean);
//		List<ProductBean> beans = dao.selectFront();
//		byte[] b = dao.selectPic(3);
//		System.out.println(b);
//		dao.hide(3);
//		dao.show(4);
//		bean = dao.select(6);
//		System.out.println(bean);
//		beans = dao.select_front();
//		System.out.println(beans);
//		beans = dao.select_manage();
//		System.out.println(beans);
	}


	private String SELECT_BY_ID = "select * from product where id = ?;";

	public ProductBean select(int id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ProductBean bean = new ProductBean();
		try {
			conn = DriverManager.getConnection(Global.DB_URL, Global.DB_USER, Global.DB_PASSWORD);
			pstmt = conn.prepareStatement(SELECT_BY_ID);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				bean.setId(rs.getInt("id"));
				bean.setContent(rs.getString("content"));
				bean.setName(rs.getString("name"));
				bean.setPic(rs.getBytes("pic"));
				bean.setPrice(rs.getInt("price"));
				bean.setProductStatus(rs.getBoolean("productstatus"));
				bean.setProductType(rs.getInt("producttype"));
				bean.setQuantity(rs.getInt("quantity"));
				bean.setTotal(rs.getInt("total"));
				bean.setVendorId(rs.getInt("vendorid"));
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

	private String SELECT_ALL_MANAGE = "select * from product ;";

	public List<ProductBean> selectManage() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<ProductBean> beans = new ArrayList<ProductBean>();
		try {
			conn = DriverManager.getConnection(Global.DB_URL, Global.DB_USER, Global.DB_PASSWORD);
			pstmt = conn.prepareStatement(SELECT_ALL_MANAGE);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				ProductBean bean = new ProductBean();
				bean.setId(rs.getInt("id"));
				bean.setContent(rs.getString("content"));
				bean.setName(rs.getString("name"));
				bean.setPic(rs.getBytes("pic"));
				bean.setPrice(rs.getInt("price"));
				bean.setProductStatus(rs.getBoolean("productstatus"));
				bean.setProductType(rs.getInt("producttype"));
				bean.setQuantity(rs.getInt("quantity"));
				bean.setTotal(rs.getInt("total"));
				bean.setVendorId(rs.getInt("vendorid"));
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

	private String INSERT = "insert into product " + "(content, name, pic, price, productstatus, producttype, "
			+ "quantity, total, vendorid ) " + "values (?,?,?,?,?,?,?,?,?); ";

	public Boolean insert(ProductBean bean) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0; // 回傳值預設為0
		try {
			conn = DriverManager.getConnection(Global.DB_URL, Global.DB_USER, Global.DB_PASSWORD);
			pstmt = conn.prepareStatement(INSERT);
			pstmt.setString(1, bean.getContent());
			pstmt.setString(2, bean.getName());
			pstmt.setBytes(3, bean.getPic());
			pstmt.setInt(4, bean.getPrice());
			pstmt.setBoolean(5, bean.getProductStatus());
			pstmt.setInt(6, bean.getProductType());
			pstmt.setInt(7, bean.getQuantity());
			pstmt.setInt(8, bean.getTotal());
			pstmt.setInt(9, bean.getVendorId());
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

	private String UPDATE = "update product set " + "content = ?, name = ?, pic = ?, price = ?, productstatus = ?, "
			+ "producttype = ?, quantity = ?, total = ?, vendorid = ? " + " where id = ? ";
	private String UPDATE_PIC = "update product set " + "pic = ? "
			+ " where id = ? ";

	public Boolean update(ProductBean bean) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0; // 回傳值預設為0
		try {
			conn = DriverManager.getConnection(Global.DB_URL, Global.DB_USER, Global.DB_PASSWORD);
			pstmt = conn.prepareStatement(UPDATE_PIC);
//			pstmt.setString(1, bean.getContent());
//			pstmt.setString(2, bean.getName());
			pstmt.setBytes(1, bean.getPic());
//			pstmt.setInt(4, bean.getPrice());
//			pstmt.setBoolean(5, bean.getProductStatus());
//			pstmt.setInt(6, bean.getProductType());
//			pstmt.setInt(7, bean.getQuantity());
//			pstmt.setInt(8, bean.getTotal());
//			pstmt.setInt(9, bean.getVendorId());
			pstmt.setInt(2, bean.getId());
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

	private String HIDE = "update product set productstatus = ? " + " where id = ? ";

	public Boolean hide(int id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0; // 回傳值預設為0
		try {
			conn = DriverManager.getConnection(Global.DB_URL, Global.DB_USER, Global.DB_PASSWORD);
			pstmt = conn.prepareStatement(HIDE);
			pstmt.setBoolean(1, false);
			pstmt.setInt(2, id);
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

	private String SELECT_ALL_FRONT = "select * from product where productstatus = 1;";
	@Override
	public List<ProductBean> selectFront() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<ProductBean> beans = new ArrayList<ProductBean>();
		try {
			conn = ds.getConnection(); 
			pstmt = conn.prepareStatement(SELECT_ALL_FRONT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				ProductBean bean = new ProductBean();
				bean.setId(rs.getInt("id"));
				bean.setContent(rs.getString("content"));
				bean.setName(rs.getString("name"));
				bean.setPic(rs.getBytes("pic"));
				bean.setPrice(rs.getInt("price"));
				bean.setProductStatus(rs.getBoolean("productstatus"));
				bean.setProductType(rs.getInt("producttype"));
				bean.setQuantity(rs.getInt("quantity"));
				bean.setTotal(rs.getInt("total"));
				bean.setVendorId(rs.getInt("vendorid"));
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

	private String SHOW = "update product set productstatus = ? " + " where id = ? ";
	public Boolean show(int id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0; // 回傳值預設為0
		try {
			conn = DriverManager.getConnection(Global.DB_URL, Global.DB_USER, Global.DB_PASSWORD);
			pstmt = conn.prepareStatement(SHOW);
			pstmt.setBoolean(1, true);
			pstmt.setInt(2, id);
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
	
	private String SELECT_PIC = "select pic from product where id = ?;";
	@Override
	public byte[] selectPic(int id) {
		byte[] b = null; 
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DriverManager.getConnection(Global.DB_URL, Global.DB_USER, Global.DB_PASSWORD);
			pstmt = conn.prepareStatement(SELECT_PIC);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()){
				b = rs.getBytes("pic");
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
		return b;
	}

}
