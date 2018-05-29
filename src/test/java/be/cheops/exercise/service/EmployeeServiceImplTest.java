package be.cheops.exercise.service;

import be.cheops.exercise.TestData;
import be.cheops.exercise.domain.Employee;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.slf4j.LoggerFactory.getLogger;

public class EmployeeServiceImplTest extends TestData {

    private EmployeeService employeeService =
            new EmployeeServiceImpl(null, getLogger(EmployeeServiceImpl.class));

    @Test
    public void findEmployeesWithLastNameEndingOn_S() {
        // TODO: Implement the service method using Jva 8 Stream API.
        List<Employee> filteredList =
                employeeService.findEmployeesWithLastNameEndingOn_S(employees);

        assertThat(filteredList).containsExactlyInAnyOrder(
                jeroenGoossens, steveSchols, kristelHeyns
        );
    }

    @Test
    public void findEmployeesWorkingLessThan4YearsSortedByLastAndFirstNameDescending() {
        // TODO: Implement the service method using Jva 8 Stream API.
        List<Employee> filteredList =
                employeeService.findEmployeesWorkingLessThan4YearsSortedByLastAndFirstNameDescending(employees);

        assertThat(filteredList).containsExactly(
                lucDesmedt, jefDesmedt
        );
    }

}
