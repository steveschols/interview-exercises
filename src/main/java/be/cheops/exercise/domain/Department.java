package be.cheops.exercise.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
public class Department extends AbstractEntity {

    private String name;

    @ManyToOne
    private Employee manager;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

    public static final class Builder {
        Long id;
        LocalDate createdOn;
        LocalDate lastUpdatedOn;
        private String name;
        private Employee manager;

        private Builder() {
        }

        public static Builder aDepartment() {
            return new Builder();
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withManager(Employee manager) {
            this.manager = manager;
            return this;
        }

        public Builder withId(Long id) {
            this.id = id;
            return this;
        }

        public Builder withCreatedOn(LocalDate createdOn) {
            this.createdOn = createdOn;
            return this;
        }

        public Builder withLastUpdatedOn(LocalDate lastUpdatedOn) {
            this.lastUpdatedOn = lastUpdatedOn;
            return this;
        }

        public Department build() {
            Department department = new Department();
            department.id = this.id;
            department.name = this.name;
            department.manager = this.manager;
            return department;
        }
    }

}
