<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
</head>
<body>

<h1><img src="src/main/resources/static/images/logo.png" alt="FitTrack Logo" width="140"/>
    FitTrack – Fitness Management Platform</h1>



<p><strong>Status:</strong> In Production / Actively Developed</p>

<p><strong>Academic Note:</strong>  
This project was developed as part of a university course at Harokopio University of Athens, focusing on full-stack application architecture, software engineering practices, and database-driven system design.</p>

<p>
FitTrack is a full-stack fitness management system built with Java, Spring Boot, Thymeleaf, and PostgreSQL. 
It provides an ecosystem where clients create fitness profiles with personal goals, while trainers define weekly 
availability and specializations. Users can browse trainers through a searchable directory, and the platform 
maintains a clean architecture with well-defined layers. The app is a 
</p>

<hr>

<h2>Overview</h2>

<p>The platform supports:</p>

<ul>
    <li>Client and Trainer registration flows</li>
    <li>Client profile creation with metrics and goals</li>
    <li>Trainer profile creation with weekly availability</li>
    <li>A searchable public Trainers Directory</li>
    <li>Custom interface using the Ultimate font and FitTrack branding</li>
</ul>

<hr>

<h2>Features</h2>

<h3>User Management</h3>
<ul>
    <li>Role selection during registration</li>
    <li>Email, age, and contact information collection</li>
    <li>Secure password submission</li>
    <li>Automatic redirect to role-specific profile forms</li>
</ul>

<h3>Client Features</h3>
<ul>
    <li>Current metrics: weight, height</li>
    <li>Goals: target weight, body fat %, running time</li>
</ul>

<h3>Trainer Features</h3>
<ul>
    <li>Location and specialization fields</li>
    <li>Full weekly schedule (Mon–Sun) with start/end hours</li>
    <li>Visibility in the public Trainer Directory</li>
</ul>

<h3>Trainer Directory</h3>
<ul>
    <li>List of all trainers</li>
    <li>Filters by last name, location, and specialization</li>
    <li>Rendered dynamically using Thymeleaf</li>
</ul>

<h3>UI & Branding</h3>
<ul>
    <li>Custom theme using the Ultimate font (stored in <code>/static/fonts/</code>)</li>
    <li>Responsive forms and consistent layout</li>
    <li>Pages include: Homepage, Login, Register, Profile Creation, Trainer Directory</li>
</ul>

<hr>

<h2>Project Structure</h2>

<pre>
gr.hua.fitTrack
├── api
│   └── Controllers (HTTP endpoints)
├── core
│   ├── domain       (Entities, enums, domain logic)
│   ├── repository   (Repository interfaces)
│   └── service      (Business logic)
├── database
│   └── jpa          (JPA entities, ORM mappings)
└── FitTrackApplication.java
</pre>

<hr>

<h2>Domain Model</h2>

<h3>Core Tables</h3>
<ul>
    <li>Person</li>
    <li>TrainerProfile</li>
    <li>ClientProfile</li>
    <li>WeeklySchedule</li>
</ul>

<h3>Relationships</h3>
<ul>
    <li>One Person → One TrainerProfile</li>
    <li>One Person → One ClientProfile</li>
    <li>One TrainerProfile → Many WeeklySchedule entries</li>
</ul>

<hr>

<h2>Tech Stack</h2>

<h3>Backend</h3>
<ul>
    <li>Java 17 / 21</li>
    <li>Spring Boot</li>
    <li>Spring MVC</li>
    <li>Spring Data JPA</li>
    <li>Hibernate</li>
    <li>PostgreSQL</li>
</ul>

<h3>Frontend</h3>
<ul>
    <li>Thymeleaf</li>
    <li>Custom CSS + Ultimate font</li>
    <li>Bootstrap 5</li>
</ul>

<h3>Build</h3>
<ul>
    <li>Maven</li>
    <li>Surefire test runner</li>
</ul>

<hr>

<h2>Setup Instructions</h2>

<h3>1. Clone the Repository</h3>
<pre>
git clone https://github.com/YourAccount/FitTrack.git
cd FitTrack
</pre>

<h3>2. Create the PostgreSQL Database</h3>
<pre>
CREATE DATABASE fittrack;
</pre>

<h3>3. Configure application.properties</h3>
<pre>
spring.datasource.url=jdbc:postgresql://localhost:5432/fittrack
spring.datasource.username=your_user
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
</pre>

<h3>4. Build & Run</h3>
<pre>
mvn clean install
mvn spring-boot:run
</pre>

<h3>5. Open in Browser</h3>
<pre>
http://localhost:8080
</pre>

<hr>

<h2>Roadmap</h2>

<ul>
    <li>Client progress tracking & charts</li>
    <li>Workout planner system</li>
    <li>Trainer–client appointment booking</li>
    <li>Internal messaging</li>
    <li>Admin dashboard</li>
    <li>REST API for mobile app</li>
    <li>JWT authentication</li>
</ul>

<hr>

<h2>License</h2>
<p>
Academic project created at Harokopio University of Athens (2025).  
Not permitted for commercial use without explicit approval.
</p>

</body>
</html>
