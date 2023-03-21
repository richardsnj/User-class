/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vaccinationsystem;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Brian
 */
public class User {

    private String Username;
    private String Password;
    private String FullName;
    private String ICPassport;
    private String PhoneNumber;
    private String Email;
    private String Type;
    private String DOB;


    //Get Set
    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String FullName) {
        this.FullName = FullName;
    }

    public String getICPassport() {
        return ICPassport;
    }

    public void setICPassport(String ICPassport) {
        this.ICPassport = ICPassport;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    //Constructor for register
    User(String Username, String Password, String FullName, String ICPassport, String PhoneNum, String Email, String Type, String DOB) {
        this.Username = Username;
        this.Password = Password;
        this.FullName = FullName;
        this.ICPassport = ICPassport;
        this.PhoneNumber = PhoneNum;
        this.Email = Email;
        this.Type = Type;
        this.DOB = DOB;
    }

    //Constructor for Login
    public User(String Username, String Password) {
        this.Username = Username;
        this.Password = Password;
    }

    User() {

    }

    //Register Method
    public void register() {

        File file = new File("People.txt");
        try {
            PrintWriter regis = new PrintWriter(new BufferedWriter(new FileWriter("People.txt", true)));
            regis.append(Username + "," + Password + "," + FullName + "," + ICPassport + "," + PhoneNumber + "," + Email + "," + Type + "," + DOB + "\n");
            regis.close();

            JOptionPane.showMessageDialog(null, "Success");
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

    }

    //Login Method
    public boolean login(String name) {
        try {
            FileReader fr = new FileReader("People.txt");
            Scanner sc = new Scanner(fr);    //file to be scanned 
            String Temp;
            String[] Temp2;
            //returns true if there is another line to read  
            while (sc.hasNextLine()) {
                Temp = sc.nextLine();
                Temp2 = Temp.split(",");

                if (Temp2[0].equals(Username) && Temp2[1].equals(Password)) {
                    return true;
                }
            }
            sc.close();

        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Wrong Credential");
        }
        return false;
    }

}
