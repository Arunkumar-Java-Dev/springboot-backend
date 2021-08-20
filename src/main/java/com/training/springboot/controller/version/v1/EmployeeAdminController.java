package com.training.springboot.controller.version.v1;

import com.training.springboot.model.Employee;
import com.training.springboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/version/v1")
public class EmployeeAdminController {

    @Autowired
    private EmployeeService employeeService;

    // get all employees
    @GetMapping("/employees/{firstName}")
    public List<Employee> getEmployeesByFirstName(@PathVariable String firstName) {
        return employeeService.getEmployeesByFirstName(firstName);
    }

}
