[中文](./README-CN.md)
# Spring Boot Native with MyBatis-Plus Integration

A minimal example of integrating Spring Boot, Spring Native, and MyBatis-Plus. This project demonstrates how to leverage the speed of native compilation with the developer productivity of Spring Boot and MyBatis-Plus.

![Screenshot](screenshots/1.png)

## Features

- Spring Boot 3.x with native compilation
- MyBatis-Plus integration
- PostgreSQL database
- Native image configuration

## Prerequisites

- Java 21 or higher
- Maven
- Docker (for building native image)
- PostgreSQL

## Setup

### 1. Generate Project

Create a new project using [Spring Initializer](https://start.spring.io/) with:
- Spring Web
- Lombok
- PostgreSQL
- GraalVM Native Support

### 2. Add Native Plugin

Add the following to your `pom.xml`:

```xml
<plugin>
    <groupId>org.graalvm.buildtools</groupId>
    <artifactId>native-maven-plugin</artifactId>
</plugin>