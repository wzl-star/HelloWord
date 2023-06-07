package com.mhl.domain;

public class Employee {
    private Integer id;
    private String empId;
    private String pwd;
    private String NAME;
    private String job;

    public Employee() {
    }

    public Employee(Integer id, String empId, String pwd, String NAME, String job) {
        this.id = id;
        this.empId = empId;
        this.pwd = pwd;
        this.NAME = NAME;
        this.job = job;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }
}
