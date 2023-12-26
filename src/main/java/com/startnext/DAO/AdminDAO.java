package com.startnext.DAO;

import java.sql.*;

import com.startnext.bean.AdminBean;
import com.startnext.utility.DBUtil;

public class AdminDAO {
	static private Connection con;
	static private Statement st;
	static private PreparedStatement pst;
	static private ResultSet rs;
	static private CallableStatement cs;
	public static boolean login(AdminBean ab) throws ClassNotFoundException, SQLException {
		con=DBUtil.connect();
		pst=con.prepareStatement("select * from administrator_details where uname=?");
		pst.setString(1, ab.getUsername());
		rs=pst.executeQuery();
		while(rs.next()) {
			if(ab.getPassword().equalsIgnoreCase(rs.getString("pword"))) return true;
		}
		return false;
	}
	public static AdminBean getuser(AdminBean ab) throws ClassNotFoundException, SQLException {
		con=DBUtil.connect();
		pst=con.prepareStatement("select * from administrator_details where uname=?");
		pst.setString(1, ab.getUsername());
		rs=pst.executeQuery();
		while(rs.next()) {
			ab.setFname(rs.getString("fname"));
			ab.setLname(rs.getString("lname"));
			ab.setEmail(rs.getString("mail"));
		}
		return ab;
	}
}
