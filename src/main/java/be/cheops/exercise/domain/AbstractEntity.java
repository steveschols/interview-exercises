package be.cheops.exercise.domain;

import javax.persistence.*;
import java.time.LocalDate;

import static java.time.LocalDate.now;

@MappedSuperclass
public class AbstractEntity {

    @Id
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

    @PrePersist
    public void setCreatedOn() {
        this.createdOn = now();
    }

    @PreUpdate
    public void setLastUpdatedOn() {
        this.lastUpdatedOn = now();
    }

}
