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

### Build:

```bash
docker build -t patientservice:1.0 .
```

### Run:

```bash
docker run -d --link db -e DB_HOST=db -p 8080:8080 --name patientservice patientservice:1.0
```

As you need a MySQL server, you can run it in a container with the following command:

```bash
docker run -d --name db -e MYSQL_ROOT_PASSWORD=systelab -e MYSQL_DATABASE=systelab -e MYSQL_USER=systelab -e MYSQL_PASSWORD=systelab -p 3306:3306 mysql
```

Once everything is started, browse to: http://localhost:8080/PatientService-1.0/rest/patient


[git]: https://git-scm.com/
[maven]: https://maven.apache.org/download.cgi
[jdk-download]: http://www.oracle.com/technetwork/java/javase/downloads


