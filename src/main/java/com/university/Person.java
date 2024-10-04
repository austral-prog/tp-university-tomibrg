package com.university;

public class Person {
    private String name;
    private String mail;
    
    public Person(String name, String mail){
        this.name = name;
        this.mail = mail;
    }


    public String getName() {
        return this.name;
    }


    public String getMail() {
        return this.mail;
    }
}

