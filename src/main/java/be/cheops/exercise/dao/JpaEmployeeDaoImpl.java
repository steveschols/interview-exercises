package be.cheops.exercise.dao;

import be.cheops.exercise.domain.Employee;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class JpaEmployeeDaoImpl implements EmployeeDao {

    private EntityManager entityManager;

    @Override
    public Employee saveEmployee(Employee employee) {
        entityManager.persist(employee);
        return employee;
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return entityManager.merge(employee);
    }

    @Override
    public Employee findEmployee(Long id) {
        return entityManager.find(Employee.class, id);
    }

}
