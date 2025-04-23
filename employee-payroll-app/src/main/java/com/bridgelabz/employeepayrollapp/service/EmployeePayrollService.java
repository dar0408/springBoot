package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;
import com.bridgelabz.employeepayrollapp.repository.EmployeePayrollRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeePayrollService implements IEmployeePayrollService {

    private final EmployeePayrollRepository repository;

    @Override
    public List<EmployeePayrollData> getEmployeePayrollData() {
        return repository.findAll();
    }

    @Override
    public EmployeePayrollData getEmployeePayrollDataById(int empId) {
        return repository.findById(empId).orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    @Override
    public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO dto) {
        EmployeePayrollData data = new EmployeePayrollData(dto);
        return repository.save(data);
    }

    @Override
    public EmployeePayrollData updateEmployeePayrollData(int empId, EmployeePayrollDTO dto) {
        EmployeePayrollData existing = getEmployeePayrollDataById(empId);
        existing.update(dto);
        return repository.save(existing);
    }

    @Override
    public void deleteEmployeePayrollData(int empId) {
        repository.deleteById(empId);
    }

    @Override
    public List<EmployeePayrollData> getEmployeesByDepartment(String department) {
        return repository.findEmployeesByDepartment(department);
    }
}
