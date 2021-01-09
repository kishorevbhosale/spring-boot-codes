package com.example.audit.service;

import com.example.audit.dao.EmployeeRepo;
import com.example.audit.dto.InputRequest;
import com.example.audit.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    public String saveEmployee(InputRequest<Employee> request) {
        String currentUser = request.getLoggedInUser();
        request.setTimeZone(Calendar.getInstance().getTimeZone().getDisplayName());

        Employee employee = request.getEmployee();
        employee.setCreatedBy(currentUser);
        employeeRepo.save(employee);
        return "Employee saved Successfully";
    }

    public String updateEmployee(int id, double salary, InputRequest<Employee> request) {
        Employee employee = employeeRepo.findById(id).get();
        if (employee != null) {
            employee.setSalary(salary);
            employee.setModifiedBy(request.getLoggedInUser());
            employeeRepo.saveAndFlush(employee);
        } else {
            throw new RuntimeException("Employee not found with id : " + id);
        }
        return "Employee updated successfully!!!";

    }
}
