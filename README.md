# Payara Micro Example
Example based on an article published in the [Java Magazine](http://www.javamagazine.mozaicreader.com/MarApr2018) 

## Getting Started

To get you started you can simply clone the `payara-test` repository and install the dependencies:

### Prerequisites

You need [git][git] to clone the `payara-test` repository.

You will need [Java™ SE Development Kit 8][jdk-download] and [Maven][maven].

### Clone `payara-test`

Clone the `payara-test` repository using git:

```bash
git clone https://github.com/systelab/payara-test.git
cd seed-jee
```

### Install Dependencies

In order to install the dependencies you must run:

```bash
mvn install
```

## Standard Configuration

Run the SQL script on an Apache Derby database that is installed on the host machine to load the schema.  Then
modify the Dockerfile environment variables in order to connect to the database from within the container.

Build the sources for the PatientService using Maven to create the *PatientService-1.0.war* file.

### Build:

```bash
docker build -t patientservice:1.0 .
```

### Run:

```bash
docker run -d -p 8080:8080 --name patientservice patientservice:1.0
```

[git]: https://git-scm.com/
[maven]: https://maven.apache.org/download.cgi
[jdk-download]: http://www.oracle.com/technetwork/java/javase/downloads


