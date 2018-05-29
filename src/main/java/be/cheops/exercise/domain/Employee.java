package be.cheops.exercise.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

import static java.util.Comparator.*;

@Entity
public class Employee extends Person implements Comparable<Employee> {

    @Column(nullable = false)
    private LocalDate dateInService;

    private LocalDate dateOufOfService;

    @ManyToOne
    private Department department;

    public LocalDate getDateInService() {
        return dateInService;
    }

    public void setDateInService(LocalDate dateInService) {
        this.dateInService = dateInService;
    }

    public LocalDate getDateOufOfService() {
        return dateOufOfService;
    }

    public void setDateOufOfService(LocalDate dateOufOfService) {
        this.dateOufOfService = dateOufOfService;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return new org.apache.commons.lang3.builder.ToStringBuilder(this)
                .append("firstName", firstName)
                .append("lastName", lastName)
                .append("dateInService", dateInService)
                .toString();
    }

    @Override
    public int compareTo(Employee other) {
        return comparing(Employee::getDateInService).reversed()
                .thenComparing(Person::getLastName, nullsLast(naturalOrder()))
                .thenComparing(Person::getFirstName)
                .compare(this, other);
    }

    public static final class Builder {
        private LocalDate dateInService;
        private LocalDate dateOufOfService;
        private Department department;
        private Long id;
        private String firstName;
        private String lastName;
        private LocalDate dateOfBirth;
        private MaritalStatus maritalStatus;

        private Builder() {
        }

        public static Builder anEmployee() {
            return new Builder();
        }

        public Builder withDateInService(LocalDate dateInService) {
            this.dateInService = dateInService;
            return this;
        }

        public Builder withDateOufOfService(LocalDate dateOufOfService) {
            this.dateOufOfService = dateOufOfService;
            return this;
        }

        public Builder withDepartment(Department department) {
            this.department = department;
            return this;
        }

        public Builder withId(Long id) {
            this.id = id;
            return this;
        }

        public Builder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder withDateOfBirth(LocalDate dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
            return this;
        }

        public Builder withMaritalStatus(MaritalStatus maritalStatus) {
            this.maritalStatus = maritalStatus;
            return this;
        }

        public Employee build() {
            Employee employee = new Employee();
            employee.id = this.id;
            employee.department = this.department;
            employee.dateOfBirth = this.dateOfBirth;
            employee.lastName = this.lastName;
            employee.dateInService = this.dateInService;
            employee.dateOufOfService = this.dateOufOfService;
            employee.firstName = this.firstName;
            employee.maritalStatus = this.maritalStatus;
            return employee;
        }
    }

}
