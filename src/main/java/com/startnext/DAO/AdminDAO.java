package com.startnext.DAO;

import java.security.NoSuchAlgorithmException;
import java.sql.*;
import com.startnext.bean.AdminBean;
import com.startnext.utility.DBUtil;
import com.startnext.utility.Hasher;

public class AdminDAO {
    // Removed static variables, prefer local variables to avoid shared state

    // Validate admin login credentials
    public static boolean login(AdminBean ab) throws ClassNotFoundException, SQLException, NoSuchAlgorithmException {
        try (Connection con = DBUtil.connect()) {
            // Prepared statement to fetch the user based on username
            try (PreparedStatement pst = con.prepareStatement("SELECT * FROM administrator_details WHERE uname = ?")) {
                pst.setString(1, ab.getUsername());
                try (ResultSet rs = pst.executeQuery()) {
                    // Iterate through the result set
                    while (rs.next()) {
                        // Check if the hashed password matches the stored hashed password
                        if (Hasher.getHash(ab.getPassword()).equals(rs.getString("pword"))) {
                            return true; // Password matches, login successful
                        }
                    }
                }
            }
        }
        return false; // No match found for username/password
    }

    // Retrieve admin details
    public static AdminBean getuser(AdminBean ab) throws ClassNotFoundException, SQLException {
        try (Connection con = DBUtil.connect()) {
            try (PreparedStatement pst = con.prepareStatement("SELECT * FROM administrator_details WHERE uname = ?")) {
                pst.setString(1, ab.getUsername());
                try (ResultSet rs = pst.executeQuery()) {
                    // Iterate through the result set
                    while (rs.next()) {
                        // Set admin details from the result set
                        ab.setFname(rs.getString("fname"));
                        ab.setLname(rs.getString("lname"));
                        ab.setEmail(rs.getString("mail"));
                        ab.setPassword(""); // Remove password for security
                    }
                }
            }
        }
        return ab; // Return AdminBean with updated details
    }

    // Register a new admin
    public static boolean signup(AdminBean ab) throws ClassNotFoundException, SQLException, NoSuchAlgorithmException {
        try (Connection con = DBUtil.connect()) {
            // Prepared statement for inserting new admin
            try (PreparedStatement pst = con.prepareStatement("INSERT INTO administrator_details (fname, lname, uname, pword, mail) VALUES (?, ?, ?, ?, ?)")) {
                // Hash the password before storing it
                String hashedPassword = Hasher.getHash(ab.getPassword()); // Use your Hasher class

                pst.setString(1, ab.getFname());
                pst.setString(2, ab.getLname());
                pst.setString(3, ab.getUsername());
                pst.setString(4, hashedPassword);
                pst.setString(5, ab.getEmail());

                int rowsAffected = pst.executeUpdate();
                return rowsAffected > 0; // Return true if insertion was successful
            }
        }
    }
}

