package com.example.cbrapi.api.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "anomaly")
public class Anomaly {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String severity;
    private String response;
    private String description;
    //used for nlp searches in db
    private String keywords;

    public Anomaly() {}

    public Anomaly(Long id, String severity, String description, String keywords) {
        this.id = id;
        this.severity = severity;
        this.description = description;
        this.keywords = keywords;
    }

    @Override
    public String toString() {
        return "Anomaly{" +
                "id=" + id +
                ", severity='" + severity + '\'' +
                ", response='" + response + '\'' +
                ", description='" + description + '\'' +
                ", keywords='" + keywords + '\'' +
                '}';
    }
}
