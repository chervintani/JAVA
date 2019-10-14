/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compositions;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author 2ndyrGroupC
 */
public class Database {

    private final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private final String DB_URL = "jdbc:mysql://localhost/chervdb";
    private final String USER = "root";
    private final String PASS = "";
    private Connection conn = null;
    private Statement stmt = null;
    int id = 0;

    public Database() {

    }

//create
    public int[] create(Account account) {

        int[] results = new int[4];

        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);
            //STEP 3: Open a connection
            System.out.println("Connecting to database...");

            //STEP 4: Execute a query
            stmt = conn.createStatement();
            String sql;
            String query = String.format("INSERT INTO `tbl_accounts` (username,password) VALUES ('%s','%s')", account.getUsername(), account.getPassword());
            results[0] = stmt.executeUpdate(query);

            try {
                query = "SELECT MAX(id) FROM tbl_accounts";
                try (Statement st = conn.createStatement()) {
                    ResultSet rs = st.executeQuery(query);

                    while (rs.next()) {
                        results[3] = rs.getInt("MAX(id)");
                        account.setId(results[3]);
                    }
                }
            } catch (SQLException e) {
                System.err.println("Got an exception! ");
                System.err.println(e.getMessage());
            }
            System.out.println(account.getInfo());
            if (account.getInfo() != null) {
                String queryInfo = String.format("INSERT INTO `tbl_info` (account_id,firstname ,lastname , age) VALUES ('%d','%s','%s','%d')",
                        account.getId(), account.getInfo().getfName(), account.getInfo().getlName(), account.getInfo().getAge());
                results[1] = stmt.executeUpdate(queryInfo);
                id = account.getId();

                System.out.println("saved successfully");
            }

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

        return results;
    }

    public boolean create(Schedule sched) {
//        sched.setAccId(id);
        System.out.println(sched.getAccId());
        int result = 1;
        String querySched;

        querySched = String.format("INSERT INTO `tblschedules` (accountId,course,year,subject ,units,schedule) "
                + "VALUES ('%d','%s','%d','%s','%d','%s')", sched.getAccId(), sched.getSubject(), sched.getUnits(), sched.getSchedule());
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            result = stmt.executeUpdate(querySched);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return result == 1;
    }

    public ArrayList<Account> retrieveAccount() {
        ArrayList<Account> accounts = new ArrayList();
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            String sql;
            String checkQuery = "Select * from tbl_accounts ";
            ResultSet rs = stmt.executeQuery(checkQuery);
            while (rs.next()) {
                int id = rs.getInt("id");
                String username = rs.getString("username");
                String password = rs.getString("password");
                Account account = new Account(id, username, password);
                accounts.add(account);
            }

        } catch (SQLException se) {
            //Handle errors for JDBC

        } catch (Exception e) {
            //Handle errors for Class.forName
        }
        return accounts;
    }

    public ArrayList<PersonalInfo> retrieveInfo() {
        ArrayList<PersonalInfo> accounts = new ArrayList();
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            String sql;
            String checkQuery = "Select * from tbl_info ";
            ResultSet rs = stmt.executeQuery(checkQuery);
            while (rs.next()) {
                int id = rs.getInt("id");
                int accId = rs.getInt("account_id");
                String fname = rs.getString("firstname");
                String lname = rs.getString("lastname");
                int age = rs.getInt("age");
                PersonalInfo info = new PersonalInfo(id, accId, fname, lname, age);
                accounts.add(info);
            }

        } catch (SQLException se) {
            //Handle errors for JDBC

        } catch (Exception e) {
            //Handle errors for Class.forName

        }
        return accounts;

    }

    public ArrayList<Schedule> retrieveSched() {
        ArrayList<Schedule> schedules = new ArrayList();
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            String sql;
            String checkQuery = "Select * from tbl_schedules ";
            ResultSet rs = stmt.executeQuery(checkQuery);
            while (rs.next()) {
                int id = rs.getInt("id");
                int accountId = rs.getInt("account_id");
                String subject = rs.getString("subject");
                int units = rs.getInt("units");
                String schedule = rs.getString("schedule");

                Schedule sched = new Schedule(id, accountId, subject, units, schedule);
                schedules.add(sched);
            }

        } catch (SQLException se) {
            //Handle errors for JDBC

        } catch (Exception e) {
            //Handle errors for Class.forName

        }
        return schedules;

    }
