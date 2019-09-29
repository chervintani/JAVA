/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enrollcherv;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author tanilonch_sd2023
 */
public class StudentEnroll {

    Scanner scan = new Scanner(System.in);
    Scanner fn = new Scanner(System.in);

    String a = System.getProperty("line.separator");
    int userSuc = 0;
    String username = "";
    int numOpp = 0;
    String pass = "";
    int conSuc = 0;
    String conPass = "";
    int id = 0;

    int fnSuc = 0;
    String fName = "";
    int lnSuc = 0;
    String lName = "";

    int ageSuc = 0;
    String num = "";

    int allSchedSuc = 0;
    int courseSuc = 0;
    String course = "";
    int unitSuc = 0;
    String units = "";
    int schedSuc = 0;
    String sched = "";
    String choice = "";

    Accounts account = new Accounts(id);
    Infos info = new Infos();
    ArrayList<String> accountInfo = new ArrayList<String>();
    ArrayList<Accounts> acc = new ArrayList<Accounts>();
    ArrayList<Infos> infoList = new ArrayList<Infos>();

    public void options() throws IOException {
        while (true) {
            String options = "";
            System.out.print("1. Create\n2. Retrieve\n3. Update\n4. Delete\nSelect options: ");
            options = scan.nextLine();
            System.out.println(options);
            switch (options) {
                case "1":
                    account.userVal();
                    account.passVal();
//                    acc.add(account);
                    account.reset();
                    info.fNameVal();
                    info.lNameVal();
                    info.ageVal();
//                    info.setId(account.getId());
//                    infoList.add(info);
                    info.reset();
//                    scheds();
                    saving();
//                    reset();
                    break;
                case "2":

                    try {
                        FileWriter fWriter = new FileWriter("accounts.txt", true);
                        PrintWriter writer = new PrintWriter(fWriter);
                        BufferedReader reader = new BufferedReader(new FileReader("accounts.txt"));
                        String line = reader.readLine();
                        String lineJustFetched = null;
                        String[] wordsArray;
                        int ids = 1;
                        while (true) {
                            lineJustFetched = reader.readLine();
                            if (lineJustFetched == null) {
                                break;
                            } else {
                                wordsArray = lineJustFetched.split("\t");
                                for (String each : wordsArray) {
                                    if (!"".equals(each)) {
                                        accountInfo.add(each);
                                    }
                                }
                            }
                        }
                        int count = 3;
                        while (count == 3) {
                            for (String each : accountInfo) {
                                System.out.print(each+"/t");
                            }
                            count --;
                        }

                    } catch (IOException e) {

                    }
                    System.out.printf("%-20s%-20s%-20s\n", "ID", "USERNAME", "PASSWORD");
                    for (Accounts account : acc) {
                        System.out.println(account);
                    }
//                    System.out.printf("%-20s%-20s%-20s\n", "ID", "USERNAME", "PASSWORD");
//                    for (String each : accountInfo) {
//                        System.out.println(each);
//                    }
                    System.out.printf("==================================================="
                            + "=================\n%-10s%-18s%-20s%-20s%-20s\n", "ID", "ACCOUNT ID",
                            "FIRSTNAME", "LASTNAME", "AGE");
                    for (Infos info : infoList) {
                        System.out.println(info);
                    }

                    break;
                case "3":
                    break;
                case "4":
                    break;
                default:
                    break;
            }
        }
    }

