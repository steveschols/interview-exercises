package be.cheops.exercise.dao;

import be.cheops.exercise.domain.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;

import static be.cheops.exercise.domain.Employee.Builder.anEmployee;
import static be.cheops.exercise.domain.MaritalStatus.DIVORCED;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class JpaEmployeeDaoImplTest {

    @Autowired
    @Qualifier("jpaEmployeeDaoImpl")
    private EmployeeDao employeeDao;

    @PersistenceContext
    private EntityManager entityManager;

    @Test
    public void saveEmployee() {
        // TODO Fix test by modifying the implementation classes --> Tip: Entity lifecycle
        Employee steveSchols = anEmployee()
                .withFirstName("Steve")
                .withLastName("Schols")
                .withDateInService(LocalDate.of(2013, 10, 1))
                .build();

        steveSchols = employeeDao.saveEmployee(steveSchols);

        assertThat(steveSchols.getCreatedOn()).isNotNull();
    }

    @Test
    public void updateEmployee() {
        // TODO Fix test by modifying the implementation classes --> Tip: Entity lifecycle
        Employee steveSchols = anEmployee()
                .withFirstName("Steve")
                .withLastName("Schols")
                .withDateInService(LocalDate.of(2013, 10, 1))
                .build();

        employeeDao.saveEmployee(steveSchols);
        flushAndClearEntityManager();

        steveSchols.setMaritalStatus(DIVORCED);

        steveSchols = employeeDao.updateEmployee(steveSchols);
        flushAndClearEntityManager();

        assertThat(steveSchols.getLastUpdatedOn()).isNotNull();
    }

    private void flushAndClearEntityManager() {
        entityManager.flush();
        entityManager.clear();
    }

}