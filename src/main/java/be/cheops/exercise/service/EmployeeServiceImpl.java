package be.cheops.exercise.service;

import be.cheops.exercise.dao.EmployeeDao;
import be.cheops.exercise.domain.Employee;
import be.cheops.exercise.domain.Person;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

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
        return employees.stream()
                .filter(employee -> isNotBlank(employee.getLastName()))
                .filter(employee -> employee.getLastName().toLowerCase().endsWith("s"))
                .collect(toList());
    }

    @Override
    public List<Employee> findEmployeesWorkingLessThan4YearsSortedByLastAndFirstNameAscending(
            List<Employee> employees) {
        // TODO: Implement using Streaming API
        return employees.stream()
                .filter(employee -> LocalDate.now().minusYears(4).isBefore(employee.getDateInService()))
                .sorted(Comparator.comparing(Person::getLastName).thenComparing(Person::getFirstName))
                .collect(toList());
    }

}
