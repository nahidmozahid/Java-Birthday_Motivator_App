# Birthday Motivator Web Application

A simple Spring Boot web application that asks users for their date of birth, calculates their age, and if it’s their birthday, displays a randomly selected motivational speech to wish them. The app is Dockerized for easy containerized deployment.

#Features
User inputs date of birth via a web form

Calculates age dynamically

Wishes user a happy birthday with a random motivational speech on their birthday

Responsive and simple UI with Thymeleaf templates

Dockerized for easy deployment

---

## Project Structure

birthday-motivator-web/
│
├── Dockerfile
├── pom.xml
│
└── src/
└── main/
├── java/
│ └── com/
│ └── example/
│ └── birthdaymotivator/
│ ├── BirthdayMotivatorWebApplication.java
│ └── controller/
│ └── BirthdayController.java
│
└── resources/
├── templates/
│ └── index.html
└── application.properties

## Prerequisites

- Java 17 or higher  
- Maven  
- Docker (optional, for containerized deployment)

---

## Running Locally (without Docker)

1. Clone the repository:
git clone <YOUR_REPO_URL>
cd birthday-motivator-web

mvn spring-boot:run

http://localhost:8080/

#Building and Running with Docker
docker build -t birthday-motivator-web .

docker run -d --restart unless-stopped -p 8080:8080 birthday-motivator-web

#Troubleshooting
If you cannot access the app, ensure port 8080 is free and properly mapped

Check Docker container status with docker ps and logs with docker logs <container_id>

Ensure your Java and Maven versions meet prerequisites


