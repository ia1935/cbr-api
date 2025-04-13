# Case-Based Reasoning (CBR) API for Autonomous Vehicles

A Spring Boot-based API that implements a Case-Based Reasoning model to analyze and match anomaly descriptions using basic NLP techniques. Built with Java 21 and Docker for easy deployment.

## Features

- Natural Language Processing (NLP) on input anomaly descriptions
- Matches against historical cases using keyword ordering
- Returns the closest matching case for resolution
- Containerized for ease of use via Docker

---

## Prerequisites

- [Docker](https://www.docker.com/get-started) installed on your system

---

## Getting Started

### Run with Docker

1. Clone this repository:

```bash
git clone https://github.com/ia1935/cbr-api.git
cd cbr-api


```
2. Run the docker image:
```bash 
docker-compose up --build
```

### API Endpoint:
http://localhost:8080/api/anomaly

### Note:
Submit POST requests in the following form:
```json
POST http://localhost:8080/api/anomaly
Content-Type: application/json

{
  "severity": "",
  "description": ""
}
```
