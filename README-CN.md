[English](./README.md) | 📝 中文

# Spring Boot 原生应用与 MyBatis-Plus 集成示例

一个集成了 Spring Boot、Spring Native 和 MyBatis-Plus 的最小化示例项目。本项目展示了如何结合使用原生编译的速度优势与 Spring Boot 和 MyBatis-Plus 的开发效率。

![截图](screenshots/1.png)

## 功能特性

- 基于 Spring Boot 3.x 的原生应用
- 集成 MyBatis-Plus
- 使用 PostgreSQL 数据库
- 原生镜像配置

---

## 环境要求

- Java 21 或更高版本
- Maven
- Docker（用于构建原生镜像）
- PostgreSQL 数据库

## 项目搭建

### 1. 创建项目

使用 [Spring Initializer](https://start.spring.io/) 创建新项目，选择以下依赖：
- Spring Web
- Lombok
- PostgreSQL
- GraalVM Native Support

### 2. 添加 Native 插件

在 `pom.xml` 中添加：

```xml
<plugin>
    <groupId>org.graalvm.buildtools</groupId>
    <artifactId>native-maven-plugin</artifactId>
</plugin>
```

### 3. 添加 MyBatis-Plus 依赖

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

## 配置说明

### 数据库设置

1. 创建数据库和用户：

```sql
CREATE USER springboot_native_demo WITH PASSWORD 'springboot_native_demo';
CREATE DATABASE springboot_native_demo OWNER springboot_native_demo;
```

2. 配置 `application.yml`：

```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/springboot_native_demo
    username: springboot_native_demo
    password: springboot_native_demo
    driver-class-name: org.postgresql.Driver
```

## 构建和运行

### 原生镜像构建

```bash
mvn -Pnative spring-boot:build-image
```

### 本地开发

本地开发环境中的原生编译：

```bash
mvn -Pnative native:compile && ./target/springboot-native-demo
```

## 原生配置

要让 MyBatis 和 MyBatis-Plus 在 GraalVM 原生镜像中正常工作，请检查以下配置类：

- `com.github.crazyrunsnail.snd.config.MyBatisNativeConfiguration`
- `com.github.crazyrunsnail.snd.config.MybatisPlusRuntimeHintsRegistrar`

## 问题反馈

如果您遇到任何问题或有疑问，欢迎提交 Issue。

## 许可证

本项目为开源项目，基于 MIT 许可证发布。