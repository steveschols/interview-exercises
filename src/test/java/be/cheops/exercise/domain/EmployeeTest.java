package be.cheops.exercise.domain;

import be.cheops.exercise.TestData;
import org.junit.Test;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

public class EmployeeTest extends TestData {

    @Test
    public void sortEmployeesByDateInServiceDescendingAndLastAndFirstNameAscending() {
        Collections.sort(employees); // TODO: Uncomment and implement where required

        assertThat(employees).containsExactly(
                jefDesmedt, lucDesmedt, kennyDesmedt, jeroenGoossens, steveSchols, johnDoe, kristelHeyns, alainVanDenBossche
        );
    }

}
