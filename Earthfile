VERSION 0.7


deps:
    FROM openjdk:17-jdk-alpine
    RUN apk add --update --no-cache maven
    COPY ./pom.xml .
    RUN mvn clean install
    RUN mvn compile
    RUN mvn package

build:
    BUILD ./services+build

all-unit-test:
    BUILD ./libs+unit-test
    BUILD ./services+unit-test

all-docker:
    BUILD ./services+docker
