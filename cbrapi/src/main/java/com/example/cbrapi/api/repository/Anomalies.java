package com.example.cbrapi.api.repository;

import com.example.cbrapi.api.model.Anomaly;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface Anomalies extends JpaRepository<Anomaly, Long> {

    List<Anomaly> findBySeverity(String severity);

}
