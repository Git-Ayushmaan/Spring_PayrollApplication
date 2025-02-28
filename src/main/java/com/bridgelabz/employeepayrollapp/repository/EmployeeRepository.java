package com.bridgelabz.employeepayrollapp.repository;

import com.bridgelabz.employeepayrollapp.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // UC6: Custom query to retrieve employees by department
    @Query("SELECT e FROM Employee e WHERE :dept MEMBER OF e.department")
    List<Employee> findEmployeesByDepartment(String dept);
}
