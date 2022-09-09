# Fetch user
REST API that return the list of users from https://gorest.co.in/public/v2/users. It accept an optional gender query param, that filter the retrieved list according to the gender. 

## Application running
The application can be run in two different ways: 
- using Spring Boot Maven Plugin: requires java 17 installed with maven 3.8+
- building a Docker image and running it as a container

# Springboot maven plugin
To run the application using Spring Boot Maven plugin, it is sufficient to run the following command using Maven wrapper available with this project:
```
./mvnw spring-boot:run
```

# Docker
It is possible to build a Docker image using the Dockerfile provided in the root of the project with the following command:
```
docker build -t fetchusers
```
This will produce a Docker image named fetchusers:latest
Then to run the container:
```
docker run -p 8080:8080 fetchusers
```
