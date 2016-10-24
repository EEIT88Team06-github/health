package org.iiiedu.eeit88.health.match.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.iiiedu.eeit88.health.DbUtils.DbConnection;
import org.iiiedu.eeit88.health.match.bean.MatchBean;

public interface ResultDAO {
	MatchBean getCouple(String gender);
	
	
	
}
