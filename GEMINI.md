# Project Overview

This project, named "Mad Calc," is a simple command-line mathematical expression calculator implemented in Java. It supports basic arithmetic operations (+, -, *, /), parentheses, and functions for square root (`sqrt <number>`), power of two (`pow2 <number>`), and cube (`cube <number>`). The project is built using Maven and can be containerized using Docker.

**Main Technologies:**
*   **Language:** Java 17
*   **Build Tool:** Apache Maven
*   **Containerization:** Docker

# Building and Running

## Local Development

### Prerequisites
*   Java Development Kit (JDK) 17 or higher
*   Apache Maven

### Build
To compile the project and package it into an executable JAR file, run the following command in the project root directory:

```bash
mvn clean package
```

This will create `target/madcalc-1.0-SNAPSHOT.jar`.

### Run
To run the application locally, execute the JAR file:

```bash
java -cp target/madcalc-1.0-SNAPSHOT.jar school.madcalc.MadCalc
```

The application will then prompt you for input.

## Docker

### Build Docker Image
To build the Docker image for the application, navigate to the project root directory and run:

```bash
docker build -t madcalc:latest .
```

This command builds a multi-stage Docker image, first compiling the Java application and then creating a lightweight image to run the resulting JAR.

### Run Docker Image (with `input.txt` redirection)
The `Dockerfile` is configured to read input from `input.txt` by default. To run the application using the content of `input.txt` and see its output, use:

```bash
docker run -d madcalc:latest
# To view the output:
docker logs <container_id>
```
Replace `<container_id>` with the ID returned by the `docker run` command.

### Run Docker Image (Interactive)
To run the application interactively and provide input directly, you need to allocate a pseudo-TTY and keep `stdin` open. This command should be run directly in your local terminal:

```bash
docker run -it madcalc:latest
```
Upon execution, you will be able to type expressions directly into the container's running application.

# Development Conventions

*   **Project Structure:** Standard Maven project layout (`src/main/java`, `src/test/java`, `pom.xml`).
*   **Java Version:** Java 17.
*   **Testing Framework:** JUnit Jupiter (as indicated in `pom.xml`).
