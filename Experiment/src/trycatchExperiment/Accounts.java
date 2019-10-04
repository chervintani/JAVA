/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trycatchexperiment;

import java.util.Scanner;

/**
 *
 * @author tanilonch_sd2023
 */
public class Accounts {

    Scanner scan = new Scanner(System.in);
    private int userSuc = 0;
    private String username = "";
    private int numOpp = 0;
    private String pass = "";
    private String conPass = "";
    private int conSuc = 0;
    private int id;

    public Accounts(int id) {
        id = this.id;
    }

    public Accounts(int id, String username, String pass) {
        this.id = id;
        this.username = username;
        this.pass = pass;
    }

    Accounts() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;

    }

    public void userVal() {

        //FOR THE PASS
        System.out.println("\n\n================Student Enrollment================");
        while (userSuc == 0) {
            try {
                System.out.print("Username: ");
                username = scan.nextLine();
                if (username.matches("-?\\d+(\\.\\d+)?")) {
                    throw new Exception("Invalid username input!");
                } else {
                    userSuc = 1;
                }
                if (username.isEmpty() || username.contains(" ")) {
                    throw new Exception("Invalid username input! There might be space provided or is empty");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void passVal() {

        while (numOpp == 0) {
            try {
                System.out.print("Password: ");
                pass = scan.nextLine();
                if (pass.length() < 8) {
                    throw new Exception("Password must be 8 characters");
                } else {
                    numOpp = 1;
                }
            } catch (Exception exe) {
                System.out.println(exe.getMessage());
            }
        }
        while (conSuc == 0) {
            try {
                System.out.print("Confirm Password: ");
                conPass = scan.nextLine();
                if (!pass.equals(conPass)) {
                    throw new Exception("Password not matched!");
                } else {
                    conSuc = 1;
                    id++;

                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
    
    
    
    public void reset() {
        userSuc = 0;
        numOpp = 0;
        conSuc = 0;
    }

    @Override
    public String toString() {
        return String.format("%-20s%-20s%-20s", id, username, pass);
    }
}
