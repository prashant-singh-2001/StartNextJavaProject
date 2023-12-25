package com.startnext.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.startnext.bean.UserBean;
import com.startnext.utility.DBUtil;

public class UserDAO  {
	static Connection con;
	static Statement st;
	static PreparedStatement pst;
	static ResultSet rs;
	public static UserBean signup (UserBean ub) throws ClassNotFoundException, SQLException {
		con=DBUtil.connect();
		int id=getMaxID()+1;
		pst=con.prepareStatement("INSERT INTO startnext.user_details (uid,first_name,last_name,uname,pword,mail) VALUES (?,?,?,?,?,?);");
		pst.setInt(1, id);
		pst.setString(2, ub.getFname());
		pst.setString(3, ub.getLname());
		pst.setString(4, ub.getUsername());
		pst.setString(5, ub.getPassword());
		pst.setString(6, ub.getMail());
		int a=pst.executeUpdate();
		if(a>0) {
			System.out.println("Successfull");
			return ub;
		}
		return null;
	}
	private static int getMaxID () throws ClassNotFoundException, SQLException {
		int maxId=0;
		if(con==null) con=DBUtil.connect();
		st=con.createStatement();
		rs=st.executeQuery("SELECT max(uid) FROM USER_DETAILS");
		while(rs.next()) {maxId=rs.getInt("uid");}
		return maxId;
	}
}