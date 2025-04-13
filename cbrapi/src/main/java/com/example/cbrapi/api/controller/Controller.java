package com.example.cbrapi.api.controller;

import com.example.cbrapi.api.model.Anomaly;
import com.example.cbrapi.api.service.Service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/api")
public class Controller {


    private final Service anomalyService;

    public Controller(Service anomalyService) {
        this.anomalyService = anomalyService;
    }

    @PostMapping("/anomaly")
    public ResponseEntity<Map<String,String>> anomalyReport(@RequestBody Anomaly anomaly){
    //        System.out.println(anomaly);

        Anomaly matchanomaly = anomalyService.processAnomaly(anomaly);

        Map<String,String> response = new HashMap<>();
        response.put("response",matchanomaly.getResponse());

        return ResponseEntity.ok(response);
    }
}
