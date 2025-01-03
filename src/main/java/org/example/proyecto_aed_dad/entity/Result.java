package org.example.proyecto_aed_dad.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "results", schema = "formula1")
public class Result {
    @Id
    @Column(name = "resultId", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "raceId")
    private Race race;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "driverId")
    private Driver driver;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "constructorId")
    private Constructor constructor;

    @Column(name = "number")
    private Integer number;

    @Column(name = "grid")
    private Integer grid;

    @Column(name = "position")
    private Integer position;

    @Column(name = "positionText", length = 10)
    private String positionText;

    @Column(name = "positionOrder")
    private Integer positionOrder;

    @Column(name = "points", precision = 5, scale = 2)
    private BigDecimal points;

    @Column(name = "laps")
    private Integer laps;

    @Column(name = "time", length = 20)
    private String time;

    @Column(name = "milliseconds")
    private Long milliseconds;

    @Column(name = "fastestLap")
    private Integer fastestLap;

    @Column(name = "_rank")
    private Integer rank;

    @Column(name = "fastestLapTime", length = 10)
    private String fastestLapTime;

    @Column(name = "fastestLapSpeed", precision = 8, scale = 3)
    private BigDecimal fastestLapSpeed;

    @Column(name = "statusId")
    private Integer statusId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRaceId() {
        return this.race.getId();
    }

    public void setRace(Race race) {
        this.race = race;
    }
    public Race getRace() {
        return race;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }
    public Driver getDriver() {
        return driver;
    }
    public void setConstructor(Constructor constructor) {
        this.constructor = constructor;
    }
    public Constructor getConstructor() {
        return constructor;
    }
    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getGrid() {
        return grid;
    }

    public void setGrid(Integer grid) {
        this.grid = grid;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public String getPositionText() {
        return positionText;
    }

    public void setPositionText(String positionText) {
        this.positionText = positionText;
    }

    public Integer getPositionOrder() {
        return positionOrder;
    }

    public void setPositionOrder(Integer positionOrder) {
        this.positionOrder = positionOrder;
    }

    public BigDecimal getPoints() {
        return points;
    }

    public void setPoints(BigDecimal points) {
        this.points = points;
    }

    public Integer getLaps() {
        return laps;
    }

    public void setLaps(Integer laps) {
        this.laps = laps;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Long getMilliseconds() {
        return milliseconds;
    }

    public void setMilliseconds(Long milliseconds) {
        this.milliseconds = milliseconds;
    }

    public Integer getFastestLap() {
        return fastestLap;
    }

    public void setFastestLap(Integer fastestLap) {
        this.fastestLap = fastestLap;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public String getFastestLapTime() {
        return fastestLapTime;
    }

    public void setFastestLapTime(String fastestLapTime) {
        this.fastestLapTime = fastestLapTime;
    }

    public BigDecimal getFastestLapSpeed() {
        return fastestLapSpeed;
    }

    public void setFastestLapSpeed(BigDecimal fastestLapSpeed) {
        this.fastestLapSpeed = fastestLapSpeed;
    }

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }
    public void setResultId(Integer resultId) {
        this.id = resultId;
    }

}