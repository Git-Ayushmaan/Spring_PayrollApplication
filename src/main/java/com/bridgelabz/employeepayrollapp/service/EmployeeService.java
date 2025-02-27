package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.exception.EmployeeNotFoundException;
import com.bridgelabz.employeepayrollapp.model.Employee;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class EmployeeService {

    // In-memory list to store employees
    private final List<Employee> employeeList = new ArrayList<>();
    // Atomic counter to simulate auto-generated IDs
    private final AtomicLong idCounter = new AtomicLong();

    public List<Employee> getAllEmployees() {
        return employeeList;
    }

    public Employee getEmployeeById(Long id) {
        return employeeList.stream()
                .filter(emp -> emp.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found with id: " + id));
    }


    public Employee createEmployee(Employee employee) {
        // Simulate ID generation
        employee.setId(idCounter.incrementAndGet());
        employeeList.add(employee);
        return employee;
    }

    public Employee updateEmployee(Long id, Employee employeeDetails) {
        Employee employee = getEmployeeById(id);
        if (employee != null) {
            employee.setName(employeeDetails.getName());
            employee.setSalary(employeeDetails.getSalary());
        }
        return employee;
    }

    public void deleteEmployee(Long id) {
        employeeList.removeIf(emp -> emp.getId().equals(id));
    }
}
