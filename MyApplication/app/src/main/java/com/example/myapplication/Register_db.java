package com.example.myapplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Register_db {

    public void createAccount(String username, String password) {

        Connection conn = null;
        Statement stmt = null;

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/android_db", "root", "");

            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            //STEP 3: Open a connection
            System.out.println("Connecting to database...");

            //STEP 4: Execute a query
            stmt = conn.createStatement();
            String sql;
            String query = String.format("INSERT INTO `tbl_accounts` (username,password) VALUES ('%s','%s')", username, password);
            stmt.executeUpdate(query);

            try {
                String max = "";
                query = "SELECT MAX(id) FROM tbl_accounts";
                try (Statement st = conn.createStatement()) {
                    ResultSet rs = st.executeQuery(query);
                    while (rs.next()) {
                        max = rs.getString("MAX(id)");
                    }
                }
            } catch (SQLException e) {
                System.err.println("Got an exception! ");
                System.err.println(e.getMessage());
            }
            System.out.println("saved successfully");
        } catch (SQLException | ClassNotFoundException se) {
            //Handle errors for JDBC

        } //Handle errors for Class.forName
        finally {
            //finally block used to close resources
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException se2) {
            }// nothing we can do
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
            }//end finally try
        }

    }
}
