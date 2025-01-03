package org.example.proyecto_aed_dad.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "constructors_results", schema = "formula1")
public class ConstructorsResult {
    @Id
    @Column(name = "constructorResultsId", nullable = false)
    private Integer id;

    @Column(name = "raceId")
    private Integer raceId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "constructorId", nullable = false)
    private Constructor constructor;

    @Column(name = "points")
    private Float points;

    @Column(name = "status", length = 50)
    private String status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRaceId() {
        return raceId;
    }

    public void setRaceId(Integer raceId) {
        this.raceId = raceId;
    }

    public Constructor getConstructor() {
        return constructor;
    }

    public void setConstructor(Constructor constructor) {
        this.constructor = constructor;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}