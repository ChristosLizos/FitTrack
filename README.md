FIT TRACK
Connecting trainers and clients through smart scheduling, progress analytics, and personalized programs.
<p align="center"> <img src="src/main/resources/static/images/logo.png" alt="FitTrack Logo" width="170"> </p>
Project Status: In Production / Actively Developed

FitTrack is currently under active development. Features, APIs, and UI components may evolve as the system expands.

Overview

FitTrack is a full-stack fitness management platform built with Java, Spring Boot, Thymeleaf, and PostgreSQL.
It provides a modern ecosystem where:

Trainers can register, define their availability, and specify specializations.

Clients can create personalized profiles with fitness goals, such as weight, body fat percentage, and running time.

Both roles interact through a clean UI, including trainer search, profile dashboards, and integrated scheduling features.

The system is built with a modular architecture, following clean boundaries between controllers, services, repositories, and views.

Features
User Management

Registration with role selection (Client or Trainer)

Email, age, contact information, and secure password submission

Redirect to profile creation flow based on role

Client Features

Profile creation with:

Current metrics (weight, height)

Fitness goals (weight target, body fat %, running time)

Future support for:

Workout plans

Progress tracking dashboards

Trainer Features

Profile creation with:

Location & specialization

Weekly availability table (Mon–Sun with start/end hours)

Appears in the public Trainers Directory

Trainer Search Directory

Users can browse all registered trainers

Search filters:

Last name

Location

Specialization

Real-time results rendered with Thymeleaf

UI & UX

Modern custom branding using your Ultimate font

Fully responsive forms

Clean layout with consistent theming and a custom logo

Screens include:

Homepage

Login / Register

Trainer Directory

Trainer Profile Creation

Client Profile Creation

Screenshots
Homepage

Registration

Login

Trainer Directory

Architecture

FitTrack follows a layered, domain-driven structure:

gr.hua.fitTrack
 ├─ api
 │   └─ Controllers (HTTP endpoints)
 │
 ├─ core
 │   ├─ domain (Entities, enums, business rules)
 │   ├─ repository (Repository interfaces)
 │   └─ service (Business logic)
 │
 ├─ database
 │   └─ jpa (JPA entities, Spring Data repositories, DB mappings)
 │
 └─ FitTrackApplication.java

Flow Example: Creating a Trainer

User submits Trainer Profile Form

TrainerProfileCreationController receives request

Controller creates CreateTrainerRequest

Passed to TrainerService

Service validates, constructs domain model

Persists via JPA Repository

Returns CreateTrainerResult

Controller redirects user to /login

Database – ER Diagram

A clean conceptual diagram describing the core domain:

erDiagram

    PERSON {
        Long id
        String firstName
        String lastName
        int age
        String email
        String phone
        String passwordHash
        PersonType type
    }

    TRAINER_PROFILE {
        Long id
        Long personId
        String location
        String specialization
    }

    CLIENT_PROFILE {
        Long id
        Long personId
        int weight
        int height
        int targetWeight
        int targetBodyFat
        int runningTimeGoal
    }

    WEEKLY_SCHEDULE {
        Long id
        Long trainerId
        Weekday day
        String startTime
        String endTime
    }

    PERSON ||--|| TRAINER_PROFILE : "has one"
    PERSON ||--|| CLIENT_PROFILE : "has one"
    TRAINER_PROFILE ||--{ WEEKLY_SCHEDULE : "defines"

Tech Stack
Backend

Java 17

Spring Boot

Spring MVC

Spring Data JPA

Hibernate

PostgreSQL

Frontend

Thymeleaf

Custom CSS theme

Ultimate Font (included under /static/fonts/)

Bootstrap 5

Build

Maven

Surefire for testing

Setup Instructions
1. Clone the Repository
git clone https://github.com/YourAccount/FitTrack.git
cd FitTrack

2. Configure PostgreSQL

Create a database:

CREATE DATABASE fittrack;


Edit application.properties:

spring.datasource.url=jdbc:postgresql://localhost:5432/fittrack
spring.datasource.username=your_user
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update

3. Build & Run
mvn clean install
mvn spring-boot:run


Then open in browser:

http://localhost:8080

Roadmap
Next Features (Coming Soon)

Client workout planner

Client progress history & charts

Trainer-client appointment booking

Messaging system

Admin dashboard

API for mobile app

JWT-based authentication

License

Educational project created at Harokopio University of Athens (2025).
Not licensed for commercial use unless explicitly approved.
