package com.example.demo.service;

import com.example.demo.dto.EmployeeDTO;
import java.util.List;

public interface EmployeeService {
    EmployeeDTO addEmployee(EmployeeDTO employeeDTO);
    EmployeeDTO getEmployee(Long id);
    EmployeeDTO updateEmployee(Long id, EmployeeDTO employeeDTO);
    List<EmployeeDTO> getAllEmployees();
}