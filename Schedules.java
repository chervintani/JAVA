/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enrollcherv;

/**
 *
 * @author 2ndyrGroupB
 */
public class Schedules {
//    private int id = 0;

    private String course = "";
    private int units = 0;
    private String sched = "";
    private int id = 0;
    private int accId = 0;

    public Schedules() {
    }

    public Schedules(int id, int accId, String course, int units, String sched) {
        this.id = id;
        this.accId = accId;
        this.course = course;
        this.units = units;
        this.sched = sched;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getUnits() {
        return units;
    }

    public void setUnits(int units) {
        this.units = units;
    }

    public String getSched() {
        return sched;
    }

    public void setSched(String sched) {
        this.sched = sched;
    }

    public int getAccId() {
        return accId;
    }

    public void setAccId(int accId) {
        this.accId = accId;
    }
    
    public String toString() {
        return String.format("%-10s%-18s%-20s%-20s%-20s", id, accId, course, units, sched);
    }
}
