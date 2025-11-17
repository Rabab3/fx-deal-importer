.PHONY: run test build docker-up docker-down coverage

run:
	mvn spring-boot:run

build:
	./mvnw -DskipTests package

test:
	mvn clean test

coverage:
	mvn clean verify

docker-up:
	docker compose up --build -d

docker-down:
	docker compose down
