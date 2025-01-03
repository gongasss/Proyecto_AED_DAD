package org.example.proyecto_aed_dad.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "drivers", schema = "formula1")
public class Driver {
    @Id
    @Column(name = "driverId", nullable = false)
    private Integer id;

    @Column(name = "driverRef", length = 50)
    private String driverRef;

    @Column(name = "number")
    private Integer number;

    @Column(name = "code", length = 10)
    private String code;

    @Column(name = "forename", length = 50)
    private String forename;

    @Column(name = "surname", length = 50)
    private String surname;

    @Column(name = "dob")
    private LocalDate dob;

    @Column(name = "nationality", length = 50)
    private String nationality;

    @Column(name = "url")
    private String url;

    @OneToMany(mappedBy = "driver", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DriverStanding> driverStandings;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDriverRef() {
        return driverRef;
    }

    public void setDriverRef(String driverRef) {
        this.driverRef = driverRef;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getForename() {
        return forename;
    }

    public void setForename(String forename) {
        this.forename = forename;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}