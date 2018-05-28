package be.cheops.exercise.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.MappedSuperclass;
import java.time.LocalDate;

import static java.time.LocalDate.now;

@MappedSuperclass
public class AbstractEntity {

    @GeneratedValue
    Long id;

    LocalDate createdOn;

    LocalDate lastUpdatedOn;

    public Long getId() {
        return id;
    }

    public LocalDate getCreatedOn() {
        return createdOn;
    }

    public LocalDate getLastUpdatedOn() {
        return lastUpdatedOn;
    }

    public void setCreatedOn() {
        this.createdOn = now();
    }

    public void setLastUpdatedOn() {
        this.lastUpdatedOn = now();
    }

}
