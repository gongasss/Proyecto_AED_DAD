package org.example.proyecto_aed_dad.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "constructors", schema = "formula1")
public class Constructor {
    @Id
    @Column(name = "constructorId", nullable = false)
    private Integer id;

    @Column(name = "constructorRef", length = 50)
    private String constructorRef;

    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "nationality", length = 50)
    private String nationality;

    @Column(name = "url")
    private String url;

    @OneToMany(mappedBy = "constructor", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<ConstructorsResult> constructorResults;

    @OneToMany(mappedBy = "constructor", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<ConstructorStanding> constructorStandings;

    @OneToMany(mappedBy = "constructor", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<Result> results;

    @OneToMany(mappedBy = "constructor", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<SprintResult> sprintResults;

    @OneToMany(mappedBy = "constructor", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<Qualifying> qualifyingResults;

    public List<ConstructorStanding> getConstructorStandings() {
        return constructorStandings;
    }

    public void setConstructorStandings(List<ConstructorStanding> constructorStandings) {
        this.constructorStandings = constructorStandings;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getConstructorRef() {
        return constructorRef;
    }

    public void setConstructorRef(String constructorRef) {
        this.constructorRef = constructorRef;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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