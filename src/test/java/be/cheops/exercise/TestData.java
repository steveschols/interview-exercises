package be.cheops.exercise;

import be.cheops.exercise.domain.Employee;

import java.time.LocalDate;
import java.util.List;

import static be.cheops.exercise.domain.Employee.Builder.anEmployee;
import static java.util.Arrays.asList;

public class TestData {

    protected Employee steveSchols = anEmployee().withFirstName("Steve").withLastName("Schols").withDateInService(LocalDate.of(2013, 10, 1)).build();
    protected Employee kennyDesmedt = anEmployee().withFirstName("Kenny").withLastName("Desmedt").withDateInService(LocalDate.of(2013, 10, 1)).build();
    protected Employee jeroenGoossens = anEmployee().withFirstName("Jeroen").withLastName("Goossens").withDateInService(LocalDate.of(2013, 10, 1)).build();
    protected Employee johnDoe = anEmployee().withFirstName("John").withLastName(null).withDateInService(LocalDate.of(2013, 10, 1)).build();
    protected Employee jefDesmedt = anEmployee().withFirstName("Jef").withLastName("Desmedt").withDateInService(LocalDate.of(2016, 9, 10)).build();
    protected Employee lucDesmedt = anEmployee().withFirstName("Luc").withLastName("Desmedt").withDateInService(LocalDate.of(2016, 9, 10)).build();
    protected Employee alainVanDenBossche = anEmployee().withFirstName("Alain").withLastName("Van den Bossche").withDateInService(LocalDate.of(2000, 1, 1)).build();
    protected Employee kristelHeyns = anEmployee().withFirstName("Kristel").withLastName("HeynS").withDateInService(LocalDate.of(2000, 1, 1)).build();

    protected List<Employee> employees = asList(
            lucDesmedt, steveSchols, kennyDesmedt, jeroenGoossens, johnDoe, jefDesmedt, alainVanDenBossche, kristelHeyns);


}
