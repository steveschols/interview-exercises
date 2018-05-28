package be.cheops.exercise.domain;

import org.junit.Test;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static be.cheops.exercise.domain.Employee.Builder.anEmployee;
import static java.time.LocalDate.now;
import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;
import static org.apache.commons.lang3.StringUtils.isNotBlank;
import static org.assertj.core.api.Assertions.assertThat;

public class EmployeeTest {

    private Employee steveSchols = anEmployee().withFirstName("Steve").withLastName("Schols").withDateInService(LocalDate.of(2013, 10, 1)).build();
    private Employee kennyDesmedt = anEmployee().withFirstName("Kenny").withLastName("Desmedt").withDateInService(LocalDate.of(2013, 10, 1)).build();
    private Employee jeroenGoossens = anEmployee().withFirstName("Jeroen").withLastName("Goossens").withDateInService(LocalDate.of(2013, 10, 1)).build();
    private Employee johnDoe = anEmployee().withFirstName("John").withLastName(null).withDateInService(LocalDate.of(2013, 10, 1)).build();
    private Employee jefDesmedt = anEmployee().withFirstName("Jef").withLastName("Desmedt").withDateInService(LocalDate.of(2016, 9, 10)).build();
    private Employee lucDesmedt = anEmployee().withFirstName("Luc").withLastName("Desmedt").withDateInService(LocalDate.of(2016, 9, 10)).build();
    private Employee alainVanDenBossche = anEmployee().withFirstName("Alain").withLastName("Van den Bossche").withDateInService(LocalDate.of(2000, 1, 1)).build();
    private Employee kristelHeyns = anEmployee().withFirstName("Kristel").withLastName("HeynS").withDateInService(LocalDate.of(2000, 1, 1)).build();

    private List<Employee> employees = asList(
            lucDesmedt, steveSchols, kennyDesmedt, jeroenGoossens, johnDoe, jefDesmedt, alainVanDenBossche, kristelHeyns);

    @Test
    public void sortEmployeesByDateInServiceDescendingAndLastAndFirstNameAscending() {
        // TODO: Implement code to enable sorting of Employees
        Collections.sort(employees);

        assertThat(employees).containsExactly(
                jefDesmedt, lucDesmedt, kennyDesmedt, jeroenGoossens, steveSchols, johnDoe, kristelHeyns, alainVanDenBossche
        );
    }

    @Test
    public void filterEmployeesWithLastNameEndingOn_S() {
        // TODO: filter the list
        List<Employee> filteredList = employees.stream()
                .filter(employee -> isNotBlank(employee.getLastName()))
                .filter(employee -> employee.getLastName().toLowerCase().endsWith("s"))
                .collect(toList());

        assertThat(filteredList).containsExactlyInAnyOrder(
                jeroenGoossens, steveSchols, kristelHeyns
        );
    }

    @Test
    public void filterEmployeesWorkingLessThan4YearsSortedByLastAndFirstNameDescending() {
        // TODO: filter the list
        List<Employee> filteredList = employees.stream()
                .filter(employee -> now().minusYears(4).isBefore(employee.getDateInService()))
                .sorted(Comparator.comparing(Person::getLastName)
                        .thenComparing(Person::getFirstName)
                        .reversed())
                .collect(toList());

        assertThat(filteredList).containsExactly(
                lucDesmedt, jefDesmedt
        );
    }

}
