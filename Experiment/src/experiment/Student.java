/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package experiment;

import java.util.Comparator;

/**
 *
 * @author tanilonch_sd2023
 */
public class Student implements Comparator<Student> {

    private String name;
    private int id;

    public Student() {
    }
    private String courseTaken;

    public Student(String name, int id, String courseTaken) {
        this.name = name;
        this.id = id;
        this.courseTaken = courseTaken;
    }

    public Student(int id) {
        this.id = id;
    }

   
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourseTaken() {
        return courseTaken;
    }

    public void setCourseTaken(String courseTaken) {
        this.courseTaken = courseTaken;
    }

    public int compareTo(Employee emp) {
//        return this.getId().compareTo(emp.getId());
        if (emp.getId() == this.getId()) {

        }
        return this.getId();
    }

    @Override
    public String toString() {
        return String.format("%-30d|%-30s|%-30s", this.id, this.name, this.courseTaken);
    }

    @Override
    public int compare(Student o1, Student o2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
