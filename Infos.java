/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trycatchExperiment;

import java.util.Scanner;

/**
 *
 * @author tanilonch_sd2023
 */
public class Infos {

    Scanner scan = new Scanner(System.in);
    private int fnSuc = 0;
    private String fName = "";
    private int lnSuc = 0;
    private String lName = "";
    private int ageSuc = 0;
    private String num = "";
    private int id;

    public Infos() {
    }
    
    
    
    public Infos(int id) {
        id = this.id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    public void fNameVal() {
        //FOR THE FIRSTNAME     
        System.out.println("\nPERSONAL INFORMATION");
        while (fnSuc == 0) {
            try {
                System.out.print("Enter firstname: ");
                fName = scan.nextLine();
                for (int i = 0; i < fName.length(); i++) {
                    char c = fName.charAt(i);
                    if (Character.isDigit(c) || fName.equals(" ")) {
                        throw new Exception("Invalid first name input!");
                    } else {
                        fnSuc = 1;
                    }
                    break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void lNameVal() {
        //FOR THE LASTNAME
        while (lnSuc == 0) {
            try {
                System.out.print("Enter lastname: ");
                lName = scan.nextLine();
                for (int i = 0; i < lName.length(); i++) {
                    char ce = lName.charAt(i);
                    if (Character.isDigit(ce) || lName.equals(" ")) {
                        throw new Exception("Invalid last name input!");
                    } else {
                        lnSuc = 1;
                    }
                    break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void ageVal() {
        //FOR THE AGE
        while (ageSuc == 0) {
            try {
                System.out.print("Enter age: ");
                num = scan.nextLine();
                if (num.matches("-?\\d+(\\.\\d+)?") == false) {
                    throw new Exception("Invalid age input!");
                } else {
                    ageSuc = 1;
                }
                try {
                    if (num.equals("1")) {
                        throw new Exception("Age only 1 and above");
                    } else {
                        ageSuc = 1;
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
    
    public void reset(){
        fnSuc = 0;
        lnSuc = 0;
        ageSuc = 0;
    }

    @Override
    public String toString() {
        return String.format("%-20s%-20s%-20s%-20s", id, fName, lName, num);
    }
}
