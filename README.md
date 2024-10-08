# **Table of Contents**
- [Project Presentation](#project-presentation)
- [Structure of the repository](#structure-of-the-repository)
- [Collaborators](#collaborators)
- [System Design](#system-design)
  - [Functional Requirements](#Functional-Requirements)
  - [Non-Functional Requirements](#Non-Functional-Requirements)
  - [UML Diagrams](#uml-diagrams)
  - [Project Architecture](#project-architecture)
  - [Application Mockup](#application-mockup)
  - [Build System](#build-system)
- [Good Practices](#good-practices)
  - [Integration of Design Patterns](#integration-of-design-patterns)
  - [Testing](#testing)
  - [Hashing User Passwords](#hashing-user-passwords)
  - [Storing Secrets in .properties File](#storing-secrets-in-properties-file)
- [Key Features](#key-features)
  - [Real-Time Kafka Messaging](#real-time-kafka-messaging)
  - [JWT Authentication](#jwt-auth)
  - [Multilingual Aspect](#multilingual-aspect)
  - [Scheduling](#scheduling)
- [DevOps Culture](#devops-culture)
  - [GitHub/GitLab Sync Pipeline](#github-gitlab-sync-pipeline)
  - [CI/CD Using GitLab-CI](#cicd-using-gitlab-ci)
  - [API Gateway](#api-gateway)
  - [Monitoring](#monitoring)
  - [Dashboard](#dashboard)
  - [Kubernetes + Load Balancer](#kubernetes--load-balancer)

# Project Presentation <a id="project-presentation"></a>
<div style="text-align: center;">
  <img src="https://i.ibb.co/vj7xmFZ/logo.png" alt="drawing" width="200">
</div>
<b>SporterZ</b> is a social platform designed specifically for soccer fans. It offers an interactive space where fans can exchange ideas, receive notifications about their favorite teams' matches, and take part in live discussions with other fans in rooms dedicated to teams or matches. Users can vote on match results, share publications on their profile and create their own chat rooms. In addition, SporterZ features private messaging and external sharing. The platform's interface is organized to present both suggested and user-followed content.
<br/> <br/> 

# Collaborators <a id="collaborators"></a>

<table>
  <tbody>
    <tr>
      <td align="center" valign="top" width="16.66%"><a href="https://www.linkedin.com/in/ilyas-abdellaoui/"><img src="https://avatars.githubusercontent.com/u/79768267?v=4s=120" width="120px;" alt="Ilyas ABDELLAOUI"/>
      <br /> <sub><b>Ilyas ABDELLAOUI</b></sub></a></td>
      <td align="center" valign="top" width="16.66%"><a href="https://www.linkedin.com/in/myassineboumehdi/"><img src="https://avatars.githubusercontent.com/u/115194839?v=4s=120" width="120px;" alt="Ilyas ABDELLAOUI"/>
      <br /> <sub><b>Mohammed-Yassine BOUMEHDI</b></sub></a></td>
      <td align="center" valign="top" width="16.66%"><a href="https://www.linkedin.com/in/saidnajim/"><img src="https://avatars.githubusercontent.com/u/85839515?v=4s=120" width="120px;" alt="Ilyas ABDELLAOUI"/>
      <br /> <sub><b>Said NAJIM</b></sub></a></td>
      <td align="center" valign="top" width="16.66%"><a href="https://www.linkedin.com/in/adnane-mandili-12997b251/"><img src="https://avatars.githubusercontent.com/u/112574330?v=4s=120" width="120px;" alt="Ilyas ABDELLAOUI"/>
      <br /> <sub><b>Adnane MANDILI</b></sub></a></td>
    </tr>
  </tbody>
<table>

# Structure of the repository
![Structure of the repo](https://i.ibb.co/GFcCfw6/Capture-d-cran-2024-05-27-030036.png)

# System Design <a id="system-design"></a>
## Functional Requirements <a id="Functional-Requirements"></a>

### Authentication and Login
* Account creation
* Single Sign-On (SSO) login


### Messaging
* Sending and receiving private messages
* New message notifications

### Team Tracking
* Stay informed about favorite teams
* Notifications about news and events
* View match results

### Access to Team-Dedicated Chat Rooms
* Participate in discussions
* View messages from other users
* Join chat rooms for ongoing matches and favorite teams
* Interact with other users

### Viewing Other Users' Posts
* Like and comment on posts
* Share posts

### Sharing Posts
* Share to your profile
* Share posts to other social networks
* Share posts to private conversations
* Share posts to joined chat rooms

### Viewing Joined Chat Rooms
* Ability to leave a chat room

### Editing Your Profile
* Modify photo, name, bio, etc.
* Modify preferences (language, notifications)

### Creating Chat Rooms
* Create your own chat rooms
* Choose a topic
* Invite other users

## Non-Functional Requirements <a id="Non-Functional-Requirements"></a>

### Security
* Ensure the security of user data
* Secure login to the platform
* User authentication and authorization
* Encryption of sensitive data
* Protection against XSS, CSRF, SQL injection attacks, etc.

### Performance
* Fast response time for user actions
* Ability to handle a large number of users

### Scalability
* Adapt to the growth in the number of users

### Maintenance
* Easy to maintain and update

### Availability
* Platform accessible 24/7
* High availability rate

### Rate Limiting
* Limit the number of requests per user to prevent abuse

### Logging and Monitoring
* Log events and errors (Prometheus, Grafana)
* Monitor platform performance

### UML Diagrams
#### Use Case Diagram
![Figure 1: Diagramme de cas d’utilisation](https://www.plantuml.com/plantuml/png/ZPB1QlCm48JlUeh5b_-K5_W98QNGGo6jQTfBRq9UnwAojaZhb53wxgsbn7ZHHRVix7oHPgnzP1ru6fros3CmGR2dWQ6p0GrRyaeRfW1l4GFe2Ctyer5gtcf_SWZ7JmgCuVrR0KmHZOu8pJrvZoRzN-iqznJ6PiQl-arR8qVq7RJ1dZKZ7316VSAOe7bp4mJ1-W9FnBQts44VQ8G7VQPW6U4LzPZfsNKphUb7iXwa_n-y45snUPqc4Mj0ym4jHSwcDATHt6lG0LUkD1UknAPZi5kTc-Ii5iSVgBFz1Tf0lNMOx5cwAaMyEyEJTd3GR0OiukLjNigh1TICyFpbLqGM_xHyBGNvJMmsE_61X2wgNtJHxIAABXTrwKvwPKbY9nfPBOh8WYhIYL3P8jyk_8VjrdhZfWvtEmKYROr_QQ76lBHJvKwjrRgBDciOqN85KBPV0uclKa6e7xL7tqsZ-mK0)

#### Sequence Diagram
The interaction between the frontend, Nginx (acting as a proxy), and the backend (Spring Cloud Gateway), where Nginx forwards requests and injects the appropriate CORS headers into the responses to authorize frontend access.
![](https://i.ibb.co/4ZwyL3J/Capture-d-cran-2024-05-27-031842.png)

## Project Architecture
#### First Version
<div style="text-align: center;">
  <img src="https://i.ibb.co/NNwWD8k/sys-Design1.jpg" alt="Secrets" width="full">
</div>

#### Updated Version
<div style="text-align: center;">
  <img src="https://i.ibb.co/JkWQHG7/sys-Design.jpg" alt="Secrets" width="full">
</div>

## Application Mockup   

![Figure 2: Acceuil et navigation](https://i.ibb.co/R6bqMR0/HOME.png)

## Build System
<div style="text-align: center;">
  <img src="https://i.ibb.co/tQyk8DY/build.png" alt="build" width="full">
</div>

We utilized the maven-multimodule approach, which allowed us to organize our codebase into multiple, independent modules within a single project. 
The maven-multimodule setup enabled us to define dependencies between modules, share common configurations, and build and package each microservice independently

## Good Practices

### Integration of Design Patterns
#### Proxy Pattern
The **Proxy Pattern** is effectively present in your architecture through the use of the API Gateway. 

This gateway acts as a proxy, managing access and communication between clients and microservices, and adding additional functionalities such as request transformation, logging, access control and caching.

#### Observer pattern
We use the **Observer pattern** in an Angular application to handle HTTP requests. 

The AppHttpInterceptor class implements the HttpInterceptor interface to intercept HTTP requests and append an authorization token to the headers, unless the request is for authentication or registration. 

This interception is part of the Observer pattern where the interceptor observes HTTP requests and modifies them as needed before passing them along the handler chain. 

### Testing
<div style="text-align: center;">
  <img src="https://i.ibb.co/NmqhJGX/testing.png" alt="testing" width="full">
</div>

For testing our microservices, we employed the following features:

- @SpringBootTest annotation from Spring Boot's test utilities to load the entire application context for integration testing.
- @AutoConfigureMockMvc annotation to automatically configure MockMvc, a utility class provided by Spring Test for performing mock requests against the application's controllers.
- JUnit 5 to write and execute our unit and integration tests.

### Hashing User Passwords

<div style="text-align: center;">
  <img src="https://i.ibb.co/8780RwF/passHash.png" alt="passwordHashing" width="full">
</div>

### Storing Secrets in .properties File

<div style="text-align: center;">
  <img src="https://i.ibb.co/jkx2Srv/propre.png" alt="Secrets" width="full">
</div>

## Key Features

### Real-Time Kafka Messaging

**Krafana's real-time messaging service** sends messages to specific topics, where creating a new chat room means creating a new topic. 
An embedded Kafka implementation is used to avoid the need for running a Kafka server locally.

### JWT Auth

<div style="text-align: center;">
  <img src="https://i.ibb.co/h2yKsqM/jwt.png" alt="Secrets" width="full">
</div>

### Multilingual Aspect

<div style="text-align: center;">
  <img src="https://i.ibb.co/MfZbLpn/multi-Lung.png" alt="Secrets" width="full">
</div>


For multilingual support in our Angular application, we utilized Angular's i18n tooling.

This involved generating translation files using the `ng xi18n` command, which extracted translatable text from the application's templates and components.

These translation files were then translated for each supported language.

During the build process, Angular's Ahead-of-Time (AoT) compiler utilized these translation files to generate language-specific bundles.

### Scheduling

In the UpdateMatchesBoard class, the dailyMatchesBoardUpdate method is annotated with @Scheduled(cron = "0 5 * * *"). 

This cron expression specifies that the method should be executed every 5 minutes.

The method clears an existing matches board, retrieves match data from an external football API, and updates the matches board with the fetched data.

## DevOps Culture

### GitHub/GitLab Sync Pipeline

<div style="text-align: center;">
  <img src="https://i.ibb.co/r4FvXF3/sync.png" alt="Secrets" width="full">
</div>

### CI/CD Using GitLab-CI

<div style="text-align: center;">
  <img src="https://i.ibb.co/GHPftyz/CI-CD.jpg" alt="Secrets" width="full">
</div>

### API Gateway

<div style="text-align: center;">
  <img src="https://i.ibb.co/TmwBnhq/api-Gateway.png" alt="Secrets" width="full">
</div>

### Monitoring

<div style="text-align: center;">
  <img src="https://i.ibb.co/CBnRdxV/prometheus.png" alt="Secrets" width="full">
</div>

### Dashboard

<div style="text-align: center;">
  <img src="https://i.ibb.co/RDtYdbS/grafana.png" alt="Secrets" width="full">
</div>

### Kubernetes + Load Balancer

<div style="text-align: center;">
  <img src="https://i.ibb.co/HTBjcb9/dockerhub.png" alt="Secrets" width="full">
</div>
<div style="text-align: center;">
  <img src="https://i.ibb.co/whpsKdP/k8s.png" alt="Secrets" width="full">
</div>
