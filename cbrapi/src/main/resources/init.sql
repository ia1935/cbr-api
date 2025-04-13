CREATE TABLE IF NOT EXISTS anomaly(
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    description VARCHAR(255),
    keywords VARCHAR(255),
    response VARCHAR(255),
    severity VARCHAR(255)
);

INSERT INTO anomaly (description, keywords, response, severity)
VALUES("Large tree blocking road.", "tree,road,blocking,large",
       "Initiate Replanning for alternative routes",
       "high");

INSERT INTO anomaly (description, keywords, response, severity)
VALUES (
           "Vehicle stalled in center lane.",
           "vehicle,lane,stalled",
           "Reroute to avoid blocked lane",
           "high"
       );

INSERT INTO anomaly (description, keywords, response, severity)
VALUES (
           "Debris scattered along shoulder.",
           "debris,shoulder,scattered",
           "Switch lanes or slow down while passing debris zone",
           "medium"
       );

INSERT INTO anomaly (description, keywords, response, severity)
VALUES (
           "Animal crossing road.",
           "animal,crossing,road",
           "Apply brakes and pause route until road is clear",
           "high"
       );

INSERT INTO anomaly (description, keywords, response, severity)
VALUES (
           "Traffic light malfunction at intersection.",
           "light,intersection,malfunction",
           "Pause and proceed with caution; alert control system",
           "medium"
       );


INSERT INTO anomaly (description, keywords, response, severity)
VALUES (
           "Temporary signage placed near curb.",
           "signage,curb,placed,temporary",
           "Update visual map and continue path",
           "low"
       );

INSERT INTO anomaly (description, keywords, response, severity)
VALUES (
           "Pothole detected on right lane.",
           "pothole,lane,detected",
           "Adjust lane positioning to avoid pothole",
           "low"
       );

INSERT INTO anomaly (description, keywords, response, severity)
VALUES (
           "Uneven pavement ahead.",
           "pavement,detected,uneven",
           "Reduce speed slightly and proceed with caution",
           "low"
       );