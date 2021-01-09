package com.example.audit.controller;

import com.example.audit.dto.InputRequest;
import com.example.audit.model.Employee;
import com.example.audit.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/addEmployee")
    public String saveEmployee(@RequestBody InputRequest<Employee> request) {
        return employeeService.saveEmployee(request);
    }

    @PutMapping("/updateEmployee/{id}/{salary}")
    public String updateEmployee(@PathVariable int id, @PathVariable double salary,
                                 @RequestBody InputRequest<Employee> request) {
        return employeeService.updateEmployee(id, salary, request);
    }
}
