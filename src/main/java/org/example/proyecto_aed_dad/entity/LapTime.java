package org.example.proyecto_aed_dad.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "lap_times", schema = "formula1")
public class LapTime {
    @EmbeddedId
    private LapTimeId id;

    @Column(name = "position")
    private Integer position;

    @Column(name = "time", length = 10)
    private String time;

    @Column(name = "milliseconds")
    private Integer milliseconds;

    public LapTimeId getId() {
        return id;
    }

    public void setId(LapTimeId id) {
        this.id = id;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getMilliseconds() {
        return milliseconds;
    }

    public void setMilliseconds(Integer milliseconds) {
        this.milliseconds = milliseconds;
    }

}