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
public class PersonalInfo {

    private int id = 0;
    private int accId = 0;
    private String fName = "";
    private String lName = "";
    private int age = 0;

    public PersonalInfo() {
    }
    
    public PersonalInfo(int id, int accId, String fName, String lName, int age){
        this.id = id;
        this.accId = accId;
        this.fName = fName;
        this.lName = lName;
        this.age = age;
    }
    
    public int getId() {
        return id;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString(){
        return String.format("%s\t%s\t%d",fName,lName,age);
    }
}
