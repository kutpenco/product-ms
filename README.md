# product-ms

[![Build Status](https://travis-ci.org/codecentric/product-ms.svg?branch=master)](https://travis-ci.org/codecentric/product-ms)
[![Coverage Status](https://coveralls.io/repos/github/codecentric/product-ms/badge.svg?branch=master)](https://coveralls.io/github/codecentric/product-ms?branch=master)
[![License](http://img.shields.io/:license-apache-blue.svg)](http://www.apache.org/licenses/LICENSE-2.0.html)

Minimal [Spring Boot](http://projects.spring.io/spring-boot/) 3.0 product-ms.

## Requirements

For building and running the application you need:

- [JDK 20](https://www.oracle.com/java/technologies/javase/jdk20-archive-downloads.html)
- [Maven 3](https://maven.apache.org)

## Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `br.com.madrugas.product-ms.Application` class from your IDE.

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn spring-boot:run
```

## Deploying the application to OpenShift

The easiest way to deploy the sample application to OpenShift is to use the [OpenShift CLI](https://docs.openshift.org/latest/cli_reference/index.html):

```shell
oc new-app codecentric/springboot-maven3-centos~https://github.com/codecentric/product-ms
```

This will create:

* An ImageStream called "springboot-maven3-centos"
* An ImageStream called "product-ms"
* A BuildConfig called "product-ms"
* DeploymentConfig called "product-ms"
* Service called "product-ms"

If you want to access the app from outside your OpenShift installation, you have to expose the product-ms service:

```shell
oc expose product-ms --hostname=www.example.com
```

## Copyright

Released under the GNU General Public License v3.0. See the [LICENSE](https://github.com/kutpenco/product-ms/blob/main/LICENSE) file.
