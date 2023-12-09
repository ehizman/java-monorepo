VERSION 0.7
FROM openjdk:17-jdk-alpine

# Install Maven
RUN apk add --update --no-cache maven

# Set the Maven home directory
ENV MAVEN_HOME /usr/share/maven

# Add Maven binaries to the system PATH
ENV PATH $MAVEN_HOME/bin:$PATH

# Verify Maven installation
RUN mvn --version

# Set the working directory
WORKDIR /app

build:
    COPY pom.xml ./pom.xml
    COPY libraries libraries
    COPY services services
    RUN mvn clean install
    RUN mvn package

    SAVE ARTIFACT services/service1/target/**.jar /services/one
    SAVE ARTIFACT services/service2/target/**.jar /services/two

test:
    COPY pom.xml ./pom.xml
    COPY libraries libraries
    COPY services services
    RUN mvn clean install
    RUN mvn test

docker:
    COPY +build/services/one .
    ENTRYPOINT ["java", "-jar", "service1-app.jar"]
    SAVE IMAGE --push service-one:latest

    COPY +build/services/two .
    ENTRYPOINT ["java", "-jar", "service2-app.jar"]
    SAVE IMAGE --push service-two:latest

