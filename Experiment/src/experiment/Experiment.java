/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package experiment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 *
 * @author tanilonch_sd2023
 */
public class Experiment {

    Scanner myObj = new Scanner(System.in);
    ArrayList<Student> student = new ArrayList();
    HashSet<String> tStudent = new HashSet();

    PriorityQueue<Student> reverse = new PriorityQueue<>(10, Collections.reverseOrder());

    Comparator<Student> nameSorter = Comparator.comparing(Student::getName);
    PriorityQueue<Student> pqStudent = new PriorityQueue<>(nameSorter);

//    private String name;
//    private int id;
//    private String courseTaken;
    public Experiment() {

    }

    public void displayMenu() {
        System.out.print("MENU\n1. List\n2. Queue\n3. Set\nEnter option: ");
        int option = myObj.nextInt();  // Read user input
        switch (option) {
            case 1:
                selectList();
                break;
            case 2:
                selectQueue();
                break;
            case 3:
                selectSet();
                break;
            default:
                System.out.println("Select only 1-3 option\n");
                break;
        }

    }

    public void selectList() {

        Scanner input2 = new Scanner(System.in);
        System.out.print("\nYOU SELECTED LIST MODE\nSELECT ACTIONS TO PERFORM\n1. Create\n2. Retrieve\n3. Update\n4. Delete\n5. Exit\nEnter option: ");
        int option = myObj.nextInt();
        switch (option) {
            case 1: //add student
                Student ind = new Student();
                Scanner input = new Scanner(System.in);
                System.out.println("ADD STUDENT\nName of student: ");
                String name = input.nextLine();
                ind.setName(name);
                System.out.println("ID Number: ");
                Scanner inputid = new Scanner(System.in);
                int id = inputid.nextInt();
                
                ind.setId(id);
                System.out.println("Course Taken: ");
                Scanner inputct = new Scanner(System.in);
                String ct = inputct.nextLine();
                ind.setCourseTaken(ct);
                student.add(ind);
                System.out.println("STUDENT ADDED SUCCESSFULLY!\n");
                selectList();
                break;
            case 2: //remove student
                System.out.println("ID                            |NAME                          |COURSE TAKEN");
                Iterator itr2 = student.iterator();
                while (itr2.hasNext()) {
                    System.out.println(itr2.next());
                }
                selectList();
                break;
            case 3: //update students
                System.out.println("TYPE THE ID NUMBER OF STUDENT YOU WANT TO UPDATE:");
                Scanner selStudent = new Scanner(System.in);
                int select = selStudent.nextInt();
                for (int i = 0; i < student.size(); ++i) {
                    if (student.get(i).getId() == select) {
                        System.out.println("You are updating student named " + student.get(i).getName());
                        System.out.println("Enter new name:");
                        Scanner nName = new Scanner(System.in);
                        String upName = nName.nextLine();
                        student.get(i).setName(upName);

                        System.out.println("Enter new Course taken");
                        Scanner nCt = new Scanner(System.in);
                        String upCt = nCt.nextLine();
                        student.get(i).setCourseTaken(upCt);
                    } else {
//                        System.out.println("ID Number does not exists!");
                    }
                }
                System.out.println("STUDENT UPDATED SUCCESSFULLY\n");
                selectList();
                break;
            case 4:
                System.out.println("DELETE STUDENT\nName of student: ");
                String remove = input2.nextLine();
                for (int i = 0; i < student.size(); ++i) {
                    if (student.get(i).getName().equals(remove)) {
                        student.remove(i);
                        System.out.println("STUDENT DELETED SUCCESSFULLY!\n");
                    }
                }
                selectList();
                break;
            case 5:
                displayMenu();
                break;
            default:
                System.out.println("Select only 1-5 option\n");
                break;
        }
    }

    public void selectQueue() {
        System.out.print("\nYOU SELECTED QUEUE MODE\nSELECT ACTIONS TO PERFORM\n1. Create\n2. Retrieve\n3. Update\n4. Delete\n5. Exit\nEnter option: ");
        int option = myObj.nextInt();
        switch (option) {
            case 1: //add student
                Student stu = new Student();
                Scanner input = new Scanner(System.in);
                System.out.println("ADD STUDENT\nName of student: ");
                String name = input.nextLine();
                stu.setName(name);

                System.out.println("ID Number: ");
                Scanner inputid = new Scanner(System.in);
                int id = inputid.nextInt();
                stu.setId(id);

                System.out.println("Course Taken: ");
                Scanner inputct = new Scanner(System.in);
                String course = inputct.nextLine();
                stu.setCourseTaken(course);

                pqStudent.add(stu);
                System.out.println("STUDENT ADDED SUCCESSFULLY!\n");
                selectQueue();
                break;

            case 2: //retrieve student
                System.out.println("ID                            |NAME                          |COURSE TAKEN");
                Iterator itr = pqStudent.iterator();
                while (itr.hasNext()) {
                    System.out.println(itr.next());
                }
//                System.out.println("no");
                selectQueue();
                break;
            case 3: //update students
                //UNFINISHED BUSINESS HERE!!
                
                System.out.println("MY UPDATE IN QUEUE WONT WORK :( ITS HARD IN OBJECT\n");
                selectQueue();
                break;
            case 4: //display students
                System.out.println("THE FIRST STUDENT IS REMOVED\n");
                pqStudent.poll();
                selectQueue();
                break;
            case 5:
                displayMenu();
                break;
            default:
                System.out.println("Select only 1-5 option\n");
                break;
        }
    }

    public void selectSet() {
        Scanner input2 = new Scanner(System.in);
        System.out.print("\nYOU SELECTED SET MODE\nSELECT ACTIONS TO PERFORM\n1. Create\n2. Retrieve\n3. Update\n4. Delete\n5. Exit\nEnter option: ");
        int option = myObj.nextInt();
        
        switch (option) {
            case 1: //add student
                Student stud = new Student();
                Scanner input = new Scanner(System.in);
                System.out.println("ADD STUDENT\nName of student: ");
                String name = input.nextLine();
                stud.setName(name);

                tStudent.add( name);
                System.out.println("STUDENT ADDED SUCCESSFULLY!\n");
          
                selectSet();
                break;
            case 2: //remove student
                System.out.println("STUDENT NAME:");
                Iterator itr2 = tStudent.iterator();
                while (itr2.hasNext()) {
                    System.out.println(itr2.next());
                }
                selectSet();
                break;
            case 3: //update students
                System.out.println("TYPE THE THE NAME OF STUDENT:");
                Scanner selStudent = new Scanner(System.in);
                String select = selStudent.nextLine();
                tStudent.remove(select);
                
                System.out.println("TYPE NEW NAME OF STUDENT:");
                Scanner neww = new Scanner(System.in);
                String newwa = neww.nextLine();
                tStudent.add(newwa);
                System.out.println("STUDENT UPDATED SUCCESSFULLY!\n");
                selectSet();
                break;
            case 4: //display students

                System.out.println("DELETE STUDENT\nName of student: ");
                String remove = input2.nextLine();
                tStudent.remove(remove);
                System.out.println("STUDENT REMOVE SUCCESSFULLY\n");
                selectSet();
                break;
            case 5:
                displayMenu();
                break;
            default:
                System.out.println("Select only 1-5 option\n");
                break;
        }
    }

}
