package com.bridgelabz.employeepayrollapp.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.ToString;
import java.time.LocalDate;
import java.util.List;

@Data
@ToString
@Entity
@Table(name = "employee_payroll")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Name validations (as defined in UC1)
    @NotEmpty(message = "Name must not be empty")
    @Pattern(regexp = "^[A-Z][a-zA-Z ]*$",
            message = "Name must start with a capital letter and contain only letters and spaces")
    private String name;

    // Gender must be either male or female
    @NotEmpty(message = "Gender is required")
    @Pattern(regexp = "male|female", flags = Pattern.Flag.CASE_INSENSITIVE,
            message = "Gender must be either male or female")
    private String gender;

    @NotNull(message = "Salary is required")
    private double salary;

    // Start Date: Not null, formatted as "dd MMM yyyy" and must be past or present
    @NotNull(message = "Start date is required")
    @PastOrPresent(message = "Start date must be in the past or present")
    @JsonFormat(pattern = "dd MMM yyyy")
    private LocalDate startDate;

    // Note and profilePic: Must not be blank
    @NotBlank(message = "Note must not be blank")
    private String note;

    @NotBlank(message = "Profile picture must not be blank")
    private String profilePic;

    // Department: A list of departments (each value must not be blank)
    @NotNull(message = "Department is required")
    @ElementCollection
    @CollectionTable(name = "employee_department", joinColumns = @JoinColumn(name = "employee_id"))
    @Column(name = "department")
    private List<@NotBlank(message = "Department must not be blank") String> department;
}
