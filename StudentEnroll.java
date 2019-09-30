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
                    account.reset();
                    System.out.println("Do you want to add personal information? y/n");
                    String cho = scan.nextLine();
                    if (cho.equals("y") || cho.equals("yes") || cho.equals("YES")) {
                        info.lNameVal();
                        info.ageVal();
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
                        displayInfo();
                        System.out.print("Enter ID you want to update: ");
                        String idInp = scan.nextLine();
                        //I STOPPED RIGHT HERE I NEED REST!!!!!!!!!!!!!
                        //I STOPPED HERE FOR UPDATING PERSONAL INFORMATION
                        for (int i = 0; i < infoList.size(); i++) {
                            if (infoList.get(i).getId() == Integer.parseInt(idInp)) {
                                while (fnSuc == 0) {
                                    displayInfo();
                                    try {
                                        System.out.print("Enter new firstname: ");
                                        String newfName = newer.nextLine();
                                        for (int j = 0; j < newfName.length(); j++) {
                                            char c = newfName.charAt(j);
                                            if (Character.isDigit(c) || newfName.equals(" ")) {
                                                throw new Exception("Invalid new first name input!");
                                            } else {
                                                oldName = infoList.get(i).getfName();
                                                newName = newfName;
//                                                modifyFile("infos.txt", infoList.get(i).getfName(), newfName);
                                                infoList.get(i).setfName(newfName);
//                                                System.out.println("Updated successfully!");
//                                                displayInfo();
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
                                                oldName2 = infoList.get(l).getlName();
                                                newName2 = newlName;
//                                                modifyFile("infos.txt", infoList.get(i).getfName(), newfName);
                                                infoList.get(l).setlName(newlName);
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
                                                    oldNum = infoList.get(i).getNum();
                                                    newNum2 = newAge;
//                                                modifyFile("infos.txt", infoList.get(i).getfName(), newfName);
                                                    infoList.get(i).setNum(newAge);
                                                    ageSuc = 1;
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
                            }
                        }
                    } else if (option3.equals("2")) {
                        displaySched();
                        System.out.print("Enter ID you want to update: ");
                        String idInp2 = scan.nextLine();
                        for (int i = 0; i < schedList.size(); i++) {
                            if (schedList.get(i).getId() == Integer.parseInt(idInp2)) {
                                while (courseSuc2 == 0) {
                                    try {
                                        System.out.print("Enter new subject: ");
                                        String newSub2 = scan.nextLine();
//                                        for (int s = 0; s < newSub.length(); s++) {
//                                            char co = newSub.charAt(s);
//                                            if (Character.isDigit(co)) {
//                                                throw new Exception("Invalid course input!");
//                                            } else {
                                        oldSub = schedList.get(i).getCourse();
                                        newSub = newSub2;
//                                                modifyFile("infos.txt", infoList.get(i).getfName(), newfName);
                                        schedList.get(i).setCourse(newSub);
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
                                        oldUnit = schedList.get(i).getUnits();
                                        newUnit = newUnit2;
//                                                modifyFile("infos.txt", infoList.get(i).getfName(), newfName);
                                        schedList.get(i).setUnits(Integer.parseInt(newUnit));
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
                                            oldSched = schedList.get(i).getSched();
                                            newSched = newSched2;
//                                                modifyFile("infos.txt", infoList.get(i).getfName(), newfName);
                                            schedList.get(i).setSched(newSched);
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
                    System.out.println("Delete by:\n1. Personal Information\n3. Schedule\n:");
                    String choice4 = scan.nextLine();
                    if (choice4.equals("1")) {
                        displayInfo();
                        System.out.println("Delete personal information by ID: ");
                        String delInfo = scan.nextLine();
                        for (int i = 0; i < infoList.size(); i++) {
                            if (infoList.get(i).getId() == Integer.parseInt(delInfo)) {
                                infoList.remove(i);
                            }
                        }
                    } else if (choice4.equals("2")) {
                        displaySched();
                        System.out.println("Delete schedule by ID: ");
                        String delSched = scan.nextLine();
                        for (int i = 0; i < schedList.size(); i++) {
                            if (schedList.get(i).getId() == Integer.parseInt(delSched)) {
                                schedList.remove(i);
                                
                                delInfo = schedList.get(i).toString();
                                break;
                            }
                            
                        }
                    }
                    break;

                case "5":

                    break;
                case "6":
                    modifyFile("infos.txt", oldName, newName);
                    modifyFile("infos.txt", oldName2, newName2);
                    modifyFile("infos.txt", oldNum, newNum2);
                    modifyFile("schedule.txt", oldSub, newSub);
                    modifyFile("schedule.txt", Integer.toString(oldUnit), newUnit);
                    modifyFile("schedule.txt", oldSched, newSched);
                    saving();
                    del("schedule.txt");
                    System.out.println("Updated Successfully");
                    break;

            }
        }
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

    public void del(String choices) throws FileNotFoundException, IOException {
        String delChoice = choices;
        File inputFile = new File(delChoice);
        File tempFile = new File("myTempFile.txt");

        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
        //STOPPED HERE FOR UPDATING THE FILE UPON DELETING SOMETHING FROM ARRAYLIST
        String lineToRemove = delInfo;
        String currentLine;

        while ((currentLine = reader.readLine()) != null) {
            // trim newline when comparing with lineToRemove
            String trimmedLine = currentLine.trim();
            if (trimmedLine.equals(lineToRemove)) {
                continue;
            }
            writer.write(currentLine + System.getProperty("line.separator"));
        }
        writer.close();
        reader.close();
        boolean successful = tempFile.renameTo(inputFile);
    }

    static void modifyFile(String filePath, String oldString, String newString) {
        File fileToBeModified = new File(filePath);
        String oldContent = "";
        BufferedReader reader = null;
        FileWriter writer = null;
        try {
            reader = new BufferedReader(new FileReader(fileToBeModified));
            //Reading all the lines of input text file into oldContent
            String line = reader.readLine();
            while (line != null) {
                oldContent = oldContent + line + System.lineSeparator();
                line = reader.readLine();
            }
            //Replacing oldString with newString in the oldContent
            String newContent = oldContent.replaceAll(oldString, newString);
            //Rewriting the input text file with newContent
            writer = new FileWriter(fileToBeModified);
            writer.write(newContent);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //Closing the resources
                reader.close();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
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

                        writer.println(ids + "\t" + account.getId() + "\t" + schedObj.getCourse() + "\t" + schedObj.getUnits() + "\t" + schedObj.getSched() + "\n");
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
            int ids = 1;
            while (line != null) {
                if (line.length() != 0) {
                    ids++;
                }
                line = reader.readLine();
            }
            account.setId(ids);
            writer.println(ids + "\t" + account.getUsername() + "\t" + account.getPass() + "\t" + "\n");
//            Accounts objt = new Accounts(ids, account.getUsername(), account.getPass());
            writer.close();
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
//            info.setId(ids);
            writer.println(ids + "\t" + account.getId() + "\t" + info.getfName() + "\t" + info.getlName() + "\t" + info.getNum() + "\t" + "\n");
//            Infos objt = new Infos(ids, account.getId(), info.getfName(), info.getlName(), info.getNum());
            writer.close();

//            infoList.add(objt);
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
        schedSuc2 = 0;
        courseSuc = 0;
        courseSuc2 = 0;
        unitSuc2 = 0;
    }
}
