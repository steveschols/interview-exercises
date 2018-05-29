package be.cheops.exercise.dao;

import be.cheops.exercise.domain.Employee;
import org.springframework.stereotype.Repository;

@Repository
public class NoSqlEmployeeDaoImpl implements EmployeeDao {

    @Override
    public Employee saveEmployee(Employee employee) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        throw new UnsupportedOperationException();
    }

}
