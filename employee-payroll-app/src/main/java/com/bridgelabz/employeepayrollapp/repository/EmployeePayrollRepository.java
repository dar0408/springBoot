package com.bridgelabz.employeepayrollapp.repository;



import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeePayrollRepository extends JpaRepository<EmployeePayrollData, Integer> {
    @Query(value = "SELECT * FROM employee_payroll e JOIN employee_department d ON e.id = d.id WHERE d.department = ?1", nativeQuery = true)
    List<EmployeePayrollData> findEmployeesByDepartment(String department);
}
