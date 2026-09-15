package com.payroll;

import java.time.LocalDate;

public class Employee {

    private int id;
    private String name;
    private String email;
    private String phone;
    private LocalDate joiningDate;
    private int department_id;

    public Employee(String name, String email, String phone,
                    LocalDate joiningDate, int departmentId) {

        this.name = name;
        this.email = email;
        this.phone = phone;
        this.joiningDate = joiningDate;
        this.department_id = departmentId;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDate getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(LocalDate joiningDate) {
        this.joiningDate = joiningDate;
    }

    public int getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }
}