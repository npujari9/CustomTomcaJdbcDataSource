package com.learning.tomcat.service;

import com.learning.tomcat.respository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
@Slf4j
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public String getEmployees() {
        log.info("Getting Employees from service");
        return "Employees :: " + employeeRepository.getEmployees();
    }

}
