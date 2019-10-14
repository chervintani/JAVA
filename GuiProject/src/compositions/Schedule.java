/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compositions;

/**
 *
 * @author 2ndyrGroupC
 */
public class Schedule {

    private int id;
    private int accId;
    private String subject;
    private int units;
    private String schedule;

    public Schedule() {
    }

    public Schedule(int id, int accId, String subject, int units, String schedule) {
        this.id = id;
        this.accId = accId;
        this.subject = subject;
        this.units = units;
        this.schedule = schedule;
    }

    public int getId() {
        return id;
    }

    public void setAll(int accId, String subject, int units, String schedule) {
        this.accId = accId;
        this.units = units;
        this.schedule = schedule;
        this.subject = subject;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAccId() {
        return accId;
    }

    public void setAccId(int accId) {
        this.accId = accId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getUnits() {
        return units;
    }

    public void setUnits(int units) {
        this.units = units;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

}
