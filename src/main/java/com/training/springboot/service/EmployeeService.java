package com.training.springboot.service;

import com.sun.istack.NotNull;
import com.training.springboot.exception.ResourceNotFoundException;
import com.training.springboot.model.Employee;
import com.training.springboot.repository.EmployeeRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }


    public Employee createEmployee(@NotNull Employee employee) {
        return employeeRepository.save(employee);
    }


    public Employee getEmployeeById(@NotNull Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));

    }


    public Employee updateEmployee(@NotNull Long id, @NotNull Employee employeeDetails) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));

        employee.setFirstName(employeeDetails.getFirstName());
        employee.setLastName(employeeDetails.getLastName());
        employee.setEmailId(employeeDetails.getEmailId());

        return employeeRepository.save(employee);
    }

    public void deleteEmployee(@NotNull Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));

        employeeRepository.delete(employee);
    }

    public List<Employee> getEmployeesByFirstName(String firstName) {
        return employeeRepository.findByLastName(firstName);
    }
}
