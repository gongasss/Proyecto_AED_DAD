package org.example.proyecto_aed_dad.entity;

import jakarta.persistence.*;
import org.hibernate.Hibernate;

import java.util.Objects;

@Embeddable
public class PitStopId implements java.io.Serializable {
    private static final long serialVersionUID = -8369786972710162616L;

    @Column(name = "raceId", nullable = false)
    private Integer raceId;

    @Column(name = "driverId", nullable = false)
    private Integer driverId;

    @Column(name = "stop", nullable = false)
    private Integer stop;

    public Integer getRaceId() {
        return raceId;
    }

    public void setRaceId(Integer raceId) {
        this.raceId = raceId;
    }

    public Integer getDriverId() {
        return driverId;
    }

    public void setDriverId(Integer driverId) {
        this.driverId = driverId;
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
        return Objects.equals(this.raceId, entity.raceId) &&
                Objects.equals(this.driverId, entity.driverId) &&
                Objects.equals(this.stop, entity.stop);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.raceId, this.driverId, this.stop);
    }

}