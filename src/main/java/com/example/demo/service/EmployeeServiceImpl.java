package com.example.demo.service;


import com.example.demo.dto.EmployeeDTO;
import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public EmployeeDTO addEmployee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        employee.setName(employeeDTO.getName());
        employee.setPosition(employeeDTO.getPosition());
        employee.setSalary(employeeDTO.getSalary());
        employeeRepository.save(employee);
        return employeeDTO;
    }

    @Override
    public EmployeeDTO getEmployee(Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow();
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId(employee.getId());
        employeeDTO.setName(employee.getName());
        employeeDTO.setPosition(employee.getPosition());
        employeeDTO.setSalary(employee.getSalary());
        return employeeDTO;
    }

    @Override
    public EmployeeDTO updateEmployee(Long id, EmployeeDTO employeeDTO) {
        Employee employee = employeeRepository.findById(id).orElseThrow();
        employee.setName(employeeDTO.getName());
        employee.setPosition(employeeDTO.getPosition());
        employee.setSalary(employeeDTO.getSalary());
        employeeRepository.save(employee);
        return employeeDTO;
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        return employeeRepository.findAll().stream()
                .map(employee -> {
                    EmployeeDTO employeeDTO = new EmployeeDTO();
                    employeeDTO.setId(employee.getId());
                    employeeDTO.setName(employee.getName());
                    employeeDTO.setPosition(employee.getPosition());
                    employeeDTO.setSalary(employee.getSalary());
                    return employeeDTO;
                }).collect(Collectors.toList());
    }
}