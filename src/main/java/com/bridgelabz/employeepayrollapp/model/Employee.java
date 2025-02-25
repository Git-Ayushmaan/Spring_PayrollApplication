package com.bridgelabz.employeepayrollapp.model;

import jakarta.persistence.*;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double salary;

    public Employee() {}

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public double getSalary() { return salary; }
}
