package org.example.proyecto_aed_dad.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "races", schema = "formula1")
public class Race {
    @Id
    @Column(name = "raceId", nullable = false)
    private Integer id;

    @Column(name = "year")
    private Integer year;

    @Column(name = "round")
    private Integer round;

    @JoinColumn(name = "circuitId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Circuit circuit;

    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "time")
    private LocalTime time;

    @Column(name = "url")
    private String url;

    @Column(name = "fp1_date")
    private LocalDate fp1Date;

    @Column(name = "fp1_time")
    private LocalTime fp1Time;

    @Column(name = "fp2_date")
    private LocalDate fp2Date;

    @Column(name = "fp2_time")
    private LocalTime fp2Time;

    @Column(name = "fp3_date")
    private LocalDate fp3Date;

    @Column(name = "fp3_time")
    private LocalTime fp3Time;

    @Column(name = "quali_date")
    private LocalDate qualiDate;

    @Column(name = "quali_time")
    private LocalTime qualiTime;

    @Column(name = "sprint_date")
    private LocalDate sprintDate;

    @Column(name = "sprint_time")
    private LocalTime sprintTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getRound() {
        return round;
    }

    public void setRound(Integer round) {
        this.round = round;
    }

    public Circuit getCircuit() {
        return circuit;
    }
    public void setCircuit(Circuit circuit) {
        this.circuit = circuit;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public LocalDate getFp1Date() {
        return fp1Date;
    }

    public void setFp1Date(LocalDate fp1Date) {
        this.fp1Date = fp1Date;
    }

    public LocalTime getFp1Time() {
        return fp1Time;
    }

    public void setFp1Time(LocalTime fp1Time) {
        this.fp1Time = fp1Time;
    }

    public LocalDate getFp2Date() {
        return fp2Date;
    }

    public void setFp2Date(LocalDate fp2Date) {
        this.fp2Date = fp2Date;
    }

    public LocalTime getFp2Time() {
        return fp2Time;
    }

    public void setFp2Time(LocalTime fp2Time) {
        this.fp2Time = fp2Time;
    }

    public LocalDate getFp3Date() {
        return fp3Date;
    }

    public void setFp3Date(LocalDate fp3Date) {
        this.fp3Date = fp3Date;
    }

    public LocalTime getFp3Time() {
        return fp3Time;
    }

    public void setFp3Time(LocalTime fp3Time) {
        this.fp3Time = fp3Time;
    }

    public LocalDate getQualiDate() {
        return qualiDate;
    }

    public void setQualiDate(LocalDate qualiDate) {
        this.qualiDate = qualiDate;
    }

    public LocalTime getQualiTime() {
        return qualiTime;
    }

    public void setQualiTime(LocalTime qualiTime) {
        this.qualiTime = qualiTime;
    }

    public LocalDate getSprintDate() {
        return sprintDate;
    }

    public void setSprintDate(LocalDate sprintDate) {
        this.sprintDate = sprintDate;
    }

    public LocalTime getSprintTime() {
        return sprintTime;
    }

    public void setSprintTime(LocalTime sprintTime) {
        this.sprintTime = sprintTime;
    }

}