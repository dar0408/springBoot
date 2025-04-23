package com.bridgelabz.employeepayrollapp.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@Data
@ToString
public class EmployeePayrollDTO {
    @NotBlank(message = "Employee name is required")
    private String name;

    @Pattern(regexp = "male|female", message = "Gender must be male or female")
    private String gender;

    @NotNull(message = "Department cannot be empty")
    private List<String> department;

    @Min(value = 500, message = "Minimum salary must be 500")
    private long salary;

    @JsonFormat(pattern = "dd MMM yyyy")
    @NotNull(message = "Start date is required")
    @PastOrPresent(message = "Start date must be past or present")
    private LocalDate startDate;

    @NotBlank(message = "Note is required")
    private String note;

    @NotBlank(message = "Profile picture path is required")
    private String profilePic;
}
