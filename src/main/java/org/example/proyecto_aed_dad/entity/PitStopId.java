package org.example.proyecto_aed_dad.entity;

import jakarta.persistence.*;
import org.hibernate.Hibernate;

import java.util.Objects;

@Embeddable
public class PitStopId implements java.io.Serializable {
    private static final long serialVersionUID = -8369786972710162616L;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "raceId", nullable = false)
    private Race race;

    @JoinColumn(name = "driverId", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Driver driver;

    @Column(name = "stop", nullable = false)
    private Integer stop;

    public Integer getRaceId() {
        return race.getId();
    }

    public void setRaceId(Integer raceId) {
        this.race.setId(raceId);
    }

    public Integer getDriverId() {
        return driver.getId();
    }

    public void setDriverId(Integer driverId) {
        this.driver.setId(driverId);
    }

    public Integer getStop() {
        return stop;
    }

    public void setStop(Integer stop) {
        this.stop = stop;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        PitStopId entity = (PitStopId) o;
        return Objects.equals(this.race.getId(), entity.race.getId()) &&
                Objects.equals(this.driver.getId(), entity.driver.getId()) &&
                Objects.equals(this.stop, entity.stop);
    }

    @Override
    public int hashCode() {
        return Objects.hash(race.getId(), driver.getId(), stop);
    }

}