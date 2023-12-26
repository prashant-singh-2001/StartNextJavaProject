package com.startnext.DAO;

import java.security.NoSuchAlgorithmException;
import java.sql.*;
import com.startnext.bean.AdminBean;
import com.startnext.utility.DBUtil;
import com.startnext.utility.Hasher;

public class AdminDAO {
	static private Connection con;
	static private Statement st;
	static private PreparedStatement pst;
	static private ResultSet rs;
	static private CallableStatement cs;
	public static boolean login(AdminBean ab) throws ClassNotFoundException, SQLException, NoSuchAlgorithmException {
		con=DBUtil.connect();
		pst=con.prepareStatement("select * from administrator_details where uname=?");
		pst.setString(1, ab.getUsername());
		rs=pst.executeQuery();
		while(rs.next()) {
			if(Hasher.getHash(ab.getPassword()).equals(rs.getString("pword"))) return true;
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
			ab.setPassword("");
		}
		return ab;
	}
	public static boolean signup(AdminBean ab) throws ClassNotFoundException, SQLException, NoSuchAlgorithmException {
        Connection con = null;
        PreparedStatement pst = null;

        try {
            con = DBUtil.connect();
            pst = con.prepareStatement("INSERT INTO administrator_details (fname, lname, uname, pword, mail) VALUES (?, ?, ?, ?, ?)");

            // Hash the password before storing it
            String hashedPassword = Hasher.getHash(ab.getPassword()); // Use your Hasher class

            pst.setString(1, ab.getFname());
            pst.setString(2, ab.getLname());
            pst.setString(3, ab.getUsername());
            pst.setString(4, hashedPassword);
            pst.setString(5, ab.getEmail());

            int rowsAffected = pst.executeUpdate();
            return rowsAffected > 0; // Return true if insertion was successful
        } finally {
            // Close resources in a finally block to ensure they're always closed
            if (pst != null) {
                pst.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }
}
