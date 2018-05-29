package be.cheops.exercise.service;

import be.cheops.exercise.domain.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findEmployeesWithLastNameEndingOn_S(List<Employee> employees);

    List<Employee> findEmployeesWorkingLessThan4YearsSortedByLastAndFirstNameAscending(
            List<Employee> employees);

}
