package com.learning.tomcat.controller;

import com.learning.tomcat.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping("/employees")
    public String getDepartments() {
        log.info("Getting All Employees from Controller");
        return employeeService.getEmployees();
    }
}
