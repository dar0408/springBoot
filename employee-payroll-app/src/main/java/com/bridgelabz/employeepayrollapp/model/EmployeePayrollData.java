package com.bridgelabz.employeepayrollapp.model;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "employee_payroll")
@Data
@NoArgsConstructor
public class EmployeePayrollData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String gender;
    private long salary;
    private LocalDate startDate;
    private String note;
    private String profilePic;

    @ElementCollection
    @CollectionTable(name = "employee_department", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "department")
    private List<String> department;

    public EmployeePayrollData(EmployeePayrollDTO dto) {
        this.name = dto.getName();
        this.gender = dto.getGender();
        this.salary = dto.getSalary();
        this.startDate = dto.getStartDate();
        this.note = dto.getNote();
        this.profilePic = dto.getProfilePic();
        this.department = dto.getDepartment();
    }

    public void update(EmployeePayrollDTO dto) {
        this.name = dto.getName();
        this.gender = dto.getGender();
        this.salary = dto.getSalary();
        this.startDate = dto.getStartDate();
        this.note = dto.getNote();
        this.profilePic = dto.getProfilePic();
        this.department = dto.getDepartment();
    }
}
