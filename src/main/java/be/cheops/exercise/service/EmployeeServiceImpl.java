package be.cheops.exercise.service;

import be.cheops.exercise.dao.EmployeeDao;
import be.cheops.exercise.domain.Employee;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeDao employeeDao;
    private final Logger logger;

    public EmployeeServiceImpl(EmployeeDao employeeDao, Logger logger) {
        this.employeeDao = employeeDao;
        this.logger = logger;
    }

    @Override
    public List<Employee> findEmployeesWithLastNameEndingOn_S(List<Employee> employees) {
        // TODO: Implement using Streaming API
        return employees;
    }

    @Override
    public List<Employee> findEmployeesWorkingLessThan4YearsSortedByLastAndFirstNameAscending(
            List<Employee> employees) {
        // TODO: Implement using Streaming API
        return employees;

    }

}
