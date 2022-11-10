/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;
import java.io.Serializable;
/**
 *
 * @author Patrick
 */
public class User implements Serializable {
    private String email;
    private String fName;
    private String lName;
    private String password;
    private int role;

    public User(){}
    
    public User(String email, String fName, String lName, String password, int role) {
        this.email = email;
        this.fName = fName;
        this.lName = lName;
        this.password = password;
        this.role = role;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }

    public String getPassword() {
        return password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    
    
    
}
