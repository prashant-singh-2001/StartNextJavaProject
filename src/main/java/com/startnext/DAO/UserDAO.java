package com.startnext.DAO;

import java.security.NoSuchAlgorithmException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.startnext.bean.StartupBean;
import com.startnext.bean.UserBean;
import com.startnext.utility.DBUtil;
import com.startnext.utility.Hasher;

public class UserDAO {
    public static UserBean signup(UserBean ub) throws SQLException, NoSuchAlgorithmException, ClassNotFoundException {
        try (Connection con = DBUtil.connect()) {
            int id = getMaxID(con) + 1; // Pass the connection to getMaxID method
            String hashedPassword = Hasher.getHash(ub.getPassword()); // Hash the password
            ub.setStart_id(ub.getFname().substring(0, 3)+Math.random()*1000);
            try (PreparedStatement pst = con.prepareStatement("INSERT INTO startnext.user_details (uid, fname, lname, uname, pword, mail,contact,statup_id) VALUES (?, ?, ?, ?, ?, ?,?,?)")) {
                pst.setInt(1, id);
                pst.setString(2, ub.getFname());
                pst.setString(3, ub.getLname());
                pst.setString(4, ub.getUsername());
                pst.setString(5, hashedPassword); // Use hashed password
                pst.setString(6, ub.getMail());
                pst.setLong(7, ub.getContact());
                pst.setString(8, ub.getStart_id());
                int rowsAffected = pst.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Successful");
                    return ub;
                }
            }
        } catch (SQLException | NoSuchAlgorithmException | ClassNotFoundException e) {
            e.printStackTrace();
            throw e;
        }
        return null;
    }

    private static int getMaxID(Connection con) throws SQLException {
        int maxId = 0;
        try (Statement st = con.createStatement(); ResultSet rs = st.executeQuery("SELECT max(uid) as uid  FROM USER_DETAILS")) {
            while (rs.next()) {
                maxId = rs.getInt("uid");
            }
        }
        return maxId;
    }

    public static UserBean login(UserBean ub) throws SQLException, NoSuchAlgorithmException, ClassNotFoundException {
        try (Connection con = DBUtil.connect()) {
            String hashedPassword = Hasher.getHash(ub.getPassword()); // Hash the provided password

            try (PreparedStatement pst = con.prepareStatement("SELECT * FROM startnext.user_details WHERE uname = ? AND pword = ?")) {
                pst.setString(1, ub.getUsername());
                pst.setString(2, hashedPassword);

                try (ResultSet rs = pst.executeQuery()) {
                    if (rs.next()) {
                        UserBean loggedInUser = new UserBean();
                        loggedInUser.setId(rs.getInt("uid"));
                        loggedInUser.setFname(rs.getString("fname"));
                        loggedInUser.setLname(rs.getString("lname"));
                        loggedInUser.setUsername(rs.getString("uname"));
                        loggedInUser.setMail(rs.getString("mail"));

                        loggedInUser.setPassword("null");
                        return loggedInUser;
                    }
                }
            }
        } catch (SQLException | NoSuchAlgorithmException | ClassNotFoundException e) {
            e.printStackTrace();
            throw e;
        }
        return null;
    }
    
    public static ArrayList<StartupBean> follow(int id) throws ClassNotFoundException, SQLException{
    	Connection con=DBUtil.connect();
    	CallableStatement cs;
    	ResultSet rs;
    	ArrayList<StartupBean> slist=new ArrayList<StartupBean>();
    	cs=con.prepareCall("call startnext.getuser_likes(?);");
    	cs.setInt(1, id);
    	rs=cs.executeQuery();
    	while(rs.next()) {
    		
    	}
    	return slist;
    	
    }
}
