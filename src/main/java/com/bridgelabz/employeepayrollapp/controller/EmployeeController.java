package com.bridgelabz.employeepayrollapp.controller;

import com.bridgelabz.employeepayrollapp.model.Employee;
import com.bridgelabz.employeepayrollapp.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    // GET: Retrieve all employee records
    @GetMapping("/")
    public List<Employee> getAllEmployees() {
        log.info("Fetching all employees");
        return service.getAllEmployees();
    }

    // GET: Retrieve a specific employee by ID
    @GetMapping("/get/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
        log.info("Fetching employee with id: {}", id);
        return service.getEmployeeById(id);
    }

    // POST: Create a new employee record
    @PostMapping("/create")
    public Employee createEmployee(@Valid @RequestBody Employee employee) {
        log.info("Creating new employee: {}", employee);
        return service.createEmployee(employee);
    }

    // PUT: Update an existing employee record
    @PutMapping("/update/{id}")
    public Employee updateEmployee(@PathVariable Long id, @Valid @RequestBody Employee employee) {
        log.info("Updating employee with id: {}", id);
        return service.updateEmployee(id, employee);
    }

    // DELETE: Remove an employee record by ID
    @DeleteMapping("/delete/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        log.info("Deleting employee with id: {}", id);
        service.deleteEmployee(id);
    }
}
