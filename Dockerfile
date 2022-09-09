FROM maven:3.8.4-openjdk-17 as builder
COPY . ./
RUN mvn clean install

FROM openjdk:17-alpine
COPY --from=builder /target/*.jar app.jar 

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "./app.jar"]
