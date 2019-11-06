package com.friendlyp;

public class PublicPerson {
    private String name;
    private int id;

    public PublicPerson() {
        this.name = "";
    }

    public PublicPerson(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void printName(){
        System.out.print(name);
    }

    public void setId(int id) {
        this.id = id;
    }


}
