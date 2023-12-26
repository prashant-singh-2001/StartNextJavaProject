package com.startnext.DAO;

import java.sql.*;
import java.util.ArrayList;

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
				
			}
		} catch (Exception e) {

		}
		return su;
	}
//	public static boolean r
}
