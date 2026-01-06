package com.example.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.jspecify.annotations.Nullable;

@Entity
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String status;
    private String position;

    @ManyToOne
    @JoinColumn(name = "applicant_id", nullable = false)
    @JsonIgnore
    private Applicant applicant;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Applicant getApplicant() {
        return applicant;
    }

    public void setApplicant(Applicant applicant) {
        this.applicant = applicant;
    }

    @Override
    public String toString() {
        return "Application{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", position='" + position + '\'' +
                ", applicant=" + applicant +
                '}';
    }
}
