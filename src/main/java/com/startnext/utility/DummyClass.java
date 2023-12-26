package com.startnext.utility;

import java.security.NoSuchAlgorithmException;
import java.sql.*;

public class DummyClass {
	static Connection connection;
	public static boolean batchUpdatePassword(String tableName) throws ClassNotFoundException, SQLException, NoSuchAlgorithmException {
		connection=DBUtil.connect();
		 String selectQuery = "SELECT uname, pword FROM "+tableName;
         PreparedStatement selectStmt = connection.prepareStatement(selectQuery);
         ResultSet resultSet = selectStmt.executeQuery();
         int i=0;
         while (resultSet.next()) {
             String username = resultSet.getString("uname");
             String password = resultSet.getString("pword");

             // Hash the password
             String hashedPassword = Hasher.getHash(password); // Use your Hasher class

             // Update the hashed password in the database
             String updateQuery = "UPDATE "+tableName+" SET pword = ? WHERE uname = ?";
             PreparedStatement updateStmt = connection.prepareStatement(updateQuery);
             updateStmt.setString(1, hashedPassword);
             updateStmt.setString(2, username);
             i+=updateStmt.executeUpdate();
         }
         System.out.println("Passwords updated successfully!");
         if(i>0) return true;
         return false;
	}
}
