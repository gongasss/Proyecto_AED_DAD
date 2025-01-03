package org.example.proyecto_aed_dad.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "qualifying", schema = "formula1")
public class Qualifying {
    @Id
    @Column(name = "qualifyId", nullable = false)
    private Integer id;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "raceId")
    private Race race;

    @JoinColumn(name = "driverId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Driver driver;

    @JoinColumn(name = "constructorId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Constructor constructor;

    @Column(name = "number")
    private Integer number;

    @Column(name = "position")
    private Integer position;

    @Column(name = "q1", length = 10)
    private String q1;

    @Column(name = "q2", length = 10)
    private String q2;

    @Column(name = "q3", length = 10)
    private String q3;

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
        race.setId(raceId);
    }

    public Integer getDriverId() {
        return driver.getId();
    }

    public void setDriverId(Integer driverId) {
        driver.setId(driverId);
    }

    public Integer getConstructorId() {
        return constructor.getId();
    }

    public void setConstructorId(Integer constructorId) {
        constructor.setId(constructorId);
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public String getQ1() {
        return q1;
    }

    public void setQ1(String q1) {
        this.q1 = q1;
    }

    public String getQ2() {
        return q2;
    }

    public void setQ2(String q2) {
        this.q2 = q2;
    }

    public String getQ3() {
        return q3;
    }

    public void setQ3(String q3) {
        this.q3 = q3;
    }

}