package com.second.houserent.domain;

public class House {
    private int id;
    private String name;
    private String phone;
    private String ads;
    private int salary;
    private String state;

    public House(int id, String name, String phone, String ads, int salary, String state) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.ads = ads;
        this.salary = salary;
        this.state = state;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAds() {
        return ads;
    }

    public void setAds(String ads) {
        this.ads = ads;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return
                 id +"\t\t"+
                 name +"\t\t"+
                 phone +"\t\t"+
                 ads +"\t\t"+
                 salary +"\t\t"+
                 state ;
    }
}

