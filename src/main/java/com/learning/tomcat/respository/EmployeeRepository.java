package com.learning.tomcat.respository;

import com.learning.tomcat.domain.Employee;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Slf4j
@Repository
public class EmployeeRepository {

    private final NamedParameterJdbcTemplate employeeJdbcTemplate;

    public String getEmployees() {
        List<Employee> employeeList = employeeJdbcTemplate.query("SELECT * FROM employee", BeanPropertyRowMapper.newInstance(Employee.class));
        List<String> employeeNames = employeeList.stream().map(Employee::getName).collect(Collectors.toList());
        log.info("Employee Size: {}", employeeNames.size());
        return String.join(",  ", employeeNames);
    }

}
