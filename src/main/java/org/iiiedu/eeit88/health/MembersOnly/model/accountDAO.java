package org.iiiedu.eeit88.health.MembersOnly.model;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.iiiedu.eeit88.health.namage.model.PermissionsBean;

public interface accountDAO {

	public abstract accountBean select(String account);
	public abstract accountBean select(int memid);
//	public abstract List<accountBean> select();
	public abstract accountBean update(
//			byte[] passwords,
			String lastname,
			String firstname,
			String nickname,
			String phone,//手機
			String pair,
			String city,
			String conunty,
			String addr,
//			byte[] picture,
			Integer id
	);
}
