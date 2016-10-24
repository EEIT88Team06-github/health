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
import org.iiiedu.eeit88.health.shoppingcart.model.IProductTypeDAO;
import org.iiiedu.eeit88.health.shoppingcart.model.ProductTypeBean;

public class ProductTypeDAODS implements IProductTypeDAO {
	private static DataSource ds;
	
	public static void main(String[] args) {
		IProductTypeDAO dao = new ProductTypeDAODS();
		ProductTypeBean bean = new ProductTypeBean();
		List<ProductTypeBean> beans = new ArrayList<ProductTypeBean>();
		bean.setId(6);
		bean.setProdType("啞鈴");
		dao.insert("單槓");
		beans = dao.select();
		System.out.println(beans);
		dao.update(bean);
		beans = dao.select();
		System.out.println(beans);
		
		
	}
	private String INSERT = "insert into producttype (prodtype)" + "values (?); ";
	@Override
	public Boolean insert(String ProdType) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0; // 回傳值預設為0
		try {
			conn = DriverManager.getConnection(Global.DB_URL, Global.DB_USER, Global.DB_PASSWORD);
			pstmt = conn.prepareStatement(INSERT);
				pstmt.setString(1, ProdType);
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
	
	private String UPDATE = "update producttype set " + "prodtype = ? "
			   + "where id = ?";
	@Override
	public Boolean update(ProductTypeBean bean) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0; // 回傳值預設為0
		try {
			conn = DriverManager.getConnection(Global.DB_URL, Global.DB_USER, Global.DB_PASSWORD);
			pstmt = conn.prepareStatement(UPDATE);
			pstmt.setString(1, bean.getProdType());
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

	@Override
	public Boolean hide(Integer id) {
		return null;
	}
	
	private String SELECT_ALL = "select * from producttype;";
	@Override
	public List<ProductTypeBean> select() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<ProductTypeBean> beans = new ArrayList<ProductTypeBean>();
		
		try {
			conn = DriverManager.getConnection(Global.DB_URL, Global.DB_USER, Global.DB_PASSWORD);
			pstmt = conn.prepareStatement(SELECT_ALL);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				ProductTypeBean bean = new ProductTypeBean();
				bean.setId(rs.getInt("id"));
				bean.setProdType(rs.getString("prodtype"));
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
