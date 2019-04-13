package com.example.assignment3.models;

public class contact {
    String Number;
    String email_id ;
    String Name ;

    public contact(String number, String email_id, String Name){
        this.email_id = email_id;
        this.Name  = Name;
        this.Number = number ;
    }
    public contact(){

    }

    public String getNumber() {
        return Number;
    }

    public void setNumber(String number) {
        Number = number;
    }

    public String getEmail_id() {
        return email_id;
    }

    public void setEmail_id(String email_id) {
        this.email_id = email_id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}