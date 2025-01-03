package org.example.proyecto_aed_dad.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "constructor_standings", schema = "formula1")
public class ConstructorStanding {
    @Id
    @Column(name = "constructorStandingsId", nullable = false)
    private Integer id;

    @JoinColumn(name = "raceId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Race race;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "constructorId")
    private Constructor constructor;

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
        return this.race.getId();
    }

    public void setRaceId(Integer raceId) {
        this.race.setId(raceId);
    }

    public Integer getConstructorId() {
        return this.constructor.getId();
    }

    public void setConstructorId(Integer constructorId) {
        this.constructor.setId(constructorId);
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