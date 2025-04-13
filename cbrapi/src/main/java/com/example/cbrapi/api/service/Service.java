package com.example.cbrapi.api.service;

import com.example.cbrapi.api.model.Anomaly;
import com.example.cbrapi.api.repository.Anomalies;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Arrays;
import java.util.List;


@org.springframework.stereotype.Service
public class Service {

    @Autowired
    private Anomalies anomalyRepository;

    private NLPService nlpService;

    @Autowired
    public Service(Anomalies anomalyRepository, NLPService nlpService) {
        this.anomalyRepository = anomalyRepository;
        this.nlpService = nlpService;
    }

    public List<Anomaly> matchBySeverity(String severity) {
        return anomalyRepository.findBySeverity(severity);
    }

    public Anomaly processAnomaly(Anomaly anomaly) {
        //function returns the response, appends to request case and saves in db


        //pass description to NLP for keyword extraction
        List<String> keywords = nlpService.extractKeywords(anomaly.getDescription());
        anomaly.setKeywords(String.join(",", keywords));
        //finding cases with same severity
        List<Anomaly> cases = matchBySeverity(anomaly.getSeverity());

//        System.out.println(cases);

        Anomaly bestCase = determineClosestCase(cases, keywords);
        System.out.println("BEST CASE: "+bestCase);
        anomaly.setResponse(bestCase.getResponse());
        anomalyRepository.save(anomaly);

        return anomaly;


    }

    public Anomaly determineClosestCase(List<Anomaly> anomalies, List<String> currentKeywords) {
        Anomaly bestMatch = null;
        int highestScore = -1;

        for (Anomaly a : anomalies) {
            String candidateKeywords = a.getDescription();

            // calculate the number of shared keywords
            int matchScore = 0;
            for (String keyword : currentKeywords) {
                if (candidateKeywords.contains(keyword)) {
                    matchScore++;
                }
            }

            if (matchScore > highestScore) {
                highestScore = matchScore;
                bestMatch = a;
            }
        }

        return bestMatch;
    }

}
