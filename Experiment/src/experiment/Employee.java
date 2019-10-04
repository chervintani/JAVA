/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package experiment;

import java.time.LocalDate;

/**
 *
 * @author tanilonch_sd2023
 */
public class Employee implements Comparable<Employee> {
 
    private int id;
    private String name;
    private LocalDate dob;
 
    public Employee(){
    }
    
    public Employee(int id, String name, LocalDate dob) {
        super();
        this.id = id;
        this.name = name;
        this.dob = dob;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }
     
    
//    
//    @Override
//    public int compareTo(Employee emp) {
////        return this.getId().compareTo(emp.getId());
//        if(emp.getId()==this.getId()){
//        
//        }
//        return this.getId();
//    }
 
    //Getters and setters
 
    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", dob=" + dob + "]";
    }

    @Override
    public int compareTo(Employee o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}