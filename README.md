# Expense Tracker Using DevOps Tools

A simple Java Spring Boot web application to add, view, total and delete expenses. MySQL stores records. Maven builds the application; Git/GitHub maintain source code; Jenkins automates build/test and Docker image creation; Docker Compose runs the app and database.

## Requirements
- JDK 17
- Maven 3.9+
- Git
- Docker Desktop with Docker Compose
- Jenkins with Pipeline, Git and Docker access for the pipeline stage

## Run locally (without Docker)
1. Start MySQL and create database `expensedb`.
2. Set environment variables if your MySQL credentials differ:
   - `DB_URL=jdbc:mysql://localhost:3306/expensedb`
   - `DB_USERNAME=expenseuser`
   - `DB_PASSWORD=expensepass`
3. Run `mvn clean test package`
4. Run `mvn spring-boot:run`
5. Open http://localhost:8080

## Run using Docker (recommended)
From the project folder:
```bash
docker compose up --build -d
docker compose ps
docker compose logs app
```
Open http://localhost:8080. Stop with `docker compose down`. To remove stored database data too, use `docker compose down -v`.

## Git and GitHub
```bash
git init
git add .
git commit -m "Initial Expense Tracker project"
git branch -M main
git remote add origin https://github.com/YOUR-USERNAME/expense-tracker-devops.git
git push -u origin main
```
If `origin` already exists, use `git remote set-url origin YOUR-REPOSITORY-URL`.

## Jenkins
Create a Pipeline job, connect your GitHub repository, select `Jenkinsfile` from SCM, and run Build Now. The Jenkins agent must have Maven (or use a Maven-capable agent) and Docker installed and permission to access the Docker daemon. The pipeline runs tests and builds the Docker image; it does not publish the image to a registry or deploy to a cloud.

## Screenshots to capture
1. Expense Tracker running at localhost:8080 with sample entries.
2. Expense list showing added expenses and total.
3. GitHub repository files and commit history.
4. Jenkins successful pipeline stages and console output.
5. `docker images` showing `expense-tracker` image.
6. `docker compose ps` showing app and MySQL containers running.

## Notes
The sample database credentials are for a local classroom demonstration only. Do not use them for a public deployment. Replace them with secure environment variables before publishing.
