package org.example.proyecto_aed_dad.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalTime;

@Entity
@Table(name = "pit_stops", schema = "formula1")
public class PitStop {
    @EmbeddedId
    private PitStopId id;

    @Column(name = "lap")
    private Integer lap;

    @Column(name = "time")
    private LocalTime time;

    @Column(name = "duration")
    private Float duration;

    @Column(name = "milliseconds")
    private Integer milliseconds;

    public PitStopId getId() {
        return id;
    }

    public void setId(PitStopId id) {
        this.id = id;
    }

    public Integer getLap() {
        return lap;
    }

    public void setLap(Integer lap) {
        this.lap = lap;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public Float getDuration() {
        return duration;
    }

    public void setDuration(Float duration) {
        this.duration = duration;
    }

    public Integer getMilliseconds() {
        return milliseconds;
    }

    public void setMilliseconds(Integer milliseconds) {
        this.milliseconds = milliseconds;
    }

}