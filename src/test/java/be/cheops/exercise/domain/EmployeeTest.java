package be.cheops.exercise.domain;

import org.junit.Test;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static be.cheops.exercise.domain.Employee.Builder.anEmployee;
import static java.util.Arrays.asList;
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
        //Collections.sort(employees); // TODO: Uncomment and implement where required

        assertThat(employees).containsExactly(
                jefDesmedt, lucDesmedt, kennyDesmedt, jeroenGoossens, steveSchols, johnDoe, kristelHeyns, alainVanDenBossche
        );
    }

    @Test
    public void filterEmployeesWithLastNameEndingOn_S() {
        // TODO: filter the list
        List<Employee> filteredList = employees;

        assertThat(filteredList).containsExactlyInAnyOrder(
                jeroenGoossens, steveSchols, kristelHeyns
        );
    }

    @Test
    public void filterEmployeesWorkingLessThan4YearsSortedByLastAndFirstNameDescending() {
        // TODO: filter the list
        List<Employee> filteredList = employees;

        assertThat(filteredList).containsExactly(
                lucDesmedt, jefDesmedt
        );
    }

}