//update

    public boolean schedUpdate(int id, Schedule sched) throws IOException {
        int accountId = id;
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            String sql;
            String checkQuery = String.format("Select * from tbl_accounts  where id = '%s'", accountId);
            ResultSet check = stmt.executeQuery(checkQuery);
            if (!check.next()) {
                return false;
            } else {
                sql = "SELECT * FROM tbl_schedules where account_id =" + accountId;
                try (ResultSet rs = stmt.executeQuery(sql)) {
                    if (!rs.next()) {
                        String querySched = String.format("INSERT INTO `tbl_schedules` (account_id, subject ,units ,schedule) "
                                + "VALUES ('%d','%s','%d','%s')",
                                accountId, sched.getSubject(), sched.getUnits(), sched.getSchedule());
                        stmt.executeUpdate(querySched);
                        System.out.println("schedule has beed added!");
                    } else {
                        String updateQuery = "update tbl_schedules set subject=? ,units=? ,schedule=? where account_id='"
                                + accountId + "'";
                        PreparedStatement ps1 = conn.prepareStatement(updateQuery);
                        ps1.setString(1, sched.getSubject());
                        ps1.setInt(2, sched.getUnits());
                        ps1.setString(3, sched.getSchedule());
//                        ps1.executeUpdate();
                        System.out.println(ps1.executeUpdate());
                        System.out.println("updated successfully");
                    }
                }
                stmt.close();
                conn.close();
            }
        } catch (SQLException se) {
            //Handle errors for JDBC

        } catch (Exception e) {
            //Handle errors for Class.forName

        }

        return true;
    }

    public boolean infoUpdate(int id, PersonalInfo new_info) throws IOException {
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            String sql;
            //STEP 5: Get the employee_id for whom data need to be updated/inserted
            int accountId = id;
            String checkQuery = String.format("Select * from tbl_accounts  where id = '%s'", accountId);
            ResultSet check = stmt.executeQuery(checkQuery);
            if (!check.next()) {
                return false;
            } else {
                sql = "SELECT * FROM tbl_info where account_id =" + accountId;
                try (ResultSet rs = stmt.executeQuery(sql)) {
                    if (!rs.next()) {
                        String queryInfo = String.format("INSERT INTO `tbl_info` (account_id,firstname ,lastname , age) VALUES ('%d','%s','%s','%d')",
                                new_info.getAccId(), new_info.getlName(), new_info.getlName(), new_info.getAge());
                        stmt.executeUpdate(queryInfo);
                    } else {
                        String updateQuery = "update tbl_info set firstname=?, lastname=?, age=? where account_id='"
                                + accountId + "'";
                        PreparedStatement ps1 = conn.prepareStatement(updateQuery);
                        ps1.setString(1, new_info.getfName());
                        ps1.setString(2, new_info.getlName());
                        ps1.setInt(3, new_info.getAge());
                        ps1.executeUpdate();
                        System.out.println("updated successfully");
                    }
                    //Clean-up environment
                }
                stmt.close();
                conn.close();
            }
        } catch (SQLException se) {
            //Handle errors for JDBC

        } catch (Exception e) {
            //Handle errors for Class.forName

        }

        return true;
    }

// delete
    public boolean infoDelete(int id) throws IOException {
        int executeUpdate = 0;
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            stmt = (Statement) conn.createStatement();
            String query1 = String.format("delete from  tbl_info where account_id = '%d'", id);
            executeUpdate = stmt.executeUpdate(query1);
            conn.close();
        } catch (SQLException se) {
            System.out.println(se.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return executeUpdate > 0;

    }

    public boolean schedDelete(int id) throws IOException {
        int executeUpdate = 0;
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            stmt = (Statement) conn.createStatement();
            String query1 = String.format("delete from  tbl_schedules where account_id = '%d'", id);
            executeUpdate = stmt.executeUpdate(query1);
            conn.close();
        } catch (SQLException se) {
            System.out.println(se.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            //Handle errors for Class.forName

        }
        return executeUpdate > 0;
    }

//    search
    public ArrayList<Account> accSearch(int id) {
        ArrayList<Account> accounts = new ArrayList();
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            String checkQuery = "Select * from tbl_accounts where id ='" + id + "'";
            ResultSet rs = stmt.executeQuery(checkQuery);
            while (rs.next()) {
                Account acct = new Account(rs.getInt("id"), rs.getString("username"), rs.getString("password"));
                accounts.add(acct);
            }

        } catch (SQLException se) {
            //Handle errors for JDBC

        } catch (Exception e) {
            //Handle errors for Class.forName

        }
        return accounts;
    }

    public ArrayList<PersonalInfo> infoSearch(int id) {

        ArrayList<PersonalInfo> accounts = new ArrayList();
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            String sql;
            String checkQuery = "Select * from tbl_info where id ='" + id + "'";
            ResultSet rs = stmt.executeQuery(checkQuery);
            while (rs.next()) {
                PersonalInfo info = new PersonalInfo(rs.getInt("id"), rs.getInt("account_id"), rs.getString("firstname"), rs.getString("lastname"), rs.getInt("age"));
                accounts.add(info);
            }

        } catch (SQLException se) {
            //Handle errors for JDBC

        } catch (Exception e) {
            //Handle errors for Class.forName

        }
        return accounts;

    }

    public ArrayList<Schedule> schedSearch(int id) {
        ArrayList<Schedule> schedules = new ArrayList();
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            String sql;
            String checkQuery = "Select * from tbl_schedules  where account_id ='" + id + "'";
            ResultSet rs = stmt.executeQuery(checkQuery);
            while (rs.next()) {
                int rsid = rs.getInt("id");
                int accountId = rs.getInt("account_id");
                String schedule = rs.getString("schedule");
                String subject = rs.getString("subject");
                int units = rs.getInt("units");
                Schedule sched = new Schedule(rsid, accountId, subject, units, schedule);
                schedules.add(sched);
            }

        } catch (SQLException se) {
            //Handle errors for JDBC

        } catch (Exception e) {
            //Handle errors for Class.forName

        }
        return schedules;
    }
}
