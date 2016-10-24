package org.iiiedu.eeit88.health.match.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.iiiedu.eeit88.health.DbUtils.DbConnection;
import org.iiiedu.eeit88.health.match.bean.MatchBean;

public interface MatchDAO {
	
	public abstract MatchBean getMemberBirth(String account);
	
	public abstract List<MatchBean> getMemberBirth();

	
	
}





