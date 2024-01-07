package com.startnext.DAO;

import java.sql.*;
import java.util.ArrayList;

import org.apache.tomcat.jdbc.pool.interceptor.AbstractCreateStatementInterceptor;

import com.startnext.bean.StUsBean;
import com.startnext.bean.StartupBean;
import com.startnext.bean.UserBean;
import com.startnext.utility.DBUtil;

public class StartupDAO {
	static private Statement st;
	static private PreparedStatement pst;
	static private ResultSet rs;
	static private Connection con;
	static private CallableStatement cs;

	public static ArrayList<StartupBean> calal() {
		ArrayList<StartupBean> slist = new ArrayList<StartupBean>();

		try {
			con = DBUtil.connect();
			cs = con.prepareCall("call startnext.GetStartupDetails();");
			rs = cs.executeQuery();
			while (rs.next()) {
				StartupBean sb = new StartupBean();
				sb.setField(rs.getString("field"));
				sb.setFlags(rs.getInt("flagged"));
				sb.setFounder(rs.getString("uid"));
				sb.setId(rs.getInt("id"));
				sb.setImage(rs.getString("st_img"));
				sb.setLikes(rs.getInt("likes"));
				sb.setName(rs.getString("name"));
				sb.setScope(rs.getString("scope"));
				sb.setSpread(rs.getString("st_spread"));
				slist.add(sb);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return slist;
	}

	public static StUsBean byid(StartupBean sb, UserBean ub) {
		StUsBean su = new StUsBean();
		try {
			con = DBUtil.connect();
			cs = con.prepareCall("call startnext.fetch_byid(?)");
			cs.setInt(1, sb.getId());
			rs = cs.executeQuery();
			while (rs.next()) {
				su.getSb().setField(rs.getString("field"));
				su.getSb().setFlags(rs.getInt("flagged"));
				su.getSb().setFounder(rs.getString("founder_id"));
				su.getSb().setId(rs.getInt("id"));
				su.getSb().setImage(rs.getString("st_img"));
				su.getSb().setLikes(rs.getInt("likes"));
				su.getSb().setName(rs.getString("name"));
				su.getSb().setSpread(rs.getString("st_spread"));
			}
		} catch (Exception e) {

		}
		return su;
	}

	public static boolean liked(int stid, int uid) throws ClassNotFoundException, SQLException{
		
			Connection con = DBUtil.connect();
		
		PreparedStatement pst=con.prepareStatement("INSERT INTO Startup_Liked(Startup_id,user_id) VALUES (?,?);");
		pst.setInt(1, stid);
		pst.setInt(2,uid);
		int i=pst.executeUpdate();
		if(i==1) {
			return true;
			}
		
		return false;
	}
	
	
	public static boolean reported(int stid) throws ClassNotFoundException, SQLException {
		
			Connection con = DBUtil.connect();
		PreparedStatement pst=con.prepareStatement("INSERT INTO flag_details(Startup_id,flagged) VALUES (?,?);");
		pst.setInt(1, stid);
		pst.setInt(2, StartupDao.maxreport(stid));
		int i=pst.executeUpdate();
		if(i==1) {
			return true;
			}
		
		return false;
	}
	
	public static boolean userliked(int stid, int uid) throws ClassNotFoundException, SQLException {
	
			Connection con = DBUtil.connect();
		
		PreparedStatement pst=con.prepareStatement("select * feom startup_liked where startup_id=? and user_id=?");
		pst.setInt(1, stid);
		pst.setInt(2, uid);
		rs=pst.executeQuery();
		int i=0;
		while(rs.next()) {
			i++;
			}
		if(i==1) {
			return true;
		}
		
		return false;
	}
	
	
	public static int maxreport(int stid, int uid) throws ClassNotFoundException, SQLException {
		
		int maxid=0;
		Connection con = DBUtil.connect();
	
	Statement st=con.createStatement();
	rs=st.executeQuery("select * from flag_details");
	int i=0;
	while(rs.next()) {
		maxid=rs.getInt("flagged");
		}
	
	return maxid;
	}

	
}
