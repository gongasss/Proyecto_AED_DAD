package org.example.proyecto_aed_dad.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "status", schema = "formula1")
public class Status {
    @Id
    @Column(name = "statusId", nullable = false)
    private Integer id;

    @Column(name = "status", nullable = false, length = 50)
    private String status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}