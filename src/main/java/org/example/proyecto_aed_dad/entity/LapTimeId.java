package org.example.proyecto_aed_dad.entity;

import jakarta.persistence.*;
import org.hibernate.Hibernate;

import java.util.Objects;

@Embeddable
public class LapTimeId implements java.io.Serializable {
    private static final long serialVersionUID = 1694571277492064384L;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "raceId", nullable = false)
    private Race race;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "driverId", nullable = false)
    private Driver driver;

    @Column(name = "lap", nullable = false)
    private Integer lap;

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Integer getLap() {
        return lap;
    }

    public void setLap(Integer lap) {
        this.lap = lap;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        LapTimeId entity = (LapTimeId) o;
        return Objects.equals(this.race.getId(), entity.race.getId()) &&
                Objects.equals(this.driver.getId(), entity.driver.getId()) &&
                Objects.equals(this.lap, entity.lap);
    }

    @Override
    public int hashCode() {
        return Objects.hash(race.getId(), driver.getId(), lap);
    }

}