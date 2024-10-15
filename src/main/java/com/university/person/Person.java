package com.university.person;

public class Person {
    private String name;

    
    public Person(String name){
        this.name = name;

    }


    public String getName() {
        return this.name;
    }

    public boolean equals(Person person) {
        boolean returnStatement = false;
        if (person.getName().equals(this.getName())){
            returnStatement = true;
        }
        return returnStatement;
    }
}

