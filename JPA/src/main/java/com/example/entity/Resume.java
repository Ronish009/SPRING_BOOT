package com.example.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class Resume {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String content;

    @OneToOne
    @JoinColumn(name = "applicant_Id", nullable = false)
    @JsonIgnore
    private Applicant applicant;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Applicant getApplicant() {
        return applicant;
    }

    public void setApplicant(Applicant applicant) {
        this.applicant = applicant;
    }

    @Override
    public String toString() {
        return "Resume{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", applicant=" + applicant +
                '}';
    }
}