    public void scheds() {
        System.out.println("\nADDING SUBJECTS");
        //FOR THE UNIT (ADD COURSE, SCHEDULE AND UNITS)
        while (allSchedSuc == 0) {
            while (courseSuc == 0) {
                try {
                    System.out.print("Subject: ");
                    course = fn.nextLine();
                    for (int i = 0; i < course.length(); i++) {
                        char co = course.charAt(i);
                        if (Character.isDigit(co)) {
                            throw new Exception("Invalid course input!");
                        } else {
                            courseSuc = 1;
                        }
                        break;
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }

            while (unitSuc == 0) {
                try {
                    System.out.print("Units: ");
                    units = fn.nextLine();
                    if (units.matches("-?\\d+(\\.\\d+)?") == false) {
                        throw new Exception("Invalid units input, must be a number");
                    } else {
                        unitSuc = 1;
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }

            while (schedSuc == 0) {
                try {
                    System.out.print("Schedule: ");
                    sched = fn.nextLine();
                    if (sched.isEmpty()) {
                        throw new Exception("Please fill in your schedule!");
                    } else {
                        FileWriter fWriter = new FileWriter("schedule.txt", true);
                        PrintWriter writer = new PrintWriter(fWriter);
                        BufferedReader reader = new BufferedReader(new FileReader("schedule.txt"));

                        String line = reader.readLine();
                        int ids = 1;
                        while (line != null) {
                            if (line.length() != 0) {
                                ids++;
                            }
                            line = reader.readLine();
                        }

                        writer.println(ids + "\t" + id + "\t" + course + "\t" + units + "\t" + sched + "\n");
                        writer.close();
                        schedSuc = 1;
                    }

                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
            System.out.println("Your schedule is added successfully\n"
                    + "Do you want to add more? y/n");
            choice = scan.nextLine();
            if (choice.equals("y") || choice.equals("yes") || choice.equals("YES")) {
                allSchedSuc = 0;
                courseSuc = 0;
                unitSuc = 0;
                schedSuc = 0;
            } else {
                allSchedSuc = 1;
            }
        }
    }

    public void saving() {
        try {
            FileWriter fWriter = new FileWriter("accounts.txt", true);
            PrintWriter writer = new PrintWriter(fWriter);
            BufferedReader reader = new BufferedReader(new FileReader("accounts.txt"));
            String line = reader.readLine();
            String lineJustFetched = null;
            String[] wordsArray;
            int ids = 1;
            while (line != null) {
                if (line.length() != 0) {
                    ids++;
                }
                line = reader.readLine();
            }
            account.setId(ids);
            writer.println(ids + "\t" + account.getUsername() + "\t" + account.getPass() + "\t" + "\n");
            Accounts objt = new Accounts(ids, account.getUsername(), account.getPass());
            writer.close();

//            while (true) {
//                lineJustFetched = reader.readLine();
//                if (lineJustFetched == null) {
//                    break;
//                } else {
//                    wordsArray = lineJustFetched.split("\t");
//                    for (String each : wordsArray) {
//                        if (!"".equals(each)) {
//                            accountInfo.add(each);
//                        }
//                    }
//                }
//            }
            acc.add(objt);
            reader.close();
//            accounts.put(Integer.toString(id), new String[]{Integer.toString(id), username, pass});
        } catch (IOException ioe) {

        }

        try {
            FileWriter fWriter = new FileWriter("infos.txt", true);
            PrintWriter writer = new PrintWriter(fWriter);
            BufferedReader reader = new BufferedReader(new FileReader("infos.txt"));
            String line = reader.readLine();

            int ids = 1;

            while (line != null) {
                if (line.length() != 0) {
                    ids++;
                }
                line = reader.readLine();
            }
            info.setId(ids);
            writer.println(ids + "\t" + account.getId() + "\t" + info.getfName() + "\t" + info.getlName() + "\t" + info.getNum() + "\t" + "\n");
            Infos objt = new Infos(ids, account.getId(), info.getfName(), info.getlName(), info.getNum());
            writer.close();

            infoList.add(objt);
        } catch (IOException ioe) {
            System.out.println("IOException: " + ioe.getMessage());
        } finally {
            System.out.println("Student is enrolled Successfully!\n");
        }
    }

    public void reset() {
        userSuc = 0;
        numOpp = 0;
        conSuc = 0;
        fnSuc = 0;
        lnSuc = 0;
        ageSuc = 0;
        allSchedSuc = 0;
        unitSuc = 0;
        schedSuc = 0;
        courseSuc = 0;
    }
}
