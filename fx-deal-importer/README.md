Voici **le fichier README.md complet**, prêt à être collé tel quel dans ton projet.

---

# 📄 **README.md (VERSION COMPLÈTE & PROFESSIONNELLE)**

Copie-colle tout ce bloc dans ton fichier :

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
│   ├── controller/         → REST endpoints
│   ├── service/            → Business logic
│   ├── repository/         → JPA repositories
│   ├── model/              → Entities
│   ├── dto/                → Request objects + validation
│   ├── exception/          → Global exception handling
│   ├── config/             → DB + app configs
│── src/test/java/com/example/fxdeal/
│   ├── unit/               → JUnit + Mockito tests
│   ├── integration/        → Testcontainers tests
│   ├── mvc/                → Spring MVC tests
│── docker-compose.yml
│── Dockerfile
│── loadtest.js             → K6 performance test
│── postman_collection.json
│── sample-data.csv
│── Makefile
│── README.md

````

---

## 📌 3. Technologies

- **Spring Boot 3**
- **Java 21**
- **PostgreSQL (or MySQL/Mongo)**
- **Docker & Docker Compose**
- **JUnit 5 / Mockito / Testcontainers**
- **K6** (load testing)
- **Postman** (API testing)
- **Maven or Gradle**

---

## 📌 4. Features

### ✔ Validate FX Deal fields
- dealId (string)
- fromCurrency (ISO 4217: USD, EUR…)
- toCurrency (ISO 4217)
- timestamp (ISO date)
- amount (>0, numeric)

### ✔ Duplicate detection  
Enforced by a **UNIQUE constraint** in database on `dealId`.

### ✔ No rollback  
Each row is inserted independently regardless of previous failures.

### ✔ Error handling  
- 400 Bad Request → validation errors  
- 409 Conflict → duplicate deal ID  
- 500 → unexpected issue  

### ✔ Logging  
Structured logs with timestamps and error details.

---

## 📌 5. How to Run the Application

### ▶ 5.1 Clone the repository
```bash
git clone https://github.com/<your-username>/fx-deal-processor.git
cd fx-deal-processor
````

---

### ▶ 5.2 Run with Docker Compose

Use this command:

```bash
docker-compose up --build
```

This starts:

* PostgreSQL (or your database)
* Spring Boot backend

---

### ▶ 5.3 Run locally without Docker

```bash
mvn spring-boot:run
```

---

## 📌 6. API Endpoints

### ▶ Create FX Deal

**POST** `/api/deals`

#### Request body:

```json
{
  "dealId": "FX1001",
  "fromCurrency": "USD",
  "toCurrency": "EUR",
  "timestamp": "2025-01-01T12:00:00Z",
  "amount": 1200.50
}
```

#### Responses:

| Status | Meaning           |
| ------ | ----------------- |
| 201    | Deal inserted     |
| 400    | Validation failed |
| 409    | Duplicate deal    |
| 500    | Internal error    |

---

## 📌 7. Sample Data File

File: `sample-data.csv`

```
dealId,fromCurrency,toCurrency,timestamp,amount
FX1001,USD,EUR,2025-01-01T12:00:00Z,1200
FX1002,GBP,USD,2025-01-01T14:00:00Z,2100
```

---

## 📌 8. Postman Collection

Use file:
`postman_collection.json`

Import it:
**Postman → File → Import → Upload JSON file**

Includes:

* Valid deal test
* Invalid currency
* Missing fields
* Duplicate test
* Error scenarios

---

## 📌 9. K6 Performance Test

File: `loadtest.js`

Run performance test:

```bash
k6 run loadtest.js
```

Metrics generated:

* Requests per second
* Latency
* Throughput
* Error rate

---

## 📌 10. Testing Strategy

### ✔ Unit Tests (JUnit5 + Mockito)

Covers:

* Service layer
* Validation logic
* Exception handling

### ✔ Integration Tests (Testcontainers)

Tests using a real PostgreSQL instance:

* Repository layer
* Duplicate constraints
* Successful insertions

### ✔ Spring MVC Tests

Covers:

* Controller endpoints
* Request/response validation

---

## 📌 11. Makefile (Optional)

Example:

```
make build     → Build app
make test      → Run unit tests
make run       → Start Spring Boot
make docker    → Start docker-compose
make k6        → Run load tests
```

---

## 📌 12. Deployment

### ▶ Docker Deployment

```bash
docker-compose up -d
```

### ▶ Manual Deployment

Build:

```bash
mvn clean package
```

Run:

```bash
java -jar target/fx-deal-processor.jar
```

---

## 📌 13. Project Status

✔ Fully functional backend
✔ Docker-ready
✔ Validations & duplicate checks
✔ Postman tests
✔ K6 performance testing
✔ Makefile
✔ Unit + Integration + MVC tests
✔ Production-grade structure

---

## 📌 14. Author

**Rabab Mahrache**
SDET Assignment – FX Deal Processor
2025

```

---

# ✔ **COMMENT L’AJOUTER DANS TON PROJET**

### **1. Créer le fichier**
Dans ton projet :

### Sous Windows :
```

notepad README.md

```
→ colle le contenu → sauvegarde

### Sous VS Code :
```

code README.md

```
→ colle → save

---

# 🚀**COMMENT L’ENVOYER SUR GITHUB**

### 🔷 1. Vérifie que Git est initialisé

```

git init
git add .
git commit -m "Added complete README.md"

```

---

### 🔷 2. Lier le projet à GitHub

Dans GitHub → New Repository → “fx-deal-processor”

Puis dans ton terminal :

```

git remote add origin [https://github.com/](https://github.com/)<your-username>/fx-deal-processor.git
git branch -M main
git push -u origin main

```

---

### 🔷 3. Vérifier sur GitHub
➡ Le README apparaît automatiquement en bas de la page.

---

Si tu veux je peux aussi te générer :  
✔ `docker-compose.yml`  
✔ `Dockerfile`  
✔ `postman_collection.json`  
✔ `loadtest.js` optimisé  
✔ `Makefile`  
✔ `sample-data.csv`  
✔ même le **code complet du projet Spring Boot**

Dis-moi juste **ce que tu veux ensuite.**
```
