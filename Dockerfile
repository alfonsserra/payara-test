### STAGE 1: Build ###

# We label our stage as 'builder'
FROM maven:alpine as builder

## Storing node modules on a separate layer will prevent unnecessary npm installs at each build
RUN mkdir /patient-service

WORKDIR /patient-service

COPY . .

## Build the angular app in production mode and store the artifacts in dist folder
RUN mvn package

### STAGE 2: Setup ###

# Using the Payara Micro 5 snapshot build.
FROM payara/micro:5-SNAPSHOT

# Maintainer of the Image
MAINTAINER Alfons Serra "alfonsoserra@gmail.com"

# Downloads the MySQL Client library
RUN wget -O /opt/payara/deployments/database-connector.jar http://central.maven.org/maven2/mysql/mysql-connector-java/5.1.46/mysql-connector-java-5.1.46.jar

# Sets database connection environment variables
ENV DB_HOST 127.0.0.1
ENV DB_PORT 3306
ENV DB_NAME systelab
ENV DB_USER systelab
ENV DB_PASSWORD systelab

# Adds an application
COPY --from=builder /patient-service/target/PatientService-1.0.war /opt/payara/deployments

# Default command to execute
ENTRYPOINT ["java", "-jar", "/opt/payara/payara-micro.jar", "--addJars", "/opt/payara/deployments/database-connector.jar", "--deploy", "/opt/payara/deployments/PatientService-1.0.war"]