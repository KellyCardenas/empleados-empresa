package com.empresa.empleados.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Employee {

    private String employeeId;

    private String name;

    private String lastName;

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date birthDate;

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date bindindDate;

    private String position;

    private Double salary;

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Date getBindindDate() {
        return bindindDate;
    }

    public void setBindindDate(Date bindindDate) {
        this.bindindDate = bindindDate;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
}
