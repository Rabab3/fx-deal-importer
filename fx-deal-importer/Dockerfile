# Dockerfile
FROM eclipse-temurin:21-jdk AS build
WORKDIR /app
# copy maven wrapper or use host maven
COPY .mvn/ .mvn
COPY mvnw .
COPY pom.xml .
RUN chmod +x mvnw
# download dependencies
RUN ./mvnw dependency:go-offline -B

COPY src ./src
RUN ./mvnw -DskipTests package -B

# runtime image
FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=build /app/target/fx-deal-importer-1.0.0.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app/app.jar"]
