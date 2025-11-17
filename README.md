# fx-deal-importer
This project is a Spring Boot application designed to ingest and validate FX deal data, persist records into a database, prevent duplicates, and ensure no rollback on failure. It includes Docker deployment, Postman tests, K6 performance testing, and automated unit/integration tests.

Voici **le code EXACT du README.md**, brut, sans explications autour — tu peux le **copier-coller directement dans GitHub** (dans `README.md`).

---

# 📌 **README.md — Code brut à coller**

```markdown
# FX Deal Processor – SDET Assignment

This project is a Spring Boot application designed to ingest and validate FX deal data,
persist records into a database, prevent duplicates, and ensure no rollback on failure.
It includes Docker deployment, Postman tests, K6 performance testing, and automated
unit/integration tests.

---

## 📌 1. Project Overview

The goal is to simulate a real SDET workflow by:

- Validating FX deal requests  
- Saving each deal independently  
- Preventing duplicate deal imports  
- Ensuring no rollback on failed rows  
- Providing full API testing (Postman)  
- Performance testing (K6)  
- Deployment using Docker Compose  
- Full automated tests (JUnit + Mockito + Testcontainers)

---

## 📌 2. Architecture

```

fx-deal-processor/
│── src/main/java/com/example/fxdeal/
│   ├── controller/
│   ├── service/
│   ├── repository/
│   ├── model/
│   ├── dto/
│   ├── exception/
│   ├── config/
│── src/test/java/com/example/fxdeal/
│   ├── unit/
│   ├── integration/
│   ├── mvc/
│── docker-compose.yml
│── Dockerfile
│── loadtest.js
│── postman_collection.json
│── sample-data.csv
│── Makefile
│── README.md

````

---

## 📌 3. Technologies

- Spring Boot 3  
- Java 21  
- PostgreSQL / MySQL / MongoDB  
- Docker & Docker Compose  
- JUnit5, Mockito, Testcontainers  
- K6  
- Postman  
- Maven or Gradle  

---

## 📌 4. Features

### ✔ Validate FX Deal fields
- dealId  
- fromCurrency (ISO 4217)  
- toCurrency (ISO 4217)  
- timestamp  
- amount (> 0)

### ✔ Duplicate detection  
Enforced by a UNIQUE constraint in the database.

### ✔ No rollback  
Each row is saved independently; failures do not cancel previous inserts.

### ✔ Logging  
Detailed log output for monitoring & debugging.

### ✔ Error handling  
Structured error responses (400, 409, 500).

---

## 📌 5. How to Run

### ▶ 5.1 Clone the repository
```bash
git clone https://github.com/<your-username>/fx-deal-processor.git
cd fx-deal-processor
````

### ▶ 5.2 Run with Docker Compose

```bash
docker-compose up --build
```

### ▶ 5.3 Run locally

```bash
mvn spring-boot:run
```

---

## 📌 6. API Endpoints

### ▶ Create FX Deal

**POST** `/api/deals`

Request:

```json
{
  "dealId": "FX1001",
  "fromCurrency": "USD",
  "toCurrency": "EUR",
  "timestamp": "2025-01-01T12:00:00Z",
  "amount": 1200.50
}
```

Responses:

| Code | Description    |
| ---- | -------------- |
| 201  | Deal inserted  |
| 400  | Invalid input  |
| 409  | Duplicate deal |
| 500  | Server error   |

---

## 📌 7. Sample CSV

`sample-data.csv`

```
dealId,fromCurrency,toCurrency,timestamp,amount
FX1001,USD,EUR,2025-01-01T12:00:00Z,1200
FX1002,GBP,USD,2025-01-01T14:00:00Z,2100
```

---

## 📌 8. Postman Collection

Import `postman_collection.json` into Postman:
**File → Import → Choose file**

Tests included:

* Valid deal creation
* Missing fields
* Invalid formats
* Duplicate deal
* Error handling

---

## 📌 9. K6 Performance Testing

Run:

```bash
k6 run loadtest.js
```

Metrics:

* Latency
* Error rate
* Throughput
* RPS

---

## 📌 10. Testing Strategy

### ✔ Unit Tests (JUnit + Mockito)

* Service logic
* Validation
* Duplicate handling

### ✔ Integration Tests (Testcontainers)

* Real PostgreSQL container
* Repository behavior
* DB constraint validation

### ✔ Spring MVC Tests

* Endpoint behavior
* Validation response
* Controller flow

---

## 📌 11. Makefile (Optional)

Example:

```
make build
make test
make run
make docker
make k6
```

---

## 📌 12. Deployment

### Docker:

```bash
docker-compose up -d
```

### Manual:

```bash
mvn clean package
java -jar target/fx-deal-processor.jar
```

---

## 📌 13. Author

**Rabab Mahrache**
SDET  – FX Deal Processor
2025

```
