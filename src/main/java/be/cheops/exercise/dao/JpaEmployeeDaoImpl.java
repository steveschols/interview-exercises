package be.cheops.exercise.dao;

import be.cheops.exercise.domain.Employee;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Primary
public class JpaEmployeeDaoImpl implements EmployeeDao {

    @PersistenceContext
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
