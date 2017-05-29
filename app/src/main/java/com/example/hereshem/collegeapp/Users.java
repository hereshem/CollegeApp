package com.example.hereshem.collegeapp;

/**
 * Created by hereshem on 2/12/17.
 */

public class Users {

    int id;
    String name, pass, email, address, phone;

    @Override
    public String toString(){
        return name + " " + email;
    }

    public Users(String name, String pass, String email, String address, String phone) {
        this.name = name;
        this.pass = pass;
        this.email = email;
        this.address = address;
        this.phone = phone;
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

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
