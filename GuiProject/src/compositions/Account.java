/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compositions;

import java.util.ArrayList;

/**
 *
 * @author 2ndyrGroupC
 */
public class Account {

    private int id = 0;
    private String username = "";
    private String password = "";
    private PersonalInfo info;
    private ArrayList<Schedule> schedules;

    public Account() {
    }

    public Account(int id, String username, String password, PersonalInfo info, ArrayList<Schedule> schedules) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.info = info;
        this.schedules = schedules;
    }

    public Account(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public PersonalInfo getInfo() {
        return info;
    }

    public void setInfo(PersonalInfo info) {
        this.info = info;
    }

    public ArrayList<Schedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(ArrayList<Schedule> schedules) {
        this.schedules = schedules;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
