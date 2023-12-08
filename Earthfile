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

    SAVE ARTIFACT services/service1/target/**.jar AS LOCAL services/service-one/
    SAVE ARTIFACT services/service2/target/**.jar AS LOCAL services/service-two/

docker:
     COPY +build service-one
     ENTRYPOINT ["/app/service-one"]
     SAVE IMAGE service1:latest

     COPY +build service-two
     ENTRYPOINT ["/app/service-two"]
     SAVE IMAGE service2:latest