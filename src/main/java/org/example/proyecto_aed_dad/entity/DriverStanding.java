package org.example.proyecto_aed_dad.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "driver_standings", schema = "formula1")
public class DriverStanding {
    @Id
    @Column(name = "driverStandingsId", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "raceId")
    private Race race;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "driverId")
    private Driver driver;

    @Column(name = "points")
    private Float points;

    @Column(name = "position")
    private Integer position;

    @Column(name = "positionText", length = 10)
    private String positionText;

    @Column(name = "wins")
    private Integer wins;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRaceId() {
        return race.getId();
    }

    public void setRaceId(Integer raceId) {
        this.race.setId(raceId);
    }

    public Integer getDriverId() {
        return this.driver.getId();
    }

    public void setDriverId(Integer driverId) {
        this.driver.setId(driverId);
    }

    public Float getPoints() {
        return points;
    }

    public void setPoints(Float points) {
        this.points = points;
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

    public Integer getWins() {
        return wins;
    }

    public void setWins(Integer wins) {
        this.wins = wins;
    }

}