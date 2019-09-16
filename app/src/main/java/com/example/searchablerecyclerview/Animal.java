package com.example.searchablerecyclerview;

public class Animal {
    String name;
    String location;
    String img;

    public Animal() {
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getImage() {
        return "http://192.168.74.212/"+img;
    }
}
