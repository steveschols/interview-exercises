package be.cheops.exercise.dao;

import be.cheops.exercise.domain.Employee;

public interface EmployeeDao {

    Employee saveEmployee(Employee employee);

    Employee updateEmployee(Employee employee);

    Employee findEmployee(Long id);

}
