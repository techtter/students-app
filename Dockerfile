FROM openjdk:17-jdk-alpine AS builder
RUN mkdir -p /app/source
COPY . /app/source
WORKDIR /app/source
RUN ./mvnw clean package
#second stage
FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY --from=builder /app/source/target/*.jar /app/app.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
