/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trycatchexperiment;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
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
    Scanner newer = new Scanner(System.in);
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
    int courseSuc2 = 0;
    String course = "";
    int unitSuc = 0;
    int unitSuc2 = 0;
    String units = "";
    int schedSuc = 0;
    String sched = "";
    String choice = "";
//    String newUser = "";
    String newName = "";
    String oldName = "";
    String newName2 = "";
    String oldName2 = "";
    String oldNum = "";
    String newNum2 = "";
    String oldSub = "";
    String newSub = "";
    int oldUnit = 0;
    String newUnit = "";
    int schedSuc2 = 0;
    String oldSched = "";
    String newSched = "";
    Accounts account = new Accounts(id);
    String delInfo = "";
    Infos info = new Infos();
    Schedules schedObj = new Schedules();
//    Accounts accObj = new Accounts();
    ArrayList<String> accountInfo = new ArrayList<String>();
    ArrayList<Accounts> acc = new ArrayList<Accounts>();
    ArrayList<Infos> infoList = new ArrayList<Infos>();

    ArrayList<Schedules> schedList = new ArrayList<Schedules>();

    public void options() throws IOException {
        while (true) {
            String options = "";
            System.out.print("1. Create\n2. Retrieve\n3. Update\n4. Delete\n5. Search\n6. Save\nSelect options: ");
            options = scan.nextLine();
            System.out.println(options);
            switch (options) {
                case "1":
                    account.userVal();
                    account.passVal();
//                    accObj.setId(account.getId());
                    Accounts ab = new Accounts(account.getId(), account.getUsername(), account.getPass());
                    acc.add(ab);
                    account.reset();
                    System.out.println("Do you want to add personal information? y/n");
                    String cho = scan.nextLine();
                    if (cho.equals("y") || cho.equals("yes") || cho.equals("YES")) {
                        info.fNameVal();
                        info.lNameVal();
                        info.ageVal();
                        info.setAccId(account.getId());
                        Infos i = new Infos(info.getId(), info.getAccId(), info.getfName(), info.getlName(), info.getNum());
                        infoList.add(i);
                        info.reset();

                    }
                    System.out.println("Do you want to add schedule? y/n");
                    String cho2 = scan.nextLine();
                    if (cho2.equals("y") || cho2.equals("yes") || cho2.equals("YES")) {
                        scheds();
                    }

                    reset();
                    break;
                case "2":
                    System.out.println("Retrieve by:\n1. Accounts\n2. Personal Information\n3. Schedule");
                    String option = scan.nextLine();
                    if (option.equals("1")) {

                        try {
                            acc.clear();
                            String[] res = null;
                            BufferedReader reader = new BufferedReader(new FileReader("accounts.txt"));

                            String line = reader.readLine();
                            while (line != null) {
                                if (!line.isEmpty()) {
                                    res = line.split("\t");
                                    account.setId(Integer.parseInt(res[0]));
                                    account.setUsername(res[1]);
                                    account.setPass(res[2]);
                                    Accounts a = new Accounts(account.getId(), account.getUsername(), account.getPass());
                                    acc.add(a);
                                }
                                line = reader.readLine();
                            }
                            reader.close();
                        } catch (IOException e) {

                        }
                        System.out.printf("%-20s%-20s%-20s\n", "ID", "USERNAME", "PASSWORD");
                        for (Accounts account : acc) {
                            System.out.println(account);
                        }
                    } else if (option.equals("2")) {
                        try {
                            infoList.clear();
                            String[] res = null;
                            BufferedReader reader = new BufferedReader(new FileReader("infos.txt"));

                            String line = reader.readLine();
                            while (line != null) {
                                if (!line.isEmpty()) {
                                    res = line.split("\t");
                                    info.setId(Integer.parseInt(res[0]));
                                    info.setAccId(Integer.parseInt(res[1]));
                                    info.setfName(res[2]);
                                    info.setlName(res[3]);
                                    info.setNum(res[4]);
                                    info.setAccId(account.getId());
                                    Infos i = new Infos(info.getId(), info.getAccId(), info.getfName(), info.getlName(), info.getNum());
                                    infoList.add(i);
                                }
                                line = reader.readLine();
                            }
                            reader.close();
                        } catch (IOException e) {

                        }
                        System.out.printf("==================================================="
                                + "=================\n%-10s%-18s%-20s%-20s%-20s\n", "ID", "ACCOUNT ID",
                                "FIRSTNAME", "LASTNAME", "AGE");
                        for (Infos info : infoList) {
                            System.out.println(info);
                        }
                    } else if (option.equals("3")) {
                        try {
                            schedList.clear();
                            String[] res = null;
                            BufferedReader reader = new BufferedReader(new FileReader("schedule.txt"));

                            String line = reader.readLine();
                            while (line != null) {
                                if (!line.isEmpty()) {
                                    res = line.split("\t");

                                    schedObj.setId(Integer.parseInt(res[0]));
                                    schedObj.setAccId(Integer.parseInt(res[1]));
                                    schedObj.setCourse(res[2]);
                                    schedObj.setUnits(Integer.parseInt(res[3]));
                                    schedObj.setSched(res[4]);
                                    Schedules s = new Schedules(schedObj.getId(), schedObj.getAccId(),
                                            schedObj.getCourse(), schedObj.getUnits(), schedObj.getSched());
                                    schedList.add(s);
                                }
                                line = reader.readLine();
                            }
                            reader.close();
                        } catch (IOException e) {

                        }
                        System.out.printf("==================================================="
                                + "=================\n%-10s%-18s%-20s%-20s%-20s\n", "ID", "ACCOUNT ID",
                                "SUBJECT", "UNITS", "SCHEDULE");
                        for (Schedules each : schedList) {
                            System.out.println(each);
                        }
                    } else {
                        System.out.println("Invalid input!\n");
                    }
                    break;
                case "3":
                    //FOR THE UPDATE
                    System.out.print("Update by:\n1. Personal Information\n2. Schedule\n:");
                    String option3 = scan.nextLine();
                    if (option3.equals("1")) {
                        //FOR THE ACCOUNTS YOU WANT TO UPDATE
                        Infos upInfo = new Infos();
//                        displayInfo();
                        System.out.print("Enter ID you want to update: ");
                        String idInp = scan.nextLine();
                        //I STOPPED RIGHT HERE I NEED REST!!!!!!!!!!!!!
                        //I STOPPED HERE FOR UPDATING PERSONAL INFORMATION
                        for (int i = 0; i < acc.size(); i++) {
                            if (acc.get(i).getId() == Integer.parseInt(idInp)) {
                                while (fnSuc == 0) {
                                    try {
                                        System.out.print("Enter new firstname: ");
                                        String newfName = newer.nextLine();
                                        for (int j = 0; j < newfName.length(); j++) {
                                            char c = newfName.charAt(j);
                                            if (Character.isDigit(c) || newfName.equals(" ")) {
                                                throw new Exception("Invalid new first name input!");
                                            } else {
                                                info.setfName(newfName);
//                                                infoList.get(i).setfName(newfName);
                                                fnSuc = 1;
                                            }
                                            break;
                                        }
                                    } catch (Exception e) {
                                        System.out.println(e.getMessage());
                                    }
                                }
                                while (lnSuc == 0) {
                                    try {
                                        System.out.print("Enter new lastname: ");
                                        String newlName = scan.nextLine();
                                        for (int l = 0; l < newlName.length(); i++) {
                                            char ce = newlName.charAt(l);
                                            if (Character.isDigit(ce) || newlName.equals(" ")) {
                                                throw new Exception("Invalid new last name input!");
                                            } else {
                                                info.setlName(newlName);
                                                lnSuc = 1;
                                            }
                                            break;
                                        }
                                    } catch (Exception e) {
                                        System.out.println(e.getMessage());
                                    }
                                }
                                while (ageSuc == 0) {
                                    try {
                                        System.out.print("Enter new age: ");
                                        String newAge = scan.nextLine();
                                        if (newAge.matches("-?\\d+(\\.\\d+)?") == false) {
                                            throw new Exception("Invalid new age input!");
                                        } else {
                                            try {
                                                if (Integer.parseInt(newAge) < 1) {
                                                    throw new Exception("Age should not be 0!");
                                                } else {
                                                    info.setNum(newAge);
                                                    ageSuc = 1;
                                                    info.setAccId(account.getId());
                                                    infoList.add(info);
//                                                    System.out.println("New information saved\n");
                                                }
                                            } catch (Exception e) {
                                                System.out.println(e.getMessage());
                                            }
                                        }
                                    } catch (Exception e) {
                                        System.out.println(e.getMessage());
                                    }
                                }

//                                Infos newInfo = new Infos();
                            }
                        }
                    } else if (option3.equals("2")) {
//                        displaySched();
                        System.out.print("Enter ID you want to update: ");
                        String idInp2 = scan.nextLine();
                        for (int i = 0; i < acc.size(); i++) {
                            if (acc.get(i).getId() == Integer.parseInt(idInp2)) {
                                while (courseSuc2 == 0) {
                                    try {
                                        System.out.print("Enter new subject: ");
                                        String newSub2 = scan.nextLine();
//                                        for (int s = 0; s < newSub.length(); s++) {
//                                            char co = newSub.charAt(s);
//                                            if (Character.isDigit(co)) {
//                                                throw new Exception("Invalid course input!");
//                                            } else {
                                        schedObj.setCourse(newSub2);
                                        courseSuc2 = 1;
//                                            }
                                        break;
//                                        }
                                    } catch (Exception e) {
                                        System.out.println(e.getMessage());
                                    }
                                }

                                while (unitSuc2 == 0) {
                                    try {
                                        System.out.print("Enter new units: ");
                                        String newUnit2 = fn.nextLine();
//                                        if (newUnit.matches("-?\\d+(\\.\\d+)?") == false) {
//                                            throw new Exception("Invalid units input, must be a number");
//                                        } else {
                                        schedObj.setUnits(Integer.parseInt(newUnit2));
                                        unitSuc2 = 1;
//                                        }
                                    } catch (Exception e) {
                                        System.out.println(e.getMessage());
                                    }
                                }

                                while (schedSuc2 == 0) {
                                    try {
                                        System.out.print("Enter new schedule: ");
                                        String newSched2 = fn.nextLine();
                                        if (newSched2.isEmpty()) {
                                            throw new Exception("Please fill in your new schedule!");
                                        } else {
                                            schedObj.setSched(newSched2);
                                            schedObj.setAccId(account.getId());
                                            schedList.add(schedObj);
                                            schedSuc2 = 1;
                                        }

                                    } catch (Exception e) {
                                        System.out.println(e.getMessage());
                                    }
                                }
                            }
                        }
                        reset();
                    }
                    break;

                case "4":
                    System.out.print("Delete by:\n1. Personal Information\n2. Schedule\n:");
                    String choice4 = scan.nextLine();
                    if (choice4.equals("1")) {
                        displayInfo();
                        System.out.print("Delete personal information by ID: ");
                        String delInfo = scan.nextLine();
                        for (int i = 0; i < infoList.size(); i++) {
                            if (infoList.get(i).getId() == Integer.parseInt(delInfo)) {
                                infoList.remove(i);
                            }
                        }
                        System.out.println("Deleted successfully");
                    } else if (choice4.equals("2")) {
                        displaySched();
                        System.out.print("Delete schedule by ID: ");
                        String delSched = scan.nextLine();
                        for (int i = 0; i < schedList.size(); i++) {
                            if (schedList.get(i).getId() == Integer.parseInt(delSched)) {
                                schedList.remove(i);
                                break;
                            }

                        }
                    }
                    System.out.println("Deleted successfully");

                    break;

                case "5":
                    System.out.print("Search by:\n1. Account\n2. Personal Information\n3. Schedule\n:");
                    String choice5 = scan.nextLine();
                    if (choice5.equals("1")) {
                        System.out.print("Search account by ID: ");
                        String ai = scan.nextLine();
                        System.out.printf("%-20s%-20s%-20s\n", "ID", "USERNAME", "PASSWORD");
                        System.out.println(" ");
                        for (int i = 0; i < acc.size(); ++i) {
                            if (Integer.parseInt(ai) == (acc.get(i).getId())) {
                                System.out.println(acc.get(i).toString());
                            } else {
                                System.out.println("NOT FOUND");
                                break;
                            }
                        }
                    } else if (choice5.equals("2")) {
                        System.out.print("Search information by ID: ");
                        String si = scan.nextLine();
                        System.out.printf("==================================================="
                                + "=================\n%-10s%-18s%-20s%-20s%-20s\n", "ID", "ACCOUNT ID",
                                "FIRSTNAME", "LASTNAME", "AGE");
                        System.out.println(" ");
                        for (int i = 0; i < infoList.size(); ++i) {
                            if (Integer.parseInt(si) == (infoList.get(i).getId())) {
                                System.out.println(infoList.get(i).toString());
                            }
                        }
                    } else if (choice5.equals("3")) {
                        System.out.print("Search schedule by ID: ");
                        String ss = scan.nextLine();
                        System.out.printf("%-10s%-18s%-20s%-20s%-20s", "ID", "ACCOUNT ID", "COURSE", "UNITS", "SCHEDULE");
                        System.out.println(" ");
                        for (int i = 0; i < schedList.size(); ++i) {
                            if (Integer.parseInt(ss) == (schedList.get(i).getId())) {
                                System.out.println(schedList.get(i).toString());
                            }
                        }
                    }
                    break;
                case "6":
                    saving();
                    System.out.println("Updated Successfully");
                    break;

            }
        }
    }

    public ArrayList<String> getAccountInfo() {
        return accountInfo;
    }

    public void setAccountInfo(ArrayList<String> accountInfo) {
        this.accountInfo = accountInfo;
    }

    public ArrayList<Accounts> getAcc() {
        return acc;
    }

    public void setAcc(ArrayList<Accounts> acc) {
        this.acc = acc;
    }

    public ArrayList<Infos> getInfoList() {
        return infoList;
    }

    public void setInfoList(ArrayList<Infos> infoList) {
        this.infoList = infoList;
    }

    public ArrayList<Schedules> getSchedList() {
        return schedList;
    }

    public void setSchedList(ArrayList<Schedules> schedList) {
        this.schedList = schedList;
    }

    public void displayAcc() {
        System.out.printf("%-20s%-20s%-20s\n", "ID", "USERNAME", "PASSWORD");
        System.out.println(" ");
        for (Accounts a : acc) {
            System.out.println(a);
        }
    }

    public void displayInfo() {
        System.out.printf("==================================================="
                + "=================\n%-10s%-18s%-20s%-20s%-20s\n", "ID", "ACCOUNT ID",
                "FIRSTNAME", "LASTNAME", "AGE");
        System.out.println(" ");
        for (Infos i : infoList) {
            System.out.println(i);
        }
    }

    public void displaySched() {
        System.out.printf("%-10s%-18s%-20s%-20s%-20s", "ID", "ACCOUNT ID", "COURSE", "UNITS", "SCHEDULE");
        System.out.println(" ");
        for (Schedules s : schedList) {
            System.out.println(s);
        }
    }

    public void update() throws IOException {

        FileWriter fWriter = new FileWriter("schedule.txt", true);
        PrintWriter writer = new PrintWriter(fWriter);
        BufferedReader reader = new BufferedReader(new FileReader("schedule.txt"));

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
                            schedObj.setCourse(course);
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
                        schedObj.setUnits(Integer.parseInt(units));
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
                        schedObj.setSched(sched);
                        schedObj.setAccId(account.getId());
                        schedList.add(schedObj);
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

    public void clearTheFile() throws IOException {
        FileWriter fwOb = new FileWriter("infos.txt", false);
        FileWriter fwOb2 = new FileWriter("accounts.txt", false);
        PrintWriter pwOb = new PrintWriter(fwOb, false);
        PrintWriter pwOb2 = new PrintWriter(fwOb2, false);
        pwOb.flush();
        pwOb2.flush();
        pwOb.close();
        pwOb2.close();
        fwOb.close();
        fwOb2.close();
        FileWriter fwOb3 = new FileWriter("schedule.txt", false);
        PrintWriter pwOb3 = new PrintWriter(fwOb3, false);
        pwOb3.flush();
        pwOb3.close();

    }

    public void saving() throws IOException {
        clearTheFile();
        try {
            FileWriter fWriter = new FileWriter("accounts.txt", true);
            PrintWriter writer = new PrintWriter(fWriter);
            BufferedReader reader = new BufferedReader(new FileReader("accounts.txt"));
            String line = reader.readLine();
            int ids = 1;
            while (line != null) {
                if (line.length() != 0) {
                    ids++;
                }
                line = reader.readLine();
            }
            account.setId(ids);
            for (int i = 0; i < acc.size(); ++i) {
                writer.println(acc.get(i).getId()+ "\t" + acc.get(i).getUsername() + "\t" + acc.get(i).getPass() + "\n");
            }
            writer.close();
            reader.close();
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
            for (int i = 0; i < infoList.size(); ++i) {
                writer.println(ids + "\t" + infoList.get(i).getAccId() + "\t" + infoList.get(i).getfName() + "\t" + infoList.get(i).getlName() + "\t" + infoList.get(i).getNum() + "\t" + "\n");
            }
            writer.close();

        } catch (IOException ioe) {
            System.out.println("IOException: " + ioe.getMessage());
        }

        try {

            FileWriter fWriter = new FileWriter("schedule.txt", false);
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

            for (int i = 0; i < schedList.size(); ++i) {
                writer.println(ids + "\t" + schedList.get(i).getAccId() + "\t" + schedList.get(i).getCourse() + "\t" + schedList.get(i).getUnits() + "\t" + schedList.get(i).getSched() + "\n");
            }

            writer.close();
            reader.close();
        } catch (IOException ioe) {

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
        schedSuc2 = 0;
        courseSuc = 0;
        courseSuc2 = 0;
        unitSuc2 = 0;
    }
    
    public int retrieveData(){
        int id = acc.get(1).getId();
        return id;
    }
}
