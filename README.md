📝 [中文](./README-CN.md) | English

# Spring Boot Native with MyBatis-Plus Integration

A minimal example of integrating Spring Boot, Spring Native, and MyBatis-Plus. This project demonstrates how to leverage the speed of native compilation with the developer productivity of Spring Boot and MyBatis-Plus.

![Screenshot](screenshots/1.png)

## Features

- Spring Boot 3.x with native compilation
- MyBatis-Plus integration
- PostgreSQL database
- Native image configuration

---

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
```

### 3. Add MyBatis-Plus Dependencies

```xml
<dependency>
    <groupId>com.baomidou</groupId>
    <artifactId>mybatis-plus-spring-boot4-starter</artifactId>
    <version>3.5.15</version>
</dependency>
<dependency>
    <groupId>com.baomidou</groupId>
    <artifactId>mybatis-plus-jsqlparser</artifactId>
    <version>3.5.15</version>
</dependency>
```
## Configuration

### Database Setup

1. Create database and user:

```sql
CREATE USER springboot_native_demo WITH PASSWORD 'springboot_native_demo';
CREATE DATABASE springboot_native_demo OWNER springboot_native_demo;
```

2. Configure `application.yml`:

```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/springboot_native_demo
    username: springboot_native_demo
    password: springboot_native_demo
    driver-class-name: org.postgresql.Driver
```

## Building and Running

### Native Image Build

```bash
mvn -Pnative spring-boot:build-image
```

### Local Development

For local development with native compilation:

```bash
mvn -Pnative native:compile && ./target/springboot-native-demo
```

## Native Configuration

For MyBatis and MyBatis-Plus to work with GraalVM native images, check the following configuration classes:

- `com.github.crazyrunsnail.snd.config.MyBatisNativeConfiguration`
- `com.github.crazyrunsnail.snd.config.MybatisPlusRuntimeHintsRegistrar`

## Issues

Feel free to open an issue if you encounter any problems or have questions.

## License

This project is open source and available under the MIT License.