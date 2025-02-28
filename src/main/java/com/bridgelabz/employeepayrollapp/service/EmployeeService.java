package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.exception.EmployeeNotFoundException;
import com.bridgelabz.employeepayrollapp.model.Employee;
import com.bridgelabz.employeepayrollapp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    // Retrieve all employees from the MySQL database
    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    // Retrieve a specific employee by ID; throw an exception if not found
    public Employee getEmployeeById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found with id: " + id));
    }

    // Create a new employee and persist to the database
    public Employee createEmployee(Employee employee) {
        return repository.save(employee);
    }

    // Update an existing employee; if not found, an exception is thrown
    public Employee updateEmployee(Long id, Employee employeeDetails) {
        Employee employee = getEmployeeById(id);
        employee.setName(employeeDetails.getName());
        employee.setGender(employeeDetails.getGender());
        employee.setSalary(employeeDetails.getSalary());
        employee.setStartDate(employeeDetails.getStartDate());
        employee.setNote(employeeDetails.getNote());
        employee.setProfilePic(employeeDetails.getProfilePic());
        employee.setDepartment(employeeDetails.getDepartment());
        return repository.save(employee);
    }

    // Delete an employee after ensuring they exist in the database
    public void deleteEmployee(Long id) {
        Employee employee = getEmployeeById(id);
        repository.delete(employee);
    }
}
