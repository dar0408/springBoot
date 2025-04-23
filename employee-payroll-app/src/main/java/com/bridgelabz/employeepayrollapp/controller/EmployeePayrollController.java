package com.bridgelabz.employeepayrollapp.controller;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;
import com.bridgelabz.employeepayrollapp.service.IEmployeePayrollService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/employeeData")
@RequiredArgsConstructor
@Slf4j
public class EmployeePayrollController {

    private final IEmployeePayrollService service;

    @GetMapping("/")
    public List<EmployeePayrollData> getAllEmployees() {
        return service.getEmployeePayrollData();
    }

    @GetMapping("/get/{id}")
    public EmployeePayrollData getEmployee(@PathVariable int id) {
        return service.getEmployeePayrollDataById(id);
    }

    @PostMapping("/create")
    public EmployeePayrollData create(@Valid @RequestBody EmployeePayrollDTO dto) {
        return service.createEmployeePayrollData(dto);
    }

    @PutMapping("/update/{id}")
    public EmployeePayrollData update(@PathVariable int id, @Valid @RequestBody EmployeePayrollDTO dto) {
        return service.updateEmployeePayrollData(id, dto);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        service.deleteEmployeePayrollData(id);
        return "Deleted employee with ID: " + id;
    }

    @GetMapping("/department/{department}")
    public List<EmployeePayrollData> getByDepartment(@PathVariable String department) {
        return service.getEmployeesByDepartment(department);
    }
}
